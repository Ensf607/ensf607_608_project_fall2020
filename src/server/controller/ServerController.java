package server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Server class implementation where it accepts clients and communicate via
 * sockets
 *
 */

public class ServerController {
	private Socket aSocket;
	private ServerSocket serverSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private ExecutorService pool;

	/**
	 * Initialize serverSocket and pool
	 */
	public ServerController() {
		try {
			serverSocket = new ServerSocket(9090);
			pool = Executors.newFixedThreadPool(10);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Communicates with client and executes threads once there is two clients
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void runServer() throws IOException, InterruptedException {
		try {
			while (true) {
				aSocket = serverSocket.accept();
				socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
				socketOut = new PrintWriter(aSocket.getOutputStream(), true);
				
				ModelController im =new ModelController(this);
				pool.execute(im);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Good Bye!");
		socketIn.close();
		socketOut.close();
	}
	
	/**
	 * Based on message the client will decode and print the respective form of table on GUI
	 * Send a jason object {message: displayTool,tool:[]}
	 */
	public void send() {
		
	}


	/**
	 * Recieve jason object from client in {message: purchase,itemID:2,Quantity:5}
	 * get requests example: { "type": "get", "table": "ORDER_", "scope": "all"}
	 **/
	public void recieve() {
		
	}

	public static void main(String[] args) throws IOException {
		ServerController myServer = new ServerController();
		System.out.println("Server is now running.");
		try {
			myServer.runServer();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
