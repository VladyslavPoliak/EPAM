package com.epam.captcha;

import com.epam.entity.Captcha;
import com.epam.exception.SessionTimeOutException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaHandler {

    void addCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha);

    Captcha getCaptcha(HttpServletRequest request) throws SessionTimeOutException;

}
