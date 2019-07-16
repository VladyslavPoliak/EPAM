package com.epam.dao;

import com.epam.entity.Captcha;

import java.util.Map;

public interface CaptchaDao {

    Captcha addCaptcha(Captcha captcha);

    boolean containsCaptcha(int key);

    Captcha getCaptcha(int key);

    void removeCaptcha(int key);

    Map<Integer, Captcha> getAllCaptches();

}
