<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

    <head>
        <title>Book a date</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	<meta charset="utf-8">
        <title>Calendar</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="/css/grid.css">
        <link rel="stylesheet" href="/css/FindDate.css">
    </head>
    <body>
    
    	<ul id="navbar-Calendar">
			<li><a class="navbar-text" style="float:left" href="/calendar">Jolly Time</a></li>
			<li><a class="navbar-text" style="float:left" href="/addEvent" method="GET" class="AddEvent_button name="addEvent">Create Event</a></li>
			<li><a class="navbar-text" style="float:left" href="/bookDate" method="GET" class="BookDate_button name="bookDate">Book a date</a></li>
			<li><a class="navbar-text" style="float:right" href="/logOut" method="GET" class="logOut_button name="logOut">Log out</a></li>
			<li><a class="navbar-text" style="float:right">${name}</a></li>
		</ul>
    
    	<h1>Book a date with friends</h1>
    	

    	<form class="content" action="/bookThisDate" method="POST" path="event">

			<label class="date__titleText">Title of your date:</label>

            <input class="date__titleInput" type="text" name="title" />
      

            <p class="friendList">Choose the friends you want to book a date with </p>
            <c:choose>
				<c:when test="${not empty friends}">
					<table class="friendList">
						<c:forEach var="friend" items="${friends}">
							<tr>
								<input type="checkbox" name="selectedFriends" value="${friend.email} checked = "checked"/> <c:out value = "${friend.name}"/><br>  
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h3>You dont have any friends!</h3>
				</c:otherwise>
			</c:choose>
            
 
    
    		<h2>In which time period would you like to look for a date:</h2>
    		
    		<table>
   
    			<tr>
    				<th>Year</th>
    				<th>Month</th>
    				<th>Day</th>
    			</tr>
    			<tr>
    				
    				<td>
    					<form:select path="startYear" name="startYear">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startYears}" />
    					</form:select>
    				</td>
    			
    				
    				<td>
    					<form:select path="startMonth" name="startMonth">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startMonths}" />
    					</form:select>
    				</td>
    			
    				
    				<td>
    					<form:select path="startDay" name="startDay">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startDays}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    	
    	
    		<h2>At what time would you like to stop looking for date</h2>
    		<table>
    			<tr>
    				<th>Year</th>
    				<th>Month</th>
    				<th>Day</th>
    				
    			</tr>
    			<tr>
    				<td>
    					<form:select path="endYear" name="endYear">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endYears}" />
    					</form:select>
    				</td>
    		
    				<td>
    					<form:select path="endMonth" name="endMonth">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endMonths}" />
    					</form:select>
   
    				<td>
    					<form:select path="endDay" name="endDay">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endDays}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    		
    		
    		<h2>How long timie should the date take:</h2>
    		<table>
    			<tr>
    				<th>Lengt of the date</th>
    				
    			</tr>
    			<tr>
    				<td>
    					<form:select path="dateLength" name="dateLength">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${dateLengths}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    		
    		
    		
    		<label class="date__description">Description:</label>
    		<textarea name="description" type="text" placeholder="Write a description about the date here" rows="4" cols="50"></textarea>
    		
    		
    		<div class="event__error"> <p>${errormessage}</p> </div>
    		<div class="createEvent__button">
    			<input class="button" type="submit" name="findDate" value="Find Date"/>
    		</div>
    
    	</form>
    	<form class="cancelButton" action="/cancelDate" method="GET">
			<div class="CreateEvent__button">
            	<input class="button" type="submit" name="cancel" value="Cancel"/>
            </div>
		</form>
    	

    </body>

</html>