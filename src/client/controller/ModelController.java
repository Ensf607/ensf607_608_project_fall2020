package client.controller;

import java.io.IOException;



public class ModelController implements Observer{
	private Client c;
	public ModelController(Client c) {
		this.c=c;
	
	}
	/**
	 * This method is used by you gui whenever a button is pressed
	 * @param json
	 * @return
	 */
	public String request(String json) {
		//sends msg to server/ and gets response
		
		System.out.println("GOT A MESSAGE FROM GUI EVENT");
		
		try {
			String response =c.send(json);
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
public static void main (String [] arg) {
	Client c =new Client("localhost", 9090);
	ModelController mc =new ModelController(c);
	ViewController vc=new ViewController(mc);
}

}
