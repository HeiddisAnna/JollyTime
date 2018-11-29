<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Add Friend</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	<meta charset="utf-8">
        <title>Calendar</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="/css/grid.css">
        <link rel="stylesheet" href="/css/AddFriend.css">
    </head>
    <body>
    
    	<ul id="navbar-Calendar">
			<li><a class="navbar-text" style="float:left" href="/calendar">Jolly Time</a></li>
			<li><a class="navbar-text" style="float:left" href="/addEvent" method="GET" class="AddEvent_button name="addEvent">Create Event</a></li>
			<li><a class="navbar-text" style="float:left" href="/bookDate" method="GET" class="BookDate_button name="bookDate">Book a date</a></li>
			<li><a class="navbar-text" style="float:right" href="/logOut" method="GET" class="logOut_button name="logOut">Log out</a></li>
			<li><a class="navbar-text" style="float:right">${name}</a></li>
		</ul>
    	
    	<div class="AddFriend">
        	<h2 class="AddFriend__header">Please the email address of your friend</h2>
            <form class= "AddFriend__container" action="/addThisFriend" th:action="@{/addThisFriend}" method="post">
            	<div class="AddFriend__text">
                	<label class="AddFriend__textQuestion" for="email__text">Email:</label>
                    <input class="AddFriend__textAnswer" type="text" name="email" />
                </div>
				<div class="AddFriend__button">
                	<input class="button" type="submit" name="addThisFriend" value="add Friend"/>
                </div>
                <div class="AddFriend__error">
                	<p>${errormessage}</p>
                </div>
			</form>
		</div>
		<form class="cancelButton" action="/cancel" method="GET">
			<div class="AddFriend__button">
            	<input class="button" type="submit" name="cancel" value="Done"/>
            </div>
		</form>

    </body>

</html>