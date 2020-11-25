package client.controller;

<<<<<<< HEAD
import view.GUI;
=======
>>>>>>> develop_ziad

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
	private BufferedReader stdIn;
	GUI gui;



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
			initGUI();
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
	 * initialize GUI
	 */
	private void initGUI() {
		this.gui = new GUI();
		//TODO: @Ziad, connect gui items to event listeners
	}

	/**
	 * This method is responsible with communicating with Server and GUI
	 * 
	 * @throws InterruptedException
	 */
	public void communicate() throws InterruptedException, IOException {
		
	
		boolean running = true;
		while (running) {
<<<<<<< HEAD
			sleep(500);
			//				line = socketIn.readLine();
			// TODO: need to connect GUI to get line value (request string)
			line = "{ \"type\" : \"GET\", \"table\" : \"TOOL\" , \"scope\":\"all\"}";
			System.out.println("request is:"+line);

			socketOut.println(line); // sending client request
//			response = socketIn.lines().collect(Collectors.joining());; // receiving server response
			response = getServerResponse();

			System.out.println("(Response): \n"+ response);
=======
//			sleep(500);
>>>>>>> develop_ziad

		}
		try {
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.println("Closing error: " + e.getMessage());
		}

	}
<<<<<<< HEAD
=======
	
>>>>>>> develop_ziad


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
<<<<<<< HEAD
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
			
	public static void main(String[] args) throws IOException {
		Client aClient = new Client("localhost", 9090);
=======
>>>>>>> develop_ziad
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}}
			
