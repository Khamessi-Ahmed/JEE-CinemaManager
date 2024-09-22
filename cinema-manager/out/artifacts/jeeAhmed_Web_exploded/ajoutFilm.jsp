<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un film</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Ajouter un film</h1>
    <form action="ServletFilm" method="post">
        <input type="hidden" name="action" value="add">
        <div class="form-group">
            <label for="nom">Nom du film :</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="budget">Budget du film :</label>
            <input type="number" class="form-control" id="budget" name="budget" required>
        </div>
        <div class="form-group">
            <label for="categorie">Catégorie du film :</label>
            <input type="text" class="form-control" id="categorie" name="categorie" required>
        </div>
        <div class="form-group">
            <label for="age">Âge recommandé :</label>
            <input type="number" class="form-control" id="age" name="age" required>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>
</body>
</html>
