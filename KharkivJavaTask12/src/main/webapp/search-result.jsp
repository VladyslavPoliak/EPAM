<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="alert alert-info">
    <c:if test="${carCount}=0">
        <p><strong>Nothing found </strong></p>
    </c:if>
    <c:if test="${carCount}>0">
        <p>Find: <strong>${cаrCount}</strong> cars</p>
    </c:if>
</div>

<jsp:include page="cars.jsp"/>