package client.controller;

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
	private ServerSideRequestHandler sendMSG;

	/**
	 * Ctor to initialize @param
	 * 
	 * @param serverName
	 * @param portNumber
	 */
	public Client(String serverName, int portNumber) {
		sendMSG=new ServerSideRequestHandler();//NOTE: its just a test, this must be on server side
//		try {
//			palinSocket = new Socket(serverName, portNumber);
//			socketIn = new BufferedReader(new InputStreamReader(palinSocket.getInputStream()));
//			socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
//			
//		} catch (IOException e) {
//			System.err.println(e.getStackTrace());
//		}
	}
	
	public String send(String json) throws IOException {
		//THIS WHAT U WILL HAVE
//		socketOut.print(json);//sends request
//		StringBuffer sb =new StringBuffer();
//		String line=socketIn.readLine();
//		sb.append(line);
//		while(line!=null) {
//			line=socketIn.readLine();
//		sb.append(line);}
//		return sb.toString();
		
		//TEST
		System.out.println("SENDNG MSG TO  RequestHandler on SERVER SIDE....via sockets and wait for response");
		String response=sendMSG.getResponse(json);
	return response;
		
	}}
			
