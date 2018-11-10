<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

    <head>
        <title>Create Account</title>
    </head>
    <body>

    	<h1>Create your account</h1>
    	<h3>Here we would allow the user to create an account</h3>
    	
    	<p>Please enter your personal information</p>
    	
    	
    	<form:form method="POST" modelAttribute="user" action="/accountcreated">
    		<p>Email: </p><form:input path="email" />
    		<p>Name: </p><form:input path="name"/>
    		<p>Password: </p><form:input path="password"/>
    		<p><input type="submit" value="Create Account!"/></p>
    	</form:form>

    </body>

</html>