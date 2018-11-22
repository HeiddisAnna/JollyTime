<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Create Account</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="/css/grid.css">
        <link rel="stylesheet" href="/css/CreateAccount.css">
    </head>
    <body>
        <header>
            <h1 class = JollyTime__header>Jolly Time</h1>
            <p>Calendar for you and your friends</p>
        </header>

        <div class="information__container">

            <div class="account__header">
                <h1>Create your account</h1>
            </div>

            <div class="account__error"> <p>${errormessage}</p> </div>

            <p class="account__underHeader">Please enter your personal information</p>
            
            
            <form:form class= "account__info" method="POST" modelAttribute="user" action="/accountcreated">
                <div class="account__text">
                    <label class="account__textQuestion">Email:</label>
                    <form:input class="account__textAnswer" type="text" path="email" />
                </div>
                <div class="account__text">
                    <label class="account__textQuestion">Name:</label>
                    <form:input class="account__textAnswer" type="text" path="name" />
                </div>
                <div class="account__text">
                    <label class="account__textQuestion">Password:</label>
                    <form:input class="account__textAnswer" type="password" path="password" />                        
                </div>
                <div class="account__buttonContainer">
                        <input class="account__button" type="submit" name="login" value="Create Account!"/>
                </div>
            </form:form>
        </div>
    </body>