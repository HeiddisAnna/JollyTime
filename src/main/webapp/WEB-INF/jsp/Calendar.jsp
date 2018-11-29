<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="project.model.Event"%>
<%@page import="java.util.HashMap"%>
<%@page import="project.Util"%>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
//prevents caching at the proxy server
%>
<html lang="en">
	<%

		String email = (String) request.getAttribute("email");
		String name = (String) request.getAttribute("name");
		
		Integer selectedDay = (Integer) request.getAttribute("selectedDay");
        Integer selectedMonth = (Integer) request.getAttribute("selectedMonth");
        Integer selectedYear = (Integer) request.getAttribute("selectedYear");
        
        Integer nextMonth = (Integer) request.getAttribute("nextMonth");
        Integer nextYear = (Integer) request.getAttribute("nextYear");
        
        Integer prevMonth = (Integer) request.getAttribute("prevMonth");
        Integer prevYear = (Integer) request.getAttribute("prevYear");
        
        Integer extraDivsWeekdays = (Integer) request.getAttribute("extraDivsWeekdays");
        
        String selectedMonthName = ((HashMap<Integer, String>) request.getAttribute("monthNames")).get(selectedMonth);
        ArrayList<Util.Day> month = (ArrayList<Util.Day>) request.getAttribute("month");
        List<Event> eventsInMonth = (List<Event>) request.getAttribute("eventsInMonth");
    %>
    <head>
    
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	<meta charset="utf-8">
        <title>Calendar</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="/css/grid.css">
        <link rel="stylesheet" href="/css/Calendar.css">
    </head>
    <body>
		<ul id="navbar-Calendar">
			<li><a class="navbar-text" style="float:left" href="/calendar">Jolly Time</a></li>
			<li><a class="navbar-text" style="float:left" href="/addEvent" method="GET" class="AddEvent_button name="addEvent">Create Event</a></li>
			<li><a class="navbar-text" style="float:left" href="/bookDate" method="GET" class="BookDate_button name="bookDate">Book a date</a></li>
			<li><a class="navbar-text" style="float:right" href="/logOut" method="GET" class="logOut_button name="logOut">Log out</a></li>
			<li><a class="navbar-text" style="float:right">${name}</a></li>
		</ul>
		
		<div class="calendar">
		
			<div class="w3-sidebar w3-bar-block w3-card sidebar" style="width:230px;">
				<h1 class="date w3-bar-item"><%=selectedMonthName%> <%=selectedDay%></h1>
				
				<div class="friends">
				<hr>
				<h5 class="friends-title">Your Friends:</h5>
				<hr>
					<div class="friendsList w3-bar-item">
						<c:choose>
				       		<c:when test="${not empty friends}">
				       			<table class="friends-table">
				       				<c:forEach var="friend" items="${friends}">
				       					<tr>
				       						<td>${friend.name}
				       					</tr>
				       				</c:forEach>
				       			</table>
				       		</c:when>
						 </c:choose>
					</div>
					<div class="addFriend w3-bar-item">
						<a class="w3-button w3-xlarge w3-circle w3-card-4 sidebar-text addFriend_button" href="/addFriend" method="GET" name="addFriend">+</a>
					</div>
					
					<div id="EventContainer">
			     	    <% for(int i = 0; i < eventsInMonth.size(); i++) {
			      		  		Event event = eventsInMonth.get(i);
			   				%>
			   				<div class="event">
			       				<span><%=event.title%></span>
			   				</div>
			   			 <% }; %>
			   		</div>
					
				</div>
			</div>
        
        <div class="w3-container" style="margin-left:230px">
        	<div class="year-title">
        		<h1 class="year">${selectedYear}</h1>
        	</div>
        	<div class="month-content">
        			<div id="prevNextButtons">
        				<div id="privMonth">
		        			<a id="prevButton" href="/calendar?year=<%=prevYear%>&month=<%=prevMonth%>&email=<%=email%>" method="GET">Previous Month</a>
		        		</div>
		        		<div id="nextMonth">
		        			<a id="nextButton" href="/calendar?year=<%=nextYear%>&month=<%=nextMonth%>&email=<%=email%>" method="GET">Next Month</a>
		        		</div>
		        		
		        	</div>
					<span class="hidden" id="selectedYear"><%=selectedYear%></span>
					<span class="hidden" id="selectedMonth"><%=selectedMonth%></span>
					
					<div id="daysNames">
						<div class="dayName">
							<span>Sunday</span>
						</div>
						<div class="dayName">
							<span>Monday</span>
						</div>
						<div class="dayName">
							<span>Tuesday</span>
						</div>
						<div class="dayName">
							<span>Wednesday</span>
						</div>
						<div class="dayName">
							<span>Thursday</span>
						</div>
						<div class="dayName">
							<span>Friday</span>
						</div>
						<div class="dayName">
							<span>Saturday</span>
						</div>
					</div>
			
					<div id="monthContainer">
						<% for(int i = 0; i < extraDivsWeekdays; i++) { %>
							<div class="day"></div>
						<% } %>
			     	    <% for(int i = 0; i < month.size(); i++) {
			      		  		Util.Day day = month.get(i);
			   				%>
			   				<div class="day">
			       				<span><%=day.day%></span>
			   				</div>
			   			 <% }; %>
			   		</div>
	        	</div>
			</div>
      	</div>
		
        <script src="/scripts/calendar.js"></script>
    </body>

</html>