package _test;


import client.controller.Client;

import java.io.IOException;

/**
 * The type Client remote server test.
 */
public class ClientRemoteServerTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Client aClient = new Client("54.185.156.100", 9090);
        try {
            aClient.communicate();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

