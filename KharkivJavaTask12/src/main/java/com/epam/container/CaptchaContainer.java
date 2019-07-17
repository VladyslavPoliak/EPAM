package com.epam.container;

import com.epam.entity.Captcha;

import java.util.LinkedHashMap;
import java.util.Map;

public class CaptchaContainer {

    private Map<Integer, Captcha> captcha;

    public CaptchaContainer() {
        this.captcha = new LinkedHashMap<>();
    }

    public void removeCaptcha(int key) {
        captcha.remove(key);
    }

    public Map<Integer, Captcha> getAllCaptches() {
        return captcha;
    }
}
