<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

    <head>
        <title>Create Event</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	<meta charset="utf-8">
        <title>Calendar</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="/css/grid.css">
        <link rel="stylesheet" href="/css/CreateEvent.css">
    </head>
    <body>
    	<ul id="navbar-Calendar">
			<li><a class="navbar-text" style="float:left" href="/calendar">Jolly Time</a></li>
			<li><a class="navbar-text" style="float:left" href="/addEvent" method="GET" class="AddEvent_button name="addEvent">Create Event</a></li>
			<li><a class="navbar-text" style="float:left" href="/bookDate" method="GET" class="BookDate_button name="bookDate">Book a date</a></li>
			<li><a class="navbar-text" style="float:right" href="/logOut" method="GET" class="logOut_button name="logOut">Log out</a></li>
			<li><a class="navbar-text" style="float:right">${name}</a></li>
		</ul>
    
    	<h1>Create Event</h1>
    	
		
    	<form class="content" action="/eventcreated" method="POST" path="event">

			<div id="titleEvent>
				<label class="title-event">Title:</label>
            	<input class="event_title" type="text" name="title" />
            </div>
    
    		<p>Starts</p>
    		<table>
   
    			<tr>
    				<th>Year</th>
    				<th>Month</th>
    				<th>Day</th>
    				<th>Time</th>
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
    				
    				<td>
    					<form:select path="startTime" name="startTime">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startTimes}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    	
    	
    		<p>Ends</p>
    		<table>
    			<tr>
    				<th>Year</th>
    				<th>Month</th>
    				<th>Day</th>
    				<th>Time</th>
    				
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
    				
    				<td>
    					<form:select path="endTime" name="endTime">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endTimes}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    		
    		
    		<label class="Heiddis__sorry">Description:</label>
    		<textarea name="description" type="text" placeholder="Write a description of the event here" rows="4" cols="50"></textarea>
    		
    		
    		<div class="event__error"> <p>${errormessage}</p> </div>
    		<div class="createEvent__button">
    			<input class="button" type="submit" name="createThisEvent" value="Create Event"/>
    		</div>
    
    	</form>
    	<form class="cancelButton" action="/cancel" method="GET">
			<div class="createEvent_button">
            	<input class="button" type="submit" name="cancel" value="Cancel"/>
            </div>
		</form>
    	

    </body>

</html>