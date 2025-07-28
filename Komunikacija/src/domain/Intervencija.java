/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ognjen
 */
public class Intervencija implements Serializable {

    private int id;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private String opis;
    private boolean izvodjac;
    private double cena;
    private String status;
    private VrstaIntervencije vrstaIntervencije;
    private StambenaZajednica stambenaZajednica;
    private int upravnikID;

    public Intervencija() {
    }

    public Intervencija(int id, Date datumPocetka, Date datumZavrsetka, String opis, boolean izvodjac, double cena, String status, VrstaIntervencije vrstaIntervencije, StambenaZajednica stambenaZajednica, int upravnikID) {
        this.id = id;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.opis = opis;
        this.izvodjac = izvodjac;
        this.cena = cena;
        this.status = status;
        this.vrstaIntervencije = vrstaIntervencije;
        this.stambenaZajednica = stambenaZajednica;
        this.upravnikID = upravnikID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isIzvodjac() {
        return izvodjac;
    }

    public void setIzvodjac(boolean izvodjac) {
        this.izvodjac = izvodjac;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VrstaIntervencije getVrstaIntervencije() {
        return vrstaIntervencije;
    }

    public void setVrstaIntervencije(VrstaIntervencije vrstaIntervencije) {
        this.vrstaIntervencije = vrstaIntervencije;
    }

    public StambenaZajednica getStambenaZajednica() {
        return stambenaZajednica;
    }

    public void setStambenaZajednica(StambenaZajednica stambenaZajednica) {
        this.stambenaZajednica = stambenaZajednica;
    }

    public int getUpravnikID() {
        return upravnikID;
    }

    public void setUpravnikID(int upravnikID) {
        this.upravnikID = upravnikID;
    }

    @Override
    public String toString() {
        return "Intervencija{" + "id=" + id + ", datumPocetka=" + datumPocetka + ", datumZavrsetka=" + datumZavrsetka + ", opis=" + opis + ", izvodjac=" + izvodjac + ", cena=" + cena + ", status=" + status + ", vrstaIntervencije=" + vrstaIntervencije + ", stambenaZajednica=" + stambenaZajednica + ", upravnikID=" + upravnikID + '}';
    }

}
