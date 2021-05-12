package HomeWork6;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client {
    private static int port = 3334;
    private static String host = "localhost";

    public static void main (String[] args) throws IOException {

        Socket server = null;

        try {
            server = new Socket(host, port);
        } catch (UnknownHostException e) {
            System.err.println(e);
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(server.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String msg;

        while ((msg = stdIn.readLine()) != null) {
            out.println(msg);
            System.out.println("Server: " + in.readLine());
        }

    }
}


