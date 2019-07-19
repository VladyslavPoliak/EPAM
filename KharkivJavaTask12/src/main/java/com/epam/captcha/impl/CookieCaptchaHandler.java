package com.epam.captcha.impl;

import com.epam.captcha.AbstractCaptchaHandler;
import com.epam.constans.CaptchaConstants;
import com.epam.entity.Captcha;
import com.epam.exception.SessionTimeOutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class CookieCaptchaHandler extends AbstractCaptchaHandler {

    private int oldestCookieId = 0;
    private Cookie oldestCookie;

    public CookieCaptchaHandler(Map<Integer, Captcha> captches) {
        super(captches);
    }

    @Override
    public void addCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        captches.put(captcha.getId(), captcha);
        response.addCookie(new Cookie(CaptchaConstants.CAPTCHA +
                captcha.getId(), "" + captcha.getId()));
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) throws SessionTimeOutException {
        int cookieId = getOldestCaptchaIdByCookie(request);
        Captcha captcha = captches.get(cookieId);
        if (captcha.isExpiredValid()) {
            return captcha;
        }
        throw new SessionTimeOutException();
    }

    private int getOldestCaptchaIdByCookie(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().startsWith(CaptchaConstants.CAPTCHA)) {
                findValidCookie(cookie);
            }
        }
        return Integer.parseInt(oldestCookie.getValue());
    }

    private void findValidCookie(Cookie cookie) {
        if (oldestCookie == null) {
            firstCookie(cookie);
        } else {
            findOlderCookie(cookie);
        }
    }

    private void firstCookie(Cookie cookie) {
        oldestCookie = cookie;
        oldestCookieId = Integer.parseInt(cookie.getName()
                .replace(CaptchaConstants.CAPTCHA, ""));
    }

    private void findOlderCookie(Cookie cookie) {
        int idCaptcha = Integer.parseInt(cookie.getName()
                .replace(CaptchaConstants.CAPTCHA, ""));
        if (idCaptcha >= oldestCookieId) {
            oldestCookie = cookie;
            oldestCookieId = idCaptcha;
        }
    }

}
