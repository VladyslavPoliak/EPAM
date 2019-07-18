<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="c" items="${carList}">
    <div class="card col-sm-4">
        <img alt="${c.name} ${c.mark}"
             class="card-img-top"
             src="${c.imageURL}">
        <div class="card-body">
            <h5 class="card-title text-truncate" data-placement="top" data-toggle="tooltip">
                    ${c.name} ${c.mark}</h5>
            <p class="card-text">Class: ${c.classCar}</p>
            <h5>Price: ${c.cost}</h5>
            <a class="btn btn-primary" href="#">Rent</a>
        </div>
    </div>
</c:forEach>
