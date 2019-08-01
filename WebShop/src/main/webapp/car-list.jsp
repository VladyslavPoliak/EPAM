<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:forEach var="c" items="${carList}">
    <div class="card col-sm-4">
        <img alt="${c.name} ${c.mark}"
             class="card-img-top"
             src="${c.imageURL}">
        <div class="card-body">
            <h5 class="card-title text-truncate" data-placement="top" data-toggle="tooltip">
                    ${c.name} ${c.mark}</h5>
            <p class="card-text"><fmt:message key="aside.jsp.class"/>: ${c.classCar}</p>
            <h5><fmt:message key="aside.jsp.price"/>: ${c.cost}</h5>
            <button name="buyItem" class="btn btn-primary" id="${c.id}"><fmt:message key="car-list.jsp.buy"/></button>
        </div>
    </div>
</c:forEach>

