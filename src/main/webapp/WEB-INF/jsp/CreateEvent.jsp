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
    	

    	<form action="/bla1" method="POST" path="event">

			<label class="Heiddis__sorry">Title:</label>
            <form:input class="event__title" type="text" path="title" />
    
    		<p>Start</p>
    		<table>
   
    			<tr>
    				<th>Year</th>
    				<th>Month</th>
    				<th>Day</th>
    				<th>Time</th>
    			</tr>
    			<tr>
    				
    				<td>
    					<form:select path="startYear">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startYears}" />
    					</form:select>
    				</td>
    			
    				
    				<td>
    					<form:select path="startMonth">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startMonths}" />
    					</form:select>
    				</td>
    			
    				
    				<td>
    					<form:select path="startDay">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startDays}" />
    					</form:select>
    				</td>
    				
    				<td>
    					<form:select path="startTime">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startTimes}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    	
    	
    		<p>End</p>
    		<table>
    			<tr>
    				<th>Year</th>
    				<th>Month</th>
    				<th>Day</th>
    				<th>Time</th>
    				
    			</tr>
    			<tr>
    				<td>
    					<form:select path="endYear">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endYears}" />
    					</form:select>
    				</td>
    		
    				<td>
    					<form:select path="endMonth">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endMonths}" />
    					</form:select>
   
    				<td>
    					<form:select path="endDay">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endDays}" />
    					</form:select>
    				</td>
    				
    				<td>
    					<form:select path="endTime">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endTimes}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    		
    		
    		<label class="Heiddis__sorry">Description:</label>
    		<textarea path="description" type="text" rows="4" cols="50"></textarea>
    		
    		
    		
    		<input class="button" type="submit" name="createThisEvent" value="Create Event"/>
    
    	</form>
    	

    </body>

</html>