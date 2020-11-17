package frontEnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Implementation of the client class. This class communicates with the server
 * via sockets and invokes the GUI to display, also communicates with
 * {@link GUIActions} if there are any actions occurred in the GUI
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
			try {
				response = socketIn.readLine();
				System.out.println(response);
				if (response.indexOf("Menu")!=-1)
					
				{	int i=6;
					while(i>0)
					{
					response = socketIn.readLine();
					System.out.println(response);
					i--;
					}
					
					
					int temp=scan.nextInt();
					System.err.println(temp);
					socketOut.println(temp);
					
				}
				

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
			
	public static void main(String[] args) throws IOException {
		Client aClient = new Client("localhost", 9090);
		try {
			aClient.communicate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
