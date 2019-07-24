<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="cl" required="true" type="java.util.Collection" %>
<%@ attribute name="searchForm" required="true" type="com.epam.form.SearchForm" %>

<div class="form-group form-check">
    <c:forEach var="classes" items="${cl}">
        <input type="checkbox" class="form-check-input" name="classes" value="${classes.classCar}" id="exampleCheck1"
            ${searchForm.carClasses.contains(classes.classCar) ? 'checked' : '' }>

        <label class="form-check-label" for="exampleCheck1">${classes.classCar}</label>
    </c:forEach>
</div>

