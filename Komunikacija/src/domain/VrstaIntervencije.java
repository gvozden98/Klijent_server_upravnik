/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Ognjen
 */
public class VrstaIntervencije {

    private int id;
    private String vrstaIntervencije;

    public VrstaIntervencije() {
    }

    public VrstaIntervencije(int id, String vrstaIntervencije) {
        this.id = id;
        this.vrstaIntervencije = vrstaIntervencije;
    }

    public String getVrstaIntervencije() {
        return vrstaIntervencije;
    }

    public void setVrstaIntervencije(String vrstaIntervencije) {
        this.vrstaIntervencije = vrstaIntervencije;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VrstaIntervencije{" + "id=" + id + ", vrstaIntervencije=" + vrstaIntervencije + '}';
    }

}
