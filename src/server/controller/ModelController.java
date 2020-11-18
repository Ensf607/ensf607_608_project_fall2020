package server.controller;

import java.io.IOException;

public class ModelController {

	
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
