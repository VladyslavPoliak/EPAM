package com.epam.service.impl;

import com.epam.captcha.CaptchaHandler;
import com.epam.creator.CaptchaCreator;
import com.epam.dao.CaptchaDao;
import com.epam.entity.Captcha;
import com.epam.exception.SessionTimeOutException;
import com.epam.service.CaptchaService;
import com.epam.utils.ConstantsForCaptcha;

import javax.imageio.ImageIO;
import javax.naming.directory.NoSuchAttributeException;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CaptchaServiceImpl implements CaptchaService {

    private CaptchaDao captchaDao;

    public CaptchaServiceImpl(CaptchaDao captchaDao) {
        this.captchaDao = captchaDao;
    }

    @Override
    public Captcha create() throws NoSuchAttributeException {
        CaptchaCreator captchaCreator = new CaptchaCreator().setHeight(ConstantsForCaptcha.CAPTCHA_HEIGHT)
                .setWidth(ConstantsForCaptcha.CAPTCHA_WIDTH)
                .setSymbolCount(ConstantsForCaptcha.SYMBOL_COUNT);
        BufferedImage image = captchaCreator.createImage();
        createImage(image);
        return createCaptcha(captchaCreator.getCaptchaNumbers());
    }

    @Override
    public void removeOldCaptcha() {
        captchaDao.getAllCaptches().forEach((key, value) -> {
            if (value.isValid()) {
                captchaDao.removeCaptcha(key);
            }
        });
    }

    @Override
    public boolean checkValid(HttpServletRequest request, CaptchaHandler handler) {
        try {
            Captcha captcha = handler.getCaptcha(request);
            return captcha.getNumbers().equals(request.getParameter(ConstantsForCaptcha.CAPTCHA));
        } catch (SessionTimeOutException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Captcha createCaptcha(String captchaNumbers) {
        return new Captcha.CaptchaBuilder().setExpirationTime(new Date().getTime())
                .setNumbers(captchaNumbers)
                .build();
    }

    private void createImage(BufferedImage image) {
        try {
            File file = new File(ConstantsForCaptcha.CAPTCHA_FILE_PATH);
            ImageIO.write(image, "jpeg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
