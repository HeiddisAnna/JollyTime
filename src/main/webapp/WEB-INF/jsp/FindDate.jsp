<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

    <head>
        <title>Book a date</title>
    </head>
    <body>
    	<h1>Book a date with friends</h1>
    	

    	<form action="/bookThisDate" method="POST" path="event">

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
    	
    	
    		<h2>At what time would you like to stop looking for date</h2>
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
    		<input class="button" type="submit" name="findDate" value="Find Date"/>
    
    	</form>
    	<form action="/cancelDate" method="GET">
			<div class="CreateEvent__button">
            	<input class="button" type="submit" name="cancel" value="Cancel"/>
            </div>
		</form>
    	

    </body>

</html>