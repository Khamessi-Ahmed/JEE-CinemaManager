<%@ page import="modele.entities.SalleCinema" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des salles</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">

    <h1>Liste des salles</h1>
    
    <div class="row justify-content-end mb-3">
    
        </div>
        
    <table class="table">
    <thead >
        <tr>
            <th>#</th>
            <th>Nom de la salle</th>
            <th>Capacité de la salle</th>
            <th>Adresse de la salle</th>
            <th>Actions</th>
        </tr>
        </thead>
        <% 
            List<SalleCinema> list = (List<SalleCinema>) request.getAttribute("list");
            if (list != null) {
                for (SalleCinema salle : list) {
        %>
        <tr>
            <td><%= salle.getId() %></td>
            <td><%= salle.getNom() %></td>
            <td><%= salle.getCapacite() %></td>
            <td><%= salle.getAdresse() %></td>
            <td>
                <a href="ModifierSalle.jsp?id=<%= salle.getId() %>" class="btn btn-primary">Modifier</a>
                <form action="ServletListSalle" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= salle.getId() %>">
                    <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette salle?')" class="btn btn-danger">
                </form>
            </td>
        </tr>
        <% 
                }
            }
        %>
    </table>
    </div>
    <a href="ajoutSalle.jsp" class="btn btn-success mb-3">Ajouter une salle</a>
    </body>
    
</html>