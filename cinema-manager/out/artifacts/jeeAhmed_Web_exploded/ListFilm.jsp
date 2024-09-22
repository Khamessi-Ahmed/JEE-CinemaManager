<%@ page import="modele.entities.Film" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des films</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Liste des films</h1>

    <div class="row justify-content-end mb-3">
        <!-- Formulaire de recherche par catégorie -->
        <form action="ServletFilm" method="get" class="form-inline">
            <div class="form-group mx-sm-3 mb-2">
                <label for="categorie" class="sr-only">Catégorie</label>
                <input type="text" class="form-control" id="categorie" name="categorie" placeholder="Catégorie">
            </div>
            <button type="submit" class="btn btn-primary mb-2">Rechercher</button>
        </form>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Nom du film</th>
            <th>Budget du film</th>
            <th>Catégorie du film</th>
            <th>Âge recommandé</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Film> list = (List<Film>) request.getAttribute("list");
            if (list != null) {
                for (Film film : list) {
        %>
        <tr>
            <td><%= film.getId() %></td>
            <td><%= film.getNom() %></td>
            <td><%= film.getBudget() %></td>
            <td><%= film.getCategorie() %></td>
            <td><%= film.getAge() %></td>
            <td>
                <!-- Add action links for editing and deleting films -->
                <a href="ModifierFilm.jsp?id=<%= film.getId() %>" class="btn btn-primary">Modifier</a>
                <form action="ServletFilm" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= film.getId() %>">
                    <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce film?')" class="btn btn-danger">
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <!-- Add a link to add a new film -->
    <a href="ajoutFilm.jsp" class="btn btn-success mb-3">Ajouter un film</a>
</div>
</body>
</html>
