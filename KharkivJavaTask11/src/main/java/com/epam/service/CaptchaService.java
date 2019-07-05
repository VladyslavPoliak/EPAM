package com.epam.service;

import com.epam.captcha.CaptchaHandler;
import com.epam.entity.Captcha;

import javax.naming.directory.NoSuchAttributeException;
import javax.servlet.http.HttpServletRequest;

public interface CaptchaService {

    Captcha create() throws NoSuchAttributeException;

    void removeOldCaptcha();

    boolean checkValid(HttpServletRequest request, CaptchaHandler handler);

}
