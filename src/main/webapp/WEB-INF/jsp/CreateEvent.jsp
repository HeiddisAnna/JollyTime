<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

    <head>
        <title>Create Event</title>
    </head>
    <body>
    	<h1>Create Event</h1>
    	<form:form method="POST" modelAttribute="event" action="/eventcreated">
    		<p>Title: </p><form:input path="title" />
    		<p>Start Date: </p><form:input path="startDate"/>
    		<p>End Date: </p><form:input path="endDate"/>
    		<p>Description: </p><form:input path="description"/>
    		<p><input type="submit" value="Create Event"/></p>
    	</form:form>

    </body>

</html>