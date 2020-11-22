package _test;


import client.controller.Client;

import java.io.IOException;

public class ClientRemoteServerTest {
    public static void main(String[] args) {
        Client aClient = new Client("54.185.156.100", 9090);
        try {
            aClient.communicate();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

