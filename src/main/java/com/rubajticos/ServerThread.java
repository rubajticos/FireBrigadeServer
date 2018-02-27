package com.rubajticos;

import com.google.gson.Gson;
import com.rubajticos.database.FireBrigadeDAO;
import com.rubajticos.database.UserDAO;
import com.rubajticos.model.FireBrigade;
import com.rubajticos.model.User;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    final static Logger logger = Logger.getLogger(UserDAO.class);

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

        while (true) {
            try {
                line = bufferedReader.readLine();
                if (!line.equals(null)) {
                    System.out.println("LINE: " + line);
                }
                switch (line) {
                    case "register":
                        Gson gson = new Gson();
                        UserDAO userDAO = new UserDAO();
                        FireBrigadeDAO fireBrigadeDAO = new FireBrigadeDAO();
                        System.out.println("Zaczynam rejestracje");
                        User user = gson.fromJson(bufferedReader.readLine(), User.class);
                        user.printUser();
                        user = userDAO.save(user);

                        FireBrigade fireBrigade = gson.fromJson(bufferedReader.readLine(), FireBrigade.class);
                        fireBrigade.setUser(user);
                        fireBrigade = fireBrigadeDAO.insert(fireBrigade);

                        System.out.println("Koniec rejestracji");
                        String result = gson.toJson(fireBrigade);
                        System.out.println("wynik: " + result);

                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
            }
        }
    }
}
