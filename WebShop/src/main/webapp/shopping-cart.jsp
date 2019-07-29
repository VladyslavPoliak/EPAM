<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="pref" tagdir="/WEB-INF/tags" %>


<div id="shoppingCart">
    <c:if test="${CURRENT_ACCOUNT==null}">
        <div class="alert alert-warning hidden-print" role="alert"> To make order, please sign in</div>
    </c:if>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Car</th>
            <th>Price</th>
            <th>Days</th>
            <th class="hidden-print">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${CURRENT_SHOPPING_CART.cars }">
            <tr id="product${item.car.id }" class="item">
                <td class="text-center"><img class="small" src="${item.car.imageURL}"
                                             alt="${item.car.mark}"><br>${item.car.name}
                </td>
                <td class="price">${item.car.cost }</td>
                <td class="count"><input type="number" id="${item.car.id}" name="editItemQuantityInput" value="1"
                                         min="1" max="10"></td>
                <td class="hidden-print">
                    <button class="btn btn-danger " name="deleteItem" data-id-product="${item.car.id}"> Remove</button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2" class="text-right"><strong>Total</strong></td>
            <td colspan="2" class="total" id="totalCost"> ${CURRENT_SHOPPING_CART.totalCost}</td>
        </tr>
        </tbody>
    </table>
    <div class="row hidden-print">
        <div class="col-md-4 col-md-offset-4 col-lg-2 col-lg-offset-5">
            <c:choose>
                <c:when test="${CURRENT_ACCOUNT != null && CURRENT_SHOPPING_CART.size>0 }">
                    <form action="${pageContext.request.contextPath}/order" method="POST">
                        <div class="form-group">
                            <label for="creditCardNum">Credit card number</label>
                            <input type="text" id="creditCardNum" name="creditCardNum" value="${order.creditCard}">
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input type="text" id="address" name="address" value="${order.address}" required>

                        </div>
                        <button type="submit" class="btn btn-success">Make order</button>
                    </form>

                </c:when>
                <c:otherwise>
                    <li>
                        <a class="btn btn-danger" href="signUp.jsp">SignUp</a>
                    </li>
                    <li>
                        <a class="btn btn-danger" href="login.jsp">SignIn</a>
                    </li>
                </c:otherwise>
            </c:choose>

        </div>
    </div>

</div>
