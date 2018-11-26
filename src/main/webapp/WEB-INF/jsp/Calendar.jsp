<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.Util"%>
<html lang="isl">
	<%

        ArrayList<Util.Day> days = (ArrayList<Util.Day>) request.getAttribute("days");
    %>
    <head>
        <title>Calendar</title>
        <meta charset="UTF-8">
    </head>
    <body>
		<h1>Calendar!!!</h1>
		<h3>Hello ${name}!</h3>
		
		<div>
		<% for(int i = 0; i < days.size(); i++) {
                Util.Day day = days.get(i);
            %>


            <div>
            	<span><%=day.day%></span>-
                <span><%=day.name%></span>
            </div>
        <%
        };
        %> 
		</div>
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
		
		<form action="/seeFriends" method="GET">
			<div class="SeeFriends__button">
            	<input class="button" type="submit" name="seeFriends" value="See Friends"/>
            </div>
		</form>	
		
		<form action="/logOut" method="GET">
			<div class="LogOut__button">
            	<input class="button" type="submit" name="logOut" value="Log Out"/>
            </div>
		</form>	
	
    	
    </body>

</html>