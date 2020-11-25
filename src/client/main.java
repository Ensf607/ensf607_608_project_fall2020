package client;

import client.controller.Client;
import client.controller.ModelController;
import client.controller.ViewController;

public class main {
    public static void main(String[] args) {
        System.out.println("connecting to the backed server hosted at aws ... ");
        Client c =new Client("54.185.156.100", 9090);
        ModelController mc =new ModelController(c);
        ViewController vc=new ViewController(mc);
    }
}
