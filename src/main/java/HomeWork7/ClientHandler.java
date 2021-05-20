package HomeWork7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Обслуживает клиента (отвечает за связь между клиентом и сервером)
 */
public class ClientHandler {

    private MyServer server;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer server, Socket socket) {
        try{
            this.server = server;
            this.socket = socket;
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        authentication();
                        readMessages();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }
                }
            }).start();
        } catch (IOException ex){
            System.out.println("Problem with client creating");
        }

    }

    private void readMessages() throws IOException {
        while (true){
            String messageFromClient = inputStream.readUTF();
            System.out.println("from " + name + ": " + messageFromClient); //отправка только в консоль, никуда больше
            if(messageFromClient.equals(ChatConstants.STOP_WORD)){
                return;
            }
            if(messageFromClient.startsWith(ChatConstants.PRIVATE_MESSAGE)){
                server.broadcastMessageToOne(name ,"[" + name + "]: " + messageFromClient);
            } else {
                server.broadcastMessage("[" + name + "]: " + messageFromClient); //распространение сообщения по всем клиентам
            }


        }
    }

    // /auth login pass
    private void authentication() throws IOException {
        while (true){
            String message = inputStream.readUTF();
            if(message.startsWith(ChatConstants.AUTH_COMMAND)) {
                String[] parts = message.split("\\s+");
                String nick = server.getAuthService().getNickByLoginAndPass(parts[1], parts[2]);
                if (nick != null) {
                    //проверим, что такого пока нет
                    if(!server.isNickBusy(nick)){
                        sendMsg(ChatConstants.AUTH_OK + " " + nick);
                        name = nick;
                        server.subscribe(this);
                        server.broadcastMessage(name + " entered the chat");
                        return;
                    } else {
                        sendMsg("Nick is already in use");
                    }
                } else {
                    sendMsg("Incorrect login/pass");
                }
            }

        }

    }

    public void sendMsg(String message) {
        try {
            outputStream.writeUTF(message); //отправка сообщения от сервера клиенту
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        server.unsubscribe(this);
        server.broadcastMessage(name + " left the chat");
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
