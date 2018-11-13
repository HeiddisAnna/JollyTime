<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:th="http://www.thymeleaf.org" lang="en">

    <head>
        <title>Jolly Time</title>
    </head>
    <body>

    	<h1>Jolly Time :D Result</h1>
    	<p>Hello <span th:utext="${session.user.name}">!</span></p>
    	<p>Hello ${nom}!</p>
    
    </body>
    <footer>Class HBV501G, University of Iceland</footer>
</html>
