package HomeWork6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Server {


    public static void main(String[] args) {

        DataInputStream in;
        DataOutputStream out;
        BufferedReader stdIn;
        Socket socket;
        try(ServerSocket serverSocket = new ServerSocket(Constants.PORT)){
            System.out.println("Server started. Wait for connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            stdIn = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                String msg = stdIn.readLine();
                out.writeUTF(msg);
                try {
                    System.out.println("Client: " + in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
