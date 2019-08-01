<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">

    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">

    <title><fmt:message key="login.jsp.logIn"/></title>
</head>
<html>
<body>
<div class="container">
    <h1 class="text-center display-4"><fmt:message key="login.jsp.logIn"/></h1>
    <form action="${pageContext.request.contextPath}/login" id="registration-form" method="post">

        <div class="form-group">
            <label for="user-email-login"><fmt:message key="login.jsp.email"/></label>
            <input class="form-control" id="user-email-login" name="email-login" placeholder="Please, enter your email"
                   type="email">
        </div>

        <div class="form-group">
            <label for="user-pass-login"><fmt:message key="login.jsp.password"/></label>
            <input class="form-control" id="user-pass-login" name="password-login"
                   placeholder="Please, enter your password"
                   type="password">
        </div>

        <button class="btn btn-primary " type="submit"><fmt:message key="login.jsp.submit"/></button>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>

</body>

</html>