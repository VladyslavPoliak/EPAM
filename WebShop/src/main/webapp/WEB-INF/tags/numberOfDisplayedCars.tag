<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ tag language="java" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="button-group">
                <button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"> <span
                        class="glyphicon glyphicon-cog"> <fmt:message key="aside.jsp.display"/></span></button>
                <ul class="dropdown-menu">
                    <li><input type="radio" value="6" name="count" checked/>6 <fmt:message
                            key="aside.jsp.displayCount"/></li>
                    <li><input type="radio" value="9" name="count"/>9 <fmt:message key="aside.jsp.displayCount"/></li>
                    <li><input type="radio" value="12" name="count"/>12 <fmt:message key="aside.jsp.displayCount"/></li>
                    <li><input type="radio" value="15" name="count"/>15 <fmt:message key="aside.jsp.displayCount"/></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<br/><br/>