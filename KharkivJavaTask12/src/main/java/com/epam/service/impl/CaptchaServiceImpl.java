package com.epam.service.impl;

import com.epam.captcha.CaptchaHandler;
import com.epam.creator.CaptchaCreator;
import com.epam.dao.CaptchaDao;
import com.epam.entity.Captcha;
import com.epam.exception.SessionTimeOutException;
import com.epam.service.CaptchaService;
import com.epam.utils.CaptchaConstants;

import javax.naming.directory.NoSuchAttributeException;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.util.Date;

public class CaptchaServiceImpl implements CaptchaService {

    private CaptchaDao captchaDao;

    public CaptchaServiceImpl(CaptchaDao captchaDao) {
        this.captchaDao = captchaDao;
    }

    @Override
    public CaptchaCreator create() {
        return new CaptchaCreator().setHeight(CaptchaConstants.CAPTCHA_HEIGHT)
                .setWidth(CaptchaConstants.CAPTCHA_WIDTH)
                .setSymbolCount(CaptchaConstants.SYMBOL_COUNT);
    }

    @Override
    public BufferedImage getBufferedImage(CaptchaCreator captchaCreator) throws NoSuchAttributeException {
        return captchaCreator.createImage();
    }

    @Override
    public void removeExpiredCaptcha() {
        captchaDao.getAllCaptches().forEach((key, value) -> {
            if (value.isExpiredValid()) {
                captchaDao.removeCaptcha(key);
            }
        });
    }

    @Override
    public boolean checkValid(HttpServletRequest request, CaptchaHandler handler) {
        try {
            Captcha captcha = handler.getCaptcha(request);
            return captcha.getNumbers().equals(request.getParameter(CaptchaConstants.CAPTCHA));
        } catch (SessionTimeOutException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Captcha createCaptcha(String captchaNumbers) {
        return new Captcha.CaptchaBuilder().setExpirationTime(new Date().getTime())
                .setNumbers(captchaNumbers).build();
    }
}
