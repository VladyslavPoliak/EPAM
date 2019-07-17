<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="productList" data-page-count="${pageCount}" data-page-number="1">
    <div class="row">
        <jsp:include page="/product-list.jsp"/>
    </div>

</div>

