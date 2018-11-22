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
    		<div>
    			<p>Start Date: </p>
    			<div>
    				<tr>
    					<td>Year:</td>
    					<td><select path="startYear" items="${startYears}"\></td>
    				</tr>
    				<tr>
    					<td>Month:</td>
    					<td><select path="startMonth" items="${startMonths}"\></td>
    				</tr>
    				<tr>
    					<td>Day:</td>
    					<td><select path="startDay" items="${startDays}"\></td>
    				</tr>
    			</div>
    		</div>
    		<div>
    			<p>End Date: </p>
    			<div>
    				<tr>
    					<td>Year:</td>
    					<td><select path="endYear" items="${endYears}"\></td>
    				</tr>
    				<tr>
    					<td>Month:</td>
    					<td><select path="endMonth" items="${endMonths}"\></td>
    				</tr>
    				<tr>
    					<td>Day:</td>
    					<td><select path="endDay" items="${endDays}"\></td>
    				</tr>
    			</div>
    		</div>
    		<p>Description: </p><form:textarea path="description" rows="5" cols="30" />
    		<p><input type="submit" value="Create Event"/></p>
    	</form:form>

    </body>

</html>