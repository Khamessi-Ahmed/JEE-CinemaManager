package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.entities.Film;
import utilitaire.SingletonConnexion;

public class DaoFilm implements IDaoFilm {
    private Connection con = SingletonConnexion.getCon();

    @Override
    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();

        try {
            String query = "SELECT * FROM film";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setId(rs.getInt(1));
                film.setNom(rs.getString(2));
                film.setBudget(rs.getDouble(3));
                film.setCategorie(rs.getString(4));
                film.setAge(rs.getInt(5));
                films.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    @Override
    public Film addFilm(String nom, double budget, String categorie, int age) {
        Film film = new Film();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO film (nom, budget, categorie, age) VALUES (?, ?, ?, ?)");
            ps.setString(1, nom);
            ps.setDouble(2, budget);
            ps.setString(3, categorie);
            ps.setInt(4, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return film;
    }

    @Override
    public int update(Film film) {
        int status = 0;
        try {
            String query = "UPDATE film SET nom=?, budget=?, categorie=?, age=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, film.getNom());
            ps.setDouble(2, film.getBudget());
            ps.setString(3, film.getCategorie());
            ps.setInt(4, film.getAge());
            ps.setInt(5, film.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM film WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film getFilmById(int id) {
        Film film = null;
        try {
            String query = "SELECT * FROM film WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nom");
                double budget = rs.getDouble("budget");
                String categorie = rs.getString("categorie");
                int age = rs.getInt("age");
                film = new Film(id, nom, budget, categorie, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }
    public List<Film> getFilmsByCategorie(String categorie) {
        List<Film> films = new ArrayList<>();

        try {
            String query = "SELECT * FROM film WHERE categorie = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categorie);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                double budget = rs.getDouble("budget");
                int age = rs.getInt("age");

                // Créer un objet Film avec les données récupérées de la base de données
                Film film = new Film(id, nom, budget, categorie, age);
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }
}
