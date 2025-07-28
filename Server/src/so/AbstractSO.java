/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DatabaseBroker;
import db.DatabaseConnection;
import java.sql.SQLException;

/**
 *
 * @author Ognjen
 */
public abstract class AbstractSO {

    protected DatabaseBroker dbbr;

    public AbstractSO() {
        this.dbbr = new DatabaseBroker();
    }

    public final void execute(Object object) throws Exception {
        try {
            validate(object);
            executeOperation(object);
            commit();
        } catch (Exception e) {
            rollback();
            throw new Exception("Greska pri izvrsavanju operacije!\n" + e.getMessage());
        } finally {
            disconnect();
            System.out.println("Konekcija prekinuta!");
        }

    }

    private void commit() throws SQLException {
        DatabaseConnection.getInstance().getConnection().commit();
    }

    private void rollback() throws SQLException {
        DatabaseConnection.getInstance().getConnection().rollback();
    }

    private void disconnect() throws SQLException {
        DatabaseConnection.getInstance().getConnection().close();
    }

    protected abstract void executeOperation(Object object) throws Exception;

    protected abstract void validate(Object object) throws Exception;

}
