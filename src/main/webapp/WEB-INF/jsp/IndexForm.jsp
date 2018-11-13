<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:th="http://www.thymeleaf.org" lang="en">


    <head>
        <title>Jolly Time</title>
    </head>
    <body>

    	<h1>Jolly Time :D Form</h1>
    	<p>Please enter your email and password</p>
    	
    	<form action="/login" th:action="@{/login}" th:object="${user}" method="post">
    		<p>email: <input type="text" th:field="*{email}" /></p>
    		<p>password: <input type="text" th:field="*{password}" /></p>
    		<p><input type="submit" value="Log In" /></p>
		</form>
		<a href="createaccount">Create Account</a>
    
    </body>
    <footer>Class HBV501G, University of Iceland</footer>
</html>
