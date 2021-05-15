package HomeWork7;

import javax.xml.stream.events.EntityReference;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Непосредственно сервер
 */
public class MyServer {

    private List<ClientHandler> clients;
    private AuthService authService;

    public MyServer(){
        try (ServerSocket server = new ServerSocket(ChatConstants.PORT)) {
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while(true){
                System.out.println("Server is waiting for connection");
                Socket socket = server.accept(); //получение клиента (ожидаем подключение клиента)
                System.out.println("Client connected");
                new ClientHandler(this, socket);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(authService != null){
                authService.stop();
            }
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public synchronized boolean isNickBusy(String nick) {
        return clients.stream().anyMatch(client -> client.getName().equals(nick));
        //поток клиентов, если хоть один совпадает - верни true (ник занят)
        //allMatch все должны подходить под условие, если хоть одно не полходит - false

//        for (ClientHandler client : clients){      //перебираем всех клиентов и если ник занят, возвращаем что он занят
//            if (client.getName().equals(nick)){
//                return true;
//            }
//        } return false;
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    /**
     * Отправляет сообщения всем пользователям
     */
    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> client.sendMsg(message));   //юзание стрим фильтра

//        for(ClientHandler client : clients){   отправка сообщения всем всем всем
//            client.sendMsg(message);
//        }
    }

    public synchronized void broadcastMessageToOne(String name, String message) {
        String[] parts = message.split("\\s+");
        List<String> list = new ArrayList<>(Arrays.asList(parts));
        String address = list.get(2);
        list.remove(1);
        list.remove(1);
        String messageBack = String.join(" ", list);
        clients.stream()
                .filter(clients -> clients.getName().equals(address) || clients.getName().equals(name))
                .forEach(client -> client.sendMsg(messageBack));
//        for (ClientHandler client : clients) {
//            if(client.getName().equals(address) || client.getName().equals(name)){
//                client.sendMsg(messageBack);
//            }
//        }
    }

}
