<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="cl" required="true" type="java.util.Collection" %>

<div class="form-group form-check">
    <c:forEach var="classes" items="${cl}">
        <c:choose>
            <c:when test="${fn:contains(searchForm.carClasses, classes.classCar)}">
                <input type="checkbox" class="form-check-input" name="classes" value="${classes.classCar}" id="exampleCheck1"
                       checked="checked">
            </c:when>
            <c:otherwise>
                <input class="form-check-input" type="checkbox" value="${classes.classCar}" name="categories" id="exampleCheck1">
            </c:otherwise>
        </c:choose>
        <label class="form-check-label" for="exampleCheck1">${classes.classCar}</label>
    </c:forEach>
</div>

