<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Add Friend</title>
    </head>
    <body>
    	
    	<div class="AddFriend">
        	<h2 class="AddFriend__header">Please the email address of your friend</h2>
            <form class= "AddFriend__container" action="/addThisFriend" th:action="@{/addThisFriend}" method="post">
            	<div class="AddFriend__text">
                	<label class="AddFriend__textQuestion" for="email__text">Email:</label>
                    <input class="AddFriend__textAnswer" type="text" name="email" />
                </div>
				<div class="AddFriend__button">
                	<input class="button" type="submit" name="addThisFriend" value="add Friend"/>
                </div>
                <div class="AddFriend__error">
                	<p>${errormessage}</p>
                </div>
			</form>
		</div>

    </body>

</html>