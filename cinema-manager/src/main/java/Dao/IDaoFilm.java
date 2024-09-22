package Dao;

import java.util.List;
import modele.entities.Film;

public interface IDaoFilm {
    public List<Film> getAllFilms();
    public Film addFilm(String nom, double budget, String categorie, int age);
    public int update(Film film);
    public void delete(int id);
    public Film getFilmById(int id);
}