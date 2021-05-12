package HomeWork6;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client {

    public static void main (String[] args) throws IOException {

        Socket server = null;
        try {
            server = new Socket(Constants.HOST, Constants.PORT);
        } catch (UnknownHostException e) {
            System.err.println(e);
            System.exit(1);
        }

        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        new Thread(new Runnable() {
            @Override
            public void run() {
                String msg;
                while (true) {
                    try {
                        msg = stdIn.readLine();
                        out.writeUTF(msg);
                        System.out.println("Server: " + in.readUTF());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



    }
}


