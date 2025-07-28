/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Upravnik;
import so.Login;

/**
 *
 * @author Ognjen
 */
public class Controller {

    public Upravnik login(Upravnik upravnik) throws Exception {
        Login login = new Login();
        login.execute(upravnik);
        return login.getUpravnik();
    }
}
