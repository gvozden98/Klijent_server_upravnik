/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package UIController;

import domain.Upravnik;
import java.net.Socket;
import komunikacija.Receiver;
import komunikacija.Sender;
import java.sql.*;
import komunikacija.Operacija;
import komunikacija.Request;
import komunikacija.Response;

/**
 *
 * @author Ognjen
 */
public class Controller {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Controller instance;

    private Controller() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Upravnik login(Upravnik upravnik) throws Exception {

        Request request = new Request(Operacija.Login, upravnik);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (Upravnik) response.getResult();

    }
}
