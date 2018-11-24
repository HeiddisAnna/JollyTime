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
    	
    	
    
    	
    	<form:select action="/bla1" method="POST" path="event">
    
    		<table>
    			
    			<tr>
    				<td>Year: </td>
    				<td>
    					<form:select path="startYear">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startYears}" />
    					</form:select>
    				</td>
    			</tr>
    			<tr>
    				<td>Year: </td>
    				<td>
    					<form:select path="startYear">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startYears}" />
    					</form:select>
    				</td>
    			</tr>
    			<tr>
    				<td>Month: </td>
    				<td>
    					<form:select path="startMonth">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startMonths}" />
    					</form:select>
    				</td>
    			</tr>
    			<tr>
    				<td>Day: </td>
    				<td>
    					<form:select path="startDay">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${startDays}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    	
    		<table>
    			<tr>
    				<th>End: </th>
    			</tr>
    			<tr>
    				<td>Year: </td>
    				<td>
    					<form:select path="endYear">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endYears}" />
    					</form:select>
    				</td>
    			</tr>
    			<tr>
    				<td>Month: </td>
    				<td>
    					<form:select path="endMonth">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endMonths}" />
    					</form:select>
    				</td>
    			</tr>
    			<tr>
    				<td>Day: </td>
    				<td>
    					<form:select path="endDay">
    						<form:option value="NONE" label="- - - Select - - -"/>
    						<form:options items="${endDays}" />
    					</form:select>
    				</td>
    			</tr>
    		</table>
    		<input class="button" type="submit" name="createThisEvent" value="Create Event"/>
    	</form:select>
    	

    </body>

</html>