<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="producers" required="true" type="java.util.Collection" %>

<div class="form-group form-check">
    <c:forEach var="producer" items="${producers}">
        <input type="checkbox" class="form-check-input" name="producers" value="${producer.mark}" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">${producer.mark}</label>
    </c:forEach>
</div>
