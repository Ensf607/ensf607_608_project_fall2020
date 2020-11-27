package server;

import server.controller.ServerController;

import java.io.IOException;

public class startServerLocal {
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
