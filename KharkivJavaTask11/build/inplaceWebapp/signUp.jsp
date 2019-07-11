<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="info" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">

    <!-- Bootstrap CSS -->
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">

    <title>Sign Up</title>
</head>
<html>
<body>
<div class="container">
    <h1 class="text-center display-4">SIGN UP</h1>
    <form action="${pageContext.request.contextPath}/registration" id="registration-form" method="post">
        <div class="form-group">
            <label for="user-name">First Name</label>
            <input class="form-control" id="user-name" name="userName" placeholder="First Name" type="text"
                   value="${name}">
            <div class="valid-feedback">
                Looks good!
            </div>
            <div class="invalid-feedback">
                The name must consist of letters only.
            </div>
        </div>

        <div class="form-group">
            <label for="user-surname">Second Name</label>
            <input class="form-control" id="user-surname" name="userSurname" placeholder="Second Name" type="text"
                   value="${surName}">
            <div class="valid-feedback">
                Looks good!
            </div>
            <div class="invalid-feedback">
                The surname must consist of letters only.
            </div>
        </div>


        <div class="form-group">
            <label for="user-email">Email address</label>
            <input class="form-control" id="user-email" name="userEmail" placeholder="Please, enter your email"
                   type="email"
                   value="${login}">
            <div class="valid-feedback">
                Looks good!
            </div>
            <div class="invalid-feedback">
                Invalid email
            </div>
            <small class="form-text text-muted" id="emailHelp">We'll never share your email with anyone
                else.
            </small>
        </div>

        <div class="form-group">
            <label for="user-pass">Password</label>
            <input class="form-control" id="user-pass" name="userPassword" placeholder="Please, enter your password"
                   type="password">
            <div class="valid-feedback">
                Good password
            </div>
            <div class="invalid-feedback">
                The password is too short
            </div>
        </div>

        <div class="form-group">
            <label for="confirmation-pass">Confirm your password</label>
            <input class="form-control" id="confirmation-pass" name="confirmationPassword"
                   placeholder="Please, confirm your password"
                   type="password">
            <div class="valid-feedback">
                Passwords match
            </div>
            <div class="invalid-feedback">
                Passwords do not match(need more than 5 characters)
            </div>
        </div>

        <info:captcha captchaId="${captchaId}"/>
        <label for="captcha"> </label><input id="captcha" name="captcha" placeholder="Numbers from picture" type="text">

        <button class="btn btn-primary " type="submit">Submit</button>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script src="js/script.js"> </script>
<!--<script src="src/main/webapp/js/jqueryScript.js"></script>-->
</body>

</html>