<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="marks" required="true" type="java.util.Collection" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="panel-heading">TTTTTTTTTT</div>
<div class="panel-body categories">
    <c:forEach var="classes" items="${marks}">
        <a href="/mark/${classes.mark}" class="list-group-item ">
            <span class="badge"> </span> ${classes.mark}
        </a>
    </c:forEach>
</div>