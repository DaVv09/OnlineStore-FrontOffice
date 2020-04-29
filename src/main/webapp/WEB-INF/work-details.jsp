<%--
  Created by IntelliJ IDEA.
  User: DaVv
  Date: 28/04/2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détails de l'oeuvre</title>
</head>
<body>
Titre: ${requestScope.selectedWork.title}<br/>
Date de parution: ${requestScope.selectedWork.release}<br/>
Genre: ${requestScope.selectedWork.genre}<br/>
Artiste: ${requestScope.selectedWork.mainArtist.name}<br/>
Résumé: ${requestScope.selectedWork.summary}<br/>
<form action="addToCart" method="post">
    <input type="hidden" name="idSelectionAchat" value="${requestScope.selectedWork.id}"><br/> <!-- value a modifier -->
    <input type="submit" value="ajouter au panier"><br/>
</form>
</body>
</html>
