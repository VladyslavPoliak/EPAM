<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8" %>

<c:if test="${initParam.captchaHandler == 'hiddenFieldCaptchaHandler'}">
    <input type="hidden" name="CaptchaId" value="${CaptchaId}">
</c:if>
<img src="captchaController">