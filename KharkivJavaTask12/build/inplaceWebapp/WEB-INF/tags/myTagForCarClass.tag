<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="cl" required="true" type="java.util.Collection" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages"/>

<div class="panel-heading"><fmt:message key="jsp.aside.catalogClasses"/></div>
<div class="list-group">
    <c:forEach var="classes" items="${cl}">
        <a href="/classes/${classes.classCar}" class="list-group-item ${selectedCategoryUrl==classes.classCar ? 'active' : ''}">
            <span class="badge"> </span> ${classes.classCar}
        </a>
    </c:forEach>
</div>