package com.epam.container;

import com.epam.captcha.CaptchaHandler;
import com.epam.captcha.impl.CookieCaptchaHandler;
import com.epam.captcha.impl.HiddenFieldCaptchaHandler;
import com.epam.captcha.impl.SessionCaptchaHandler;
import com.epam.entity.Captcha;
import com.epam.constans.Constants;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CaptchaHandlerContainer {

    private final Map<Integer, Captcha> captches = new LinkedHashMap<>();
    private Map<String, CaptchaHandler> handlers = new HashMap<>();

    public CaptchaHandlerContainer() {
        handlersInit();
    }

    private void handlersInit() {
        handlers.put(Constants.HIDDEN_FIELD_CAPTCHA_HANDLER, new HiddenFieldCaptchaHandler(captches));
        handlers.put(Constants.COOKIE_CAPTCHA_HANDLER, new CookieCaptchaHandler(captches));
        handlers.put(Constants.SESSION_CAPTCHA_HANDLER, new SessionCaptchaHandler(captches));
    }

    public CaptchaHandler getCaptchaHandler(String handlerName) {
        return handlers.get(handlerName);
    }

}
