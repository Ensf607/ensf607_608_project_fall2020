package client.controller;

import view.GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
	public void communicate() throws InterruptedException {
		
		String line = "";
		String response = "";
		boolean running = true;
		Scanner scan =new Scanner(System.in);
		while (running) {
			sleep();
			try {
//				line = socketIn.readLine();
				line = "test";
				System.out.println("request is:"+line);

				socketOut.println(line); // sending client request
				response = socketIn.readLine(); // receiving server response

				System.out.println("(Response): \n"+ response);

			} catch (IOException e) {
				System.out.println("Sending error: " + e.getMessage());
			}

		}
		try {
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.println("Closing error: " + e.getMessage());
		}

	}

	private void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
			
	public static void main(String[] args) throws IOException {
		Client aClient = new Client("localhost", 9090);
		try {
			aClient.communicate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
