<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="marks" required="true" type="java.util.Collection" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages"/>

<div class="panel-heading"><fmt:message key="jsp.aside.filterBrend"/></div>
<div class="panel-body categories">
    <c:forEach var="classes" items="${marks}">
        <a href="/mark/${classes.mark}" class="list-group-item ">
            <span class="badge"> </span> ${classes.mark}
        </a>
    </c:forEach>
</div>