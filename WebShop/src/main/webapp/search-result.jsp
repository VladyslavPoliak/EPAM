<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<br/>
<div class="alert alert-info">

    <p><fmt:message key="search-result.jsp.find"/>: <strong>${carCount}</strong>
        <fmt:message key="search-result.jsp.cars"/></p>
</div>

<jsp:include page="cars.jsp"/>

