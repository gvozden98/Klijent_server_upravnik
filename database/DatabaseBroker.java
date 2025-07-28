/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mysql.cj.jdbc.ConnectionImpl;
import domen.Korisnik;
import domen.RecnikUnos;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ognjen
 */
public class DatabaseBroker {

    public Korisnik getKorisnik(Korisnik korisnik) throws SQLException {
        try {
            String query = "SELECT id, ime, prezime, email, loggedIn FROM user WHERE email=? AND password=?";
            System.out.println("Upit: " + query);
            PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, korisnik.getEmail());
            ps.setString(2, korisnik.getSifra());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                korisnik.setId(rs.getInt("id"));
                korisnik.setIme(rs.getString("ime"));
                korisnik.setPrezime(rs.getString("prezime"));
                korisnik.setPrijavljen(true);
                korisnik.setEmail(rs.getString("email"));
            } else {
                korisnik = null;
            }

            rs.close();
            ps.close();
            System.out.println("Uspesno ucitavanje korisnika iz baze!\n" + korisnik.toString());

        } catch (SQLException e) {
            System.out.println("Greska pri ucitavanju korisnika iz baze!\n" + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return korisnik;
    }

    public void changeStatusOfLogin(Korisnik korisnik, int status) throws SQLException {
        try {
            String query = "UPDATE user SET loggedIn = " + status + " WHERE email=?";
            System.out.println("query: " + query);

            PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, korisnik.getEmail());
            ps.executeUpdate();
            ps.close();
            System.out.println("Korisnik je sada ulogovan!\n" + korisnik.toString());

        } catch (Exception e) {
            System.out.println("Greska pri ucitavanju korisnika iz baze!\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Korisnik> getKorisnici() throws SQLException {
        ArrayList<Korisnik> korisnici = new ArrayList<>(); // Create the list to return

        try {
            String query = "SELECT id, ime, prezime, email, loggedIn FROM user";
            System.out.println("Upit: " + query);

            Statement st = DatabaseConnection.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Korisnik k = new Korisnik();
                k.setId(rs.getInt("id"));
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setEmail(rs.getString("email"));
                k.setPrijavljen(rs.getBoolean("loggedIn"));
                korisnici.add(k);
            }
            rs.close();
            st.close();
            System.out.println("Uspesno ucitavanje svih korisnika iz baze!\n" + korisnici.toString());
        } catch (SQLException e) {
            System.out.println("Greska pri uzimanju korisnika iz baze\n" + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return korisnici;

    }

    public ArrayList<RecnikUnos> getRecnik() throws SQLException {

        ArrayList<RecnikUnos> recnik = new ArrayList<>();
        try {
            String query = "SELECT * FROM recnik";
            System.out.println("Upit: " + query);

            Statement st = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RecnikUnos recnikUnos = new RecnikUnos();
                recnikUnos.setId(rs.getInt("id"));
                recnikUnos.setRec(rs.getString("rec"));
                String prevodi = rs.getString("prevodi");
                recnikUnos.setPrevodiZaRec(prevodi.split(";"));
                recnik.add(recnikUnos);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Greksa pri uzimanju recnika!\n" + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return recnik;
    }

    public RecnikUnos getRec(String rec) {
        RecnikUnos recnikUnos = new RecnikUnos();
        try {
            String query = "SELECT * FROM recnik WHERE rec = ?";
            System.out.println("Query: \n" + query);
            PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, rec);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                recnikUnos.setId(rs.getInt("id"));
                recnikUnos.setRec(rec);
                String prevodi = rs.getString("prevodi");
                recnikUnos.setPrevodiZaRec(prevodi.split(";"));
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Greska pri dohvatanju reci");
        }
        return recnikUnos;
    }

    public void addWord(RecnikUnos recnikUnos) {
        try {
            String query = "INSERT INTO recnik (rec, prevodi) values (?,?)";
            System.out.println("Query:" + query);

            PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, recnikUnos.getRec());
            ps.setString(2, String.join(";", recnikUnos.getPrevodiZaRec()));
            ps.executeUpdate();
            ps.close();
            System.out.println("Uspesno dodavanje prevoda");
        } catch (Exception e) {
            System.out.println("Greska pri dodavanju prevoda");

        }
    }
}
