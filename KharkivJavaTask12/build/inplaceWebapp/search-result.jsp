<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br/>
<div class="alert alert-info">

    <p>Find: <strong>${carCount}</strong> cars</p>
</div>

<jsp:include page="cars.jsp"/>

