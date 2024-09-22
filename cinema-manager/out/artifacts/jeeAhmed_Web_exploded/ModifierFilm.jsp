<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifier un film</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body style="display:flex; align-items:center; justify-content:center;">
<div class="form">
    <h3><i class="fa-solid fa-pen-to-square"></i></h3><br>
    <form action="filmServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" id="id" name="id" value="<%= request.getParameter("id") %>">
        <div class="form-group">
            <label for="nom">Nom du film :</label><br>
            <input type="text" id="nom" name="nom" value="${film.nom}" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="budget">Budget du film :</label><br>
            <input type="number" id="budget" name="budget" value="${film.budget}" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="categorie">Catégorie du film :</label><br>
            <input type="text" id="categorie" name="categorie" value="${film.categorie}" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="age">Âge recommandé :</label><br>
            <input type="number" id="age" name="age" value="${film.age}" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Modifier</button>
    </form>
</div>
</body>
</html>
