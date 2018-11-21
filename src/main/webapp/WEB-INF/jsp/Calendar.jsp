<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Calendar</title>
    </head>
    <body>
		<h1>Calendar!!!</h1>
		<h3>Hello ${name}!</h3>
		
		
		<form action="/addFriend" method="GET">
			<div class="AddFriend__button">
            	<input class="button" type="submit" name="addFriend" value="Add a Friend"/>
            </div>
		</form>
		
		<form action="/addEvent" method="GET">
			<div class="AddEvent__button">
            	<input class="button" type="submit" name="addEvent" value="Create Event"/>
            </div>
		</form>
		
		<form action="/bookDate" method="GET">
			<div class="BookDate__button">
            	<input class="button" type="submit" name="bookDate" value="Book a Date"/>
            </div>
		</form>	
		
    	
    </body>

</html>