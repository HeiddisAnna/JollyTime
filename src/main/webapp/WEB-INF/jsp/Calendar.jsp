<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Calendar</title>
    </head>
    <body>
		<h1>Calendar!!!</h1>
		
		<form:form method="POST" modelAttribute="calendar" action="/bookdate">
    		<p><input type="submit" value="Book a date with friends"/></p>
    	</form:form>
    	
    </body>

</html>