<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="pref" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation"
            class="navbar-toggler"
            data-target="#navbarTogglerDemo03" data-toggle="collapse" type="button">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/cars">
        <fmt:message key="header.jsp.home"/></a>

    <div class="collapse navbar-collapse" id="navbarToggler">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0 ">
            <li class="nav-item" ${CURRENT_SHOPPING_CART.size==0 ?'hidden':''}>
                <a class="nav-link" href="${pageContext.request.contextPath}/shopping-cart"> <fmt:message
                        key="header.jsp.shoppingCart"/></a>
            </li>

            <li class="nav-item">
                <pref:locale/>
            </li>

        </ul>
        <ul class="nav navbar-nav navbar-right ">
            <pref:login/>
        </ul>
    </div>
</nav>