<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="project.Util"%>
<html lang="en">
	<%

		String email = (String) request.getAttribute("email");
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
        <title>Calendar</title>
        <meta charset="UTF-8">
    </head>
    <body>
		<h1>Calendar!!!</h1>
		
		
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
	
    	
    	
    	
    	
        <script src="/scripts/calendar.js"></script>
    </body>

</html>