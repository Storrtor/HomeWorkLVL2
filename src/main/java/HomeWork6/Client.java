package HomeWork6;

import java.io.*;
import java.net.Socket;


class Client {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    BufferedReader stdIn;

    public Client(){
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) throws IOException {
        new Client();
    }


    private void openConnection() throws IOException {
        socket = new Socket(Constants.HOST, Constants.PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        stdIn = new BufferedReader(new InputStreamReader(System.in));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String msg = stdIn.readLine();
                        if(msg.equals(Constants.STOP_WORD)){
                            //closeConnection();    Не совсем понимаю где закрывать, если закрывать тут, то ошибки вылазят
                            break;
                        }
                        out.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Client shutting down the server");
                closeConnection();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Server: " + in.readUTF());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    /**
     * Не понимаю как правильно закрыть потоки, дропает ошибку постоянно.
     * Так что метод просто так, пусть будет, может подскажешь как это правильно сделать и пригодится.
     */
    public void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stdIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


