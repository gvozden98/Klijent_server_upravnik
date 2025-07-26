/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Ognjen
 */
public class Upravnik implements Serializable {

    private int id;
    private String ime;
    private String password;

    public Upravnik() {
    }

    public Upravnik(int id, String ime, String password) {
        this.id = id;
        this.ime = ime;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return "Upravnik{" + "id=" + id + ", ime=" + ime + ", password=" + password + '}';
    }

}
