<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="c" items="${carList}">
    <div class="card col-sm-4">
        <img alt="Card image cap"
             class="card-img-top"
             src="https://bls.ua/image_cache/cars/97.Seat_Ibiza_2019/585x440-5c9e3129877ff.jpg">
        <div class="card-body">
            <h5 class="card-title text-truncate" data-placement="top" data-toggle="tooltip"
                title=" Seat Ibiza ">Seat Ibiza</h5>
            <p class="card-text">МЕСТ 4; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.2</p>
            <h5>Price: 40$</h5>
            <a class="btn btn-primary" href="#">Rent</a>
        </div>
    </div>
</c:forEach>
