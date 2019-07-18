<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="cl" required="true" type="java.util.Collection" %>
<br/>

<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <c:forEach var="classes" items="${cl}">
        <a class="dropdown-item" href="/classes/${classes.classCar}">${classes.classCar}</a>
    </c:forEach>
</div>
