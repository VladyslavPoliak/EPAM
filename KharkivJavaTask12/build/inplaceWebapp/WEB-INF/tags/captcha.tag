<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="captchaId" required="false" %>

<div>
    <c:if test="${initParam.captchaHandler == 'hiddenFieldCaptchaHandler'}">
        <input type="hidden" name="CaptchaId" value="${CaptchaId}">
    </c:if>
    <img src="captchaController">
</div>