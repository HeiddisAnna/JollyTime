<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:th="http://www.thymeleaf.org" lang="en">

    <head>
        <title>Jolly Time</title>
    </head>
    <body>

    	<h1>Jolly Time :D Form</h1>
    	<p>Please enter your email and password</p>
		<form action="/index" th:action="@{/index}" method="post">
			<p>Email: <input type="text" name="email" /></p>
			<p>Password: <input type="text"  name="password" /></p>	
			<input type="submit" name="login" value="Log In"/>
		</form>
		<a href="createaccount">Create Account</a>
    
    </body>
    <footer>Class HBV501G, University of Iceland</footer>
</html>
