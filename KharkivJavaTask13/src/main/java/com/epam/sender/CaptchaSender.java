package com.epam.sender;

import javax.servlet.http.HttpServletRequest;

public class CaptchaSender {

    private HttpServletRequest request;
    private Integer captchaId = 0;
    private boolean isExpiredValid = false;

    public CaptchaSender(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public CaptchaSender setRequest(HttpServletRequest request) {
        this.request = request;
        return this;
    }

    public Integer getCaptchaId() {
        return captchaId;
    }

    public CaptchaSender setCaptchaId(Integer captchaId) {
        this.captchaId = captchaId;
        return this;
    }

    public boolean isExpiredValid() {
        return isExpiredValid;
    }

    public CaptchaSender setExpiredValid(boolean expiredValid) {
        isExpiredValid = expiredValid;
        return this;
    }

    public void send() {
        request.getSession().setAttribute("sessionCaptchaId", captchaId);
        request.setAttribute("requestCaptchaId", captchaId);
        request.setAttribute("isExpiredValid", isExpiredValid);
        request.getSession().setAttribute("hiddenCaptcha", captchaId);
    }
}
