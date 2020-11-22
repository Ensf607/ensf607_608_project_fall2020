package server.controller;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

import server.model.Shop;

public class ModelController implements Runnable{
    private ResultSet rs;
	ServerController server;
	Shop shop;
	JDBC jdbc;
	poolThread thread;

	public ModelController(ServerController server) throws IOException {
		this.server=server;
		jdbc=new JDBC();
		this.thread=new poolThread(server.getaSocket());
	}

	@Override
	public void run() {
		while(true) {
			sleep();
			try {
				String message = thread.stdIn();
				System.out.println("client message: "+message);
			} catch (IOException e) {
				e.printStackTrace();
			}
			thread.stdOut("server ready.");
//			System.out.println("model controller running");

		}
	}

	private void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class poolThread {
	private final PrintWriter socketOut;
	/**
	 * The A socket.
	 */
	private final Socket aSocket;
	/**
	 * The Std in.
	 */
	private final BufferedReader stdIn;

	poolThread(Socket aSocket) throws IOException {
		this.aSocket = aSocket;
		this.stdIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
		this.socketOut = new PrintWriter(new OutputStreamWriter(aSocket.getOutputStream()), true);
	}

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

	public void stdOut(String message) {
		socketOut.println(message);
	}

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
