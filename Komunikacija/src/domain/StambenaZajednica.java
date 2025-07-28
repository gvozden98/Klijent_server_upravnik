/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Ognjen
 */
public class StambenaZajednica {

    private int id;
    private String naziv;
    private String adresa;
    private String mesto;
    private Upravnik upravnik;

    public StambenaZajednica() {
    }

    public StambenaZajednica(int id, String naziv, String adresa, String mesto, Upravnik upravnik) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.mesto = mesto;
        this.upravnik = upravnik;
    }

    public Upravnik getUpravnik() {
        return upravnik;
    }

    public void setUpravnik(Upravnik upravnik) {
        this.upravnik = upravnik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return "StambenaZajednica{" + "id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", mesto=" + mesto + ", upravnik=" + upravnik + '}';
    }

}
