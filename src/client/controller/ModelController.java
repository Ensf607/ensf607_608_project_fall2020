package client.controller;

import java.io.IOException;



public class ModelController implements Observer{
	private Client c;
	/**
	 * ctor to set Client object
	 * @param c
	 */
	public ModelController(Client c) {
		this.c=c;
	
	}
	/**
	 * implement the method in Observer interface
	 */
	public String request(String json) {
		
		System.out.println("GOT A MESSAGE FROM GUI EVENT");
		
		try {
			String response =c.send(json);
			System.out.println("Got response from server !!");
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}


}
