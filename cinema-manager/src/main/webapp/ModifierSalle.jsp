<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier une salle</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body style="display:flex; align-items:center; justify-content:center;">
<div class="form">
<h3><i class="fa-solid fa-pen-to-square"></i></h3><br>
<form action="ServletListSalle" method="post">
<input type="hidden" name="action" value="update">
<input type="hidden" id="id" name="id" value="<%= request.getParameter("id") %>">
<div class="form-group">
        <label for="nomSalle">Nom de la salle :</label><br>
        <input type="text" id="nom" name="nom" value="${salle.nom}" class="form-control" required>
        </div>
        <div class="form-group">
        <label for="capaciteSalle">Capacité de la salle :</label><br>
        <input type="number" id="capacite" name="capacite" value="${salle.capacite}" class="form-control" required>
        </div>
        <div class="form-group">
        <label for="statutSalle">Adresse de la salle :</label><br>
			 <input type="text" id="adresse" name="adresse" value="${salle.adresse}" class="form-control" required>


        </div>
        <button type="submit" class="btn btn-success">Modifier</button>
</form>
</div>
</body>
</html>