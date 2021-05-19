package HomeWork6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Server {


    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(Constants.PORT)){
            System.out.println("Server started. Wait for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            String msg = stdIn.readLine();
                            if(msg.equals(Constants.STOP_WORD)){
                                break;
                            }
                            out.writeUTF(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Server shutting down");
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            System.out.println("Client: " + in.readUTF());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t1.start();
            t2.start();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }


}
