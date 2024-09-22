package modele.metier;

import java.util.List;

import Dao.DaoFilm;
import Dao.IDaoFilm;
import modele.entities.Film;

public class ModeleFilm {
    private Film film;
    private IDaoFilm daoFilm = new DaoFilm();

    public List<Film> getAllFilms() {
        return daoFilm.getAllFilms();
    }

    public Film addFilm() {
        Film f = null;
        f = this.daoFilm.addFilm(film.getNom(), film.getBudget(), film.getCategorie(), film.getAge());
        return f;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
