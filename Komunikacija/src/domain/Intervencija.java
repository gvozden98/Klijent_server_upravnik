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
    private String zajednica;
    private String vrstaIntervencije;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private String opis;
    private boolean izvodjac;
    private String status;
    private int upravnikID;

    public Intervencija() {
    }

    public Intervencija(int id, String zajednica, String vrstaIntervencije, Date datumPocetka, Date datumZavrsetka, String opis, boolean izvodjac, String status, int upravnikID) {
        this.id = id;
        this.zajednica = zajednica;
        this.vrstaIntervencije = vrstaIntervencije;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.opis = opis;
        this.izvodjac = izvodjac;
        this.status = status;
        this.upravnikID = upravnikID;
    }

    public int getUpravnikID() {
        return upravnikID;
    }

    public void setUpravnikID(int upravnikID) {
        this.upravnikID = upravnikID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZajednica() {
        return zajednica;
    }

    public void setZajednica(String zajednica) {
        this.zajednica = zajednica;
    }

    public String getVrstaIntervencije() {
        return vrstaIntervencije;
    }

    public void setVrstaIntervencije(String vrstaIntervencije) {
        this.vrstaIntervencije = vrstaIntervencije;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Intervencija{" + "id=" + id + ", zajednica=" + zajednica + ", vrstaIntervencije=" + vrstaIntervencije + ", datumPocetka=" + datumPocetka + ", datumZavrsetka=" + datumZavrsetka + ", opis=" + opis + ", izvodjac=" + izvodjac + ", status=" + status + ", upravnikID=" + upravnikID + '}';
    }

}
