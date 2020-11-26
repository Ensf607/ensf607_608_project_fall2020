package client.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Implementation of the client class. This class communicates with the server
 * via sockets and invokes the GUI to display, also communicates with
 * {@link } if there are any actions occurred in the GUI
 *
 */
public class Client {

	private PrintWriter socketOut;
	private Socket palinSocket;
	private BufferedReader socketIn;


	/**
	 * Ctor to initialize @param
	 * 
	 * @param serverName
	 * @param portNumber
	 */
	public Client(String serverName, int portNumber) {
		try {
			palinSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(palinSocket.getInputStream()));
			socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	public String send(String json) throws IOException {

		System.out.println("SENDNG MSG TO  RequestHandler on SERVER SIDE....via sockets and wait for response");
		System.err.println(json);
		socketOut.println(json);
		String response=getServerResponse();
		return response;
		
	}
	/**
	 * This method is responsible with communicating with Server and GUI
	 * 
	 * @throws InterruptedException
	 */
	public void communicate() throws InterruptedException, IOException {
		
	
		boolean running = true;
		while (running) {
//			sleep(500);

		}
		try {
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.println("Closing error: " + e.getMessage());
		}

	}
	


	public String getServerResponse() throws IOException {
		String s="";
		String line = "";
		while ((line = socketIn.readLine()) != null) {
			s += line;
			if (!socketIn.ready()){
				sleep(100); //manually introduce delay
				if (!socketIn.ready())
					break;
			}
		}
		return s;
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String [] arg) {
		Client c =new Client("localhost", 9090);
		ModelController mc =new ModelController(c);
		ViewController vc=new ViewController(mc);
	}
	
}
			
