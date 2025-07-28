/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import controller.Controller;
import db.DatabaseBroker;
import db.DatabaseConnection;
import domain.Upravnik;
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
    private Sender sender;
    private Receiver receiver;
    Controller controller;

    public Server() {
        controller = new Controller();
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Waiting for conn!");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected!");
            sender = new Sender(clientSocket);
            receiver = new Receiver(clientSocket);

            while (true) {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                switch (request.getOperation()) {
                    case Login:
                        Upravnik upravnik = controller.login((Upravnik) request.getArgument());
                        response.setResult(upravnik);
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
