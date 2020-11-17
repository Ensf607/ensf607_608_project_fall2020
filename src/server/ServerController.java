package server;

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
				JDBC connector =new JDBC();//assuming no login for now
				
				InventoryManager im =new InventoryManager(socketIn,socketOut,connector.getConn());
				pool.execute(im);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Good Bye!");
		socketIn.close();
		socketOut.close();
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
