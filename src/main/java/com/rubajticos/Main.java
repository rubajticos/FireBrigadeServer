package com.rubajticos;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static int n = 0;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

//        UserDAO u = new UserDAO();
//        System.out.println(u.login("rubajticos", "admin123"));


        try {
            serverSocket = new ServerSocket(1200);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (serverSocket != null) {
                    socket = serverSocket.accept();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            n++;
            new ServerThread(socket, n).start();
            System.out.println("START");
        }

    }
}
