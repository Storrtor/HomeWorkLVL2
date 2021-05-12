package HomeWork6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Server {
    private static int port = 3334;

    public static void main (String[] args) throws IOException {

        class ClientConn implements Runnable {
            private Socket client;

            ClientConn(Socket client) {
                this.client = client;
            }

            public void run() {
                BufferedReader in = null;
                PrintWriter out = null;
                BufferedReader stdIn = null;
                try {
                    in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    out = new PrintWriter(client.getOutputStream(), true);
                    stdIn = new BufferedReader(new InputStreamReader(System.in));
                } catch (IOException e) {
                    System.err.println(e);
                    return;
                }

                String msg = null;

                while (true) {
                    try {
                        if (!((msg = stdIn.readLine()) != null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    out.println(msg);
                    try {
                        System.out.println("Client: " + in.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.err.println(e);
            System.exit(1);
        }

        Socket client = null;
        while(true) {
            try {
                client = server.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.err.println(e);
                System.exit(1);
            }
            Thread t = new Thread(new ClientConn(client));
            t.start();
        }
    }
}
