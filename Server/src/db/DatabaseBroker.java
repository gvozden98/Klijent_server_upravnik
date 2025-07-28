/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Upravnik;
import java.sql.*;

/**
 *
 * @author Ognjen
 */
public class DatabaseBroker {

    public Upravnik getUpravnik(Upravnik upravnik) throws SQLException {
        try {
            String query = "SELECT id, ime FROM upravnik WHERE ime = ? AND sifra = ?";
            System.out.println("Upit:\n" + query);
            PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, upravnik.getIme());
            ps.setString(2, upravnik.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                upravnik.setId(rs.getInt("id"));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Greska pri prihvatanju upravnika iz baze!\n" + e.getMessage());
        }
        return upravnik;
    }

}
