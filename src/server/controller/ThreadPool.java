package server.controller;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

import com.fasterxml.jackson.core.JsonProcessingException;
import server.model.Shop;

/**
 * The type Thread pool.
 */
public class ThreadPool implements Runnable{
    private ResultSet rs;
    /**
     * The Server.
     */
    ServerController server;
    /**
     * The Shop.
     */
    Shop shop;
    /**
     * The Jdbc.
     */
    JDBC jdbc;
    /**
     * The Thread.
     */
    connThread thread;

    /**
     * Instantiates a new Thread pool.
     *
     * @param server the server
     * @throws IOException the io exception
     */
    public ThreadPool(ServerController server) throws IOException {
		this.server=server;
		jdbc=new JDBC();
		this.thread=new connThread(server.getaSocket());
	}

	@Override
	public void run() {
		while(true) {
			String request = "";
			String response = "";
			try {
				request = thread.stdIn();
				System.out.println("client request: "+request);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Request r = new Request();
			try {
				response = r.requestHandler(request);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			thread.stdOut(response);


//			System.out.println("model controller running");
			sleep(100);
		}
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * The type Conn thread.
 */
class connThread {
	private final PrintWriter socketOut;
	/**
	 * The A socket.
	 */
	private final Socket aSocket;
	/**
	 * The Std in.
	 */
	private final BufferedReader stdIn;

    /**
     * Instantiates a new Conn thread.
     *
     * @param aSocket the a socket
     * @throws IOException the io exception
     */
    connThread(Socket aSocket) throws IOException {
		this.aSocket = aSocket;
		this.stdIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
		this.socketOut = new PrintWriter(new OutputStreamWriter(aSocket.getOutputStream()), true);
	}

    /**
     * Std in string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public String stdIn() throws IOException {
		StringBuffer buffer = null;
		while (true) {
			if (buffer == null) {
				buffer = new StringBuffer(stdIn.readLine());
			} else {
				break;
			}
		}
		String string = buffer.toString();
		return string;
	}

    /**
     * Std out.
     *
     * @param message the message
     */
    public void stdOut(String message) {
		socketOut.println(message);
	}

    /**
     * Exit.
     */
    public void exit(){
		socketOut.close();
		try {
			stdIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			aSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
