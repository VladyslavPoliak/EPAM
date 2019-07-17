package com.epam.service;

import com.epam.captcha.CaptchaHandler;
import com.epam.creator.CaptchaCreator;
import com.epam.entity.Captcha;

import javax.naming.directory.NoSuchAttributeException;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

public interface CaptchaService {

    CaptchaCreator create();

    BufferedImage getBufferedImage(CaptchaCreator captchaCreator) throws NoSuchAttributeException;

    Captcha createCaptcha(String captchaNumbers);

    void removeExpiredCaptcha();

    boolean checkValid(HttpServletRequest request, CaptchaHandler handler);

}
