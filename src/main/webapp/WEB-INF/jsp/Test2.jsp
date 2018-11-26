<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:th="http://www.thymeleaf.org" lang="en">


    <head>
        <meta charset="utf-8">
        <title>Jolly Time</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="/css/grid.css">
        <link rel="stylesheet" href="/css/IndexForm.css">
    </head>

    <body>
        <h1>Friends</h1>
       	
        <c:choose>
       		<c:when test="${not empty friends}">
       			<table class="friends">
       				<c:forEach var="friend" items="${friends}">
       					<tr>
       						<td>${friend.name}
       					</tr>
       				</c:forEach>
       			</table>
       		</c:when>
        </c:choose>
       
       
    </body>	
</html>