package com.rubajticos;

import java.net.Socket;

public class ServerThread extends Thread {

    private Socket socket;
    private int id;

    ServerThread(Socket s, int n) {
        this.socket = s;
        this.id = n;
    }

    public void run() {
        // TODO: 30/01/2018 ServerThread methods
    }
}
