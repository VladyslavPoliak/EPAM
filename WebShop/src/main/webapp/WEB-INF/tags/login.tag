<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        <c:choose>
        <c:when test="${CURRENT_ACCOUNT == null }">
        <li class="nav-item">
            <a class="nav-link" href="signUp.jsp"><fmt:message key="header.jsp.signUp"/></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="login.jsp"><fmt:message key="header.jsp.signIn"/></a>
        </li>
    </ul>
    </c:when>

    <c:otherwise>
        <ul class="nav navbar-nav navbar-right">

            <li class="nav-item">
                <img class="user-icon ml-2" src="avatar-image">
            </li>

            <li class="nav-item">
                <a class="nav-link"> <fmt:message key="header.jsp.Welcome"/> ${ CURRENT_ACCOUNT.description } </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/sign-out"><fmt:message
                        key="header.jsp.logOut"/></a>
            </li>
        </ul>

    </c:otherwise>
    </c:choose>
</div>