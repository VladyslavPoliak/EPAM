<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<c:if test="${pagination != null}">
    <ul class="pagination justify-content-center ">
        <li class="pagination-previous${pagination.previous ? '' : ' disabled' }">
            <c:choose>
                <c:when test="${pagination.previous}"><a class="page-link" href="${pagination.previousUrl}">
                    <fmt:message key="footer.jsp.previous"/></a> </c:when>
                <c:otherwise> <fmt:message key="footer.jsp.previous"/></c:otherwise>
            </c:choose>
        </li>
        <c:forEach var="page" items="${pagination.pages }">
            <c:choose>
                <c:when test="${page.current }">
                    <li class="current">${page.caption }</li>
                </c:when>
                <c:when test="${page.ellipsis }">
                    <li class="ellipsis"></li>
                </c:when>
                <c:otherwise>
                    <li><a class="page-link" href="${page.url }">${page.caption}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <li class="pagination-next${pagination.next ? '' : ' disabled' }">
            <c:choose>
                <c:when test="${pagination.next}"><a class="page-link" href="${pagination.nextUrl}">
                    <fmt:message key="footer.jsp.next"/></a>
                </c:when>
                <c:otherwise> <fmt:message key="footer.jsp.next"/></c:otherwise>
            </c:choose>
        </li>
    </ul>
</c:if>

