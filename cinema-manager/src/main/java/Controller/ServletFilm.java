package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.entities.Film;
import modele.metier.ModeleFilm;

import java.io.IOException;
import java.util.List;

import Dao.DaoFilm;

@WebServlet("/filmServlet")
public class ServletFilm extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ModeleFilm modeleFilm = new ModeleFilm();
    private DaoFilm dao;

    public void init() {
        this.dao = new DaoFilm();
    }

    public ServletFilm() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            double budget = Double.parseDouble(request.getParameter("budget"));
            String categorie = request.getParameter("categorie");
            int age = Integer.parseInt(request.getParameter("age"));

            Film film = new Film(id, nom, budget, categorie, age);
            dao.update(film);

            response.sendRedirect("ServletFilm");

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);

            response.sendRedirect("ServletFilm");

        } else if ("add".equals(action)) {
            String nom = request.getParameter("nom");
            double budget = Double.parseDouble(request.getParameter("budget"));
            String categorie = request.getParameter("categorie");
            int age = Integer.parseInt(request.getParameter("age"));

            this.modeleFilm.setFilm(new Film(0, nom, budget, categorie, age));
            this.modeleFilm.addFilm();

            response.sendRedirect("ServletFilm");
        } else {
            // Gérer d'autres actions ou traitements ici si nécessaire
            // Par exemple, afficher un message d'erreur ou rediriger vers une page spécifique
            response.sendRedirect("errorPage.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categorie = request.getParameter("categorie");
        if (categorie != null && !categorie.isEmpty()) {
            // Si la catégorie est spécifiée, effectuer la recherche par catégorie
            List<Film> filmsByCategorie = dao.getFilmsByCategorie(categorie);
            request.setAttribute("list", filmsByCategorie);
        } else {
            // Sinon, récupérer tous les films
            List<Film> allFilms = dao.getAllFilms();
            request.setAttribute("list", allFilms);
        }

        request.getRequestDispatcher("ListFilm.jsp").forward(request, response);
    }



}