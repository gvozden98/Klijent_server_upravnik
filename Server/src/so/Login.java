/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DatabaseBroker;
import domain.Upravnik;

/**
 *
 * @author Ognjen
 */
public class Login extends AbstractSO {

    private Upravnik upravnik;

    @Override
    protected void executeOperation(Object object) throws Exception {
        upravnik = dbbr.getUpravnik((Upravnik) object);
    }

    @Override
    protected void validate(Object object) throws Exception {

    }

    public Upravnik getUpravnik() {
        return upravnik;
    }

}
