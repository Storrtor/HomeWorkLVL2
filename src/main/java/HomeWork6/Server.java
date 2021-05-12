package HomeWork6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Server {

    public static void main(String[] args) {
        Socket socket = null;
        try(ServerSocket serverSocket = new ServerSocket(Constants.PORT)){
            System.out.println("Server started. Wait for connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while(true){
                if(!((msg = stdIn.readLine()) != null)) {
                    break;
                }
                out.println(msg);
                try {
                    System.out.println("Client: " + in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Server shutting down");
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
