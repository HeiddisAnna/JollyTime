<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:th="http://www.thymeleaf.org" lang="en">


    <head>
        <meta charset="utf-8">
        <title>Date Suggestion</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="/css/grid.css">
        <link rel="stylesheet" href="/css/IndexForm.css">
    </head>

    <body>
        <main>
            <header>
            	<h1 class = JollyTime__header>Jolly Time</h1>
            	<p>Calendar for you and your friends</p>
            </header>

            <div class="suggestedDates">
                <h2 class="suggestedDates__header">Suggested dates</h2>
                <p class="friendList">Selected friends</p>
                <c:choose>
       				<c:when test="${not empty friends}">
		       			<table class="friends">
		       				<c:forEach var="friend" items="${friends}">
		       					<tr>
		       						<td>${friend.name}
		       					</tr>
		       				</c:forEach>
		       			</table>
		       		</c:when>
		        </c:choose>
                
                
                <form action="/sendSuggestedDates" method="POST" path="event">		      
		            <p class="dateList">Here you can see all the dates, please choose some:</p>
		            <c:choose>
						<c:when test="${not empty events}">
							<table class="eventList">
								<c:forEach var="event" items="${events}">
									<tr>
										<input type="checkbox" name="selectedFriends" value="${event.id} 
										 checked = "checked"/> <c:out value="${event.startDate} value="${event.endDate}/><br>  
									</tr>
								</c:forEach>
							</table>
						</c:when>
						<c:otherwise>
							<h3>No available dates!</h3>
						</c:otherwise>
					</c:choose>
					
					<div class="CreateEvent__button">
            			<input class="button" type="submit" name="cancel" value="Cancel"/>
            		</div>
				</form>
        </main>
    </body>	
</html>