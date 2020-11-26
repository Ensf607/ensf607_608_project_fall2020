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
 */
public class ServerController {
	private ServerSocket serverSocket;
	private ExecutorService pool;
	private Socket aSocket;

	private PrintWriter socketOut;
	private BufferedReader socketIn;

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
     * Gets socket.
     *
     * @return the socket
     */
    public Socket getaSocket() {
		return aSocket;
	}

    /**
     * Communicates with client and executes threads once there is two clients
     *
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    public void communicate() throws IOException, InterruptedException {
		try {
			while (true) {
				System.out.println("(check) communicate tag");
				aSocket = serverSocket.accept();
				socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
				socketOut = new PrintWriter(aSocket.getOutputStream(), true);
				ThreadPool threadPool = new ThreadPool(this);
				pool.execute(threadPool);
				System.err.println("Accepted connection");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Good Bye!");
		pool.shutdown();
		socketIn.close();
		socketOut.close();
	}

    /**
     * Based on message the client will decode and print the respective form of table on GUI
     * Send a jason object {message: displayTool,tool:[]}
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */


    public static void main(String[] args) throws IOException {
		ServerController myServer = new ServerController();
		System.out.println("Server is now running.");
		try {
			myServer.communicate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
