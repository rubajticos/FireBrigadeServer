package com.rubajticos;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket socket;
    private int id;

    ServerThread(Socket s, int n) {
        this.socket = s;
        this.id = n;
    }

    public void run() {
        BufferedReader bufferedReader = null;
        DataOutputStream dataOutputStream = null;
        String line;

        try {
            InputStream inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        while (true) {
        try {
            line = bufferedReader.readLine();
            System.out.printf("Odebralem tekst: %s\n", line);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        }
    }
}
