<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="captchaId" required="false" %>

<div>
    <c:if test="${initParam.captchaHandler == 'hiddenFieldCaptchaHandler'}">
        <input type="hidden" name="CaptchaId" value="${CaptchaId}">
    </c:if>
    <img src="captchaController">
</div>