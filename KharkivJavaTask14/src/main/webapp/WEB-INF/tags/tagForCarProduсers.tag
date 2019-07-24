<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="producers" required="true" type="java.util.Collection" %>
<%@ attribute name="searchForm" required="true" type="com.epam.form.SearchForm" %>

<div class="form-group form-check">
    <c:forEach var="producer" items="${producers}">
        <input type="checkbox" class="form-check-input" name="producers" value="${producer.mark}" id="exampleCheck1"
            ${searchForm.producers.contains(producer.mark) ? 'checked' : '' }>
        <label class="form-check-label" for="exampleCheck1">${producer.mark}</label>
    </c:forEach>
</div>
