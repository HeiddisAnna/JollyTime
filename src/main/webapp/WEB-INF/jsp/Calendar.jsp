<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="project.Util"%>
<html lang="en">
	<%

		String email = (String) request.getAttribute("email");
		String name = (String) request.getAttribute("name");
        Integer selectedMonth = (Integer) request.getAttribute("selectedMonth");
        Integer selectedYear = (Integer) request.getAttribute("selectedYear");
        
        Integer nextYear = selectedYear;
        Integer nextMonth = selectedMonth + 1;
        if (nextMonth > 11) {
        	nextYear += 1;
        	nextMonth = nextMonth % 12;
        }
        
        Integer prevYear = selectedYear;
        Integer prevMonth = selectedMonth - 1;
        
        if (prevMonth < 0) {
        	prevYear -= 1;
        	prevMonth = 11;
        }
        
        String selectedMonthName = ((HashMap<Integer, String>) request.getAttribute("monthNames")).get(selectedMonth);
        ArrayList<Util.Day> month = (ArrayList<Util.Day>) request.getAttribute("month");
    %>
    <head>
    
    	<meta charset="utf-8">
        <title>Calendar</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="/css/grid.css">
        <link rel="stylesheet" href="/css/Calendar.css">
    </head>
    <body>
		<ul id="navbar-Calendar">
			<li><a class="navbar-text">JollyTime</a></li>
			<li>
				<a class="navbar-text" href="/addEvent" method="GET" class="AddEvent_button name="addEvent">Create Event</a>
			</li>
			<li>
				<a class="navbar-text" href="/bookDate" method="GET" class="BookDate_button name="bookDate">Book a date</a>
			</li>
			<li>
				<a class="navbar-text" href="/logOut" method="GET" class="logOut_button name="logOut">Log out</a>
			</li>
			<li style="float:right"><a class="navbar-text">${name}</a></li>
		</ul>
		
		<div class="calendar">
		
			<div class="col leftCol">
				<div class="content">
					<h1 class="date">Friday<span></span></h1>
					<div class="notes">
						<ul class="friends">
							<li>
								<a class="sidebar-text" href="/addFriend" method="GET" class="AddFriend_button name="addFriend">Add a freind</a>
							</li>
							<li>
								<a class="sidebar-text" href="/seeFriends" method="GET" class="seeFriends_button name="seeFriends">See Friends</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			
		</div>
		
		<span class="hidden" id="selectedYear"><%=selectedYear%></span>
		<span class="hidden" id="selectedMonth"><%=selectedMonth%></span>

		<h4 id="selectedMonthHeading"><%=selectedMonthName%></h4>
		<h5 id="selectedYearHeading"><%=selectedYear%></h5>

		<div id="monthContainer">
	        <% for(int i = 0; i < month.size(); i++) {
	        		Util.Day day = month.get(i);
	   			%>
	   			<div class="day">
	       			<span><%=day.monthName%></span>-
	       			<span><%=day.day%></span>-
	       			<span><%=day.dayName%></span>
	   			</div>
	   		 <% }; %>
        </div>
        <a id="nextButton" href="/index?year=<%=nextYear%>&month=<%=nextMonth%>&email=<%=email%>">Next Month</a>
        <a id="prevButton" href="/index?year=<%=prevYear%>&month=<%=prevMonth%>&email=<%=email%>">Previous Month</a>
        
		</div>
		
        <script src="/scripts/calendar.js"></script>
    </body>

</html>