/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.net.ServerSocket;
import java.net.Socket;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.Sender;

/**
 *
 * @author Ognjen
 */
public class Server {

    ServerSocket serverSocket;

    public Server() {
    }

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Waiting for conn!");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected!");
            Sender sender = new Sender(clientSocket);
            Receiver receiver = new Receiver(clientSocket);

            while (true) {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                switch (request.getOperation()) {
                    case Login:
                        //TODO
                        break;
                    default:
                        throw new AssertionError();
                }
                sender.send(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Server se pokvario!\n" + e.getMessage());
        }
    }
}
