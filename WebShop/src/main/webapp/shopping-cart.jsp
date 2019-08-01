<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="pref" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<div id="shoppingCart">
    <c:if test="${CURRENT_ACCOUNT==null}">
        <div class="alert alert-warning hidden-print" role="alert"><fmt:message
                key="shopping-cart.jsp.attention"/></div>
    </c:if>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th><fmt:message key="shopping-cart.jsp.car"/></th>
            <th><fmt:message key="shopping-cart.jsp.price"/></th>
            <th><fmt:message key="shopping-cart.jsp.days"/></th>
            <th class="hidden-print"><fmt:message key="shopping-cart.jsp.action"/></th>
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
                    <button class="btn btn-danger " name="deleteItem" data-id-product="${item.car.id}"><fmt:message
                            key="shopping-cart.jsp.remove"/></button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2" class="text-right"><strong><fmt:message key="shopping-cart.jsp.total"/></strong></td>
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
                            <label for="creditCardNum"><fmt:message key="shopping-cart.jsp.creditCart"/></label>
                            <input type="text" id="creditCardNum" name="creditCardNum" value="${order.creditCard}">
                        </div>
                        <div class="form-group">
                            <label for="address"><fmt:message key="shopping-cart.jsp.address"/></label>
                            <input type="text" id="address" name="address" value="${order.address}" required>

                        </div>
                        <button type="submit" class="btn btn-success"><fmt:message
                                key="shopping-cart.jsp.MakeOrder"/></button>
                    </form>

                </c:when>
                <c:otherwise>
                    <li>
                        <a class="btn btn-danger" href="signUp.jsp"><fmt:message key="header.jsp.signUp"/></a>
                    </li>
                    <li>
                        <a class="btn btn-danger" href="login.jsp"><fmt:message key="header.jsp.signIn"/></a>
                    </li>
                </c:otherwise>
            </c:choose>

        </div>
    </div>

</div>
