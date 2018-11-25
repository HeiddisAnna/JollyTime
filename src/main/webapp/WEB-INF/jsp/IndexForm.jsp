<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:th="http://www.thymeleaf.org" lang="en">


    <head>
        <meta charset="utf-8">
        <title>Jolly Time</title>
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

            <div class="LogIn">
                <h2 class="LogIn__header">Please enter your email and password</h2>
                <form class= "LogIn__container" action="/index" th:action="@{/index}" method="post">
                    <div class="LogIn__text">
                        <label class="LogIn__textQuestion" for="email__text">Email:</label>
                        <input class="LogIn__textAnswer" type="text" name="email" />
                    </div>
                    <div class="LogIn__text">
                            <label class="LogIn__textQuestion" for="password__text">Password:</label>
                            <input class="LogIn__textAnswer" type="password"  name="password" />
                    </div>
                    <div class="LogIn__button">
                        <input class="button" type="submit" name="login" value="Log In"/>
                    </div>
                    <div class="LogIn__error">
                    	<p>${errormessage}</p>
                    </div>
                </form>
                <a class="LogIn__newAccount" href="createaccount">Create new account</a>
            </div>
            <footer>
                <p class="footer__text"> Class HBV501G, University of Iceland </p>
            </footer>
        </main>
    </body>	
</html>