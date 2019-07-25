package com.epam.entity;

import com.epam.constans.CaptchaConstants;
import com.epam.utils.IdGenerator;

import java.io.Serializable;
import java.util.Objects;

public class Captcha implements Serializable {

    private static final long serialVersionUID = -6639136251148057053L;
    private final int id;
    private final String numbers;
    private final long expirationTime;

    private Captcha(CaptchaBuilder builder) {
        this.id = IdGenerator.getIdCaptcha();
        this.numbers = builder.numbers;
        this.expirationTime = builder.expirationTime;
    }

    public boolean isExpiredValid() {
        return System.currentTimeMillis() - expirationTime <=
                CaptchaConstants.CAPTCHA_LIVE_TIME;
    }

    public int getId() {
        return id;
    }

    public String getNumbers() {
        return numbers;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Captcha captcha = (Captcha) o;
        return id == captcha.id &&
                expirationTime == captcha.expirationTime &&
                Objects.equals(numbers, captcha.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numbers, expirationTime);
    }

    public static class CaptchaBuilder {

        private String numbers;
        private long expirationTime;

        public CaptchaBuilder setNumbers(String numbers) {
            this.numbers = numbers;
            return this;
        }

        public CaptchaBuilder setExpirationTime(long expirationTime) {
            this.expirationTime = expirationTime;
            return this;
        }

        public Captcha build() {
            return new Captcha(this);
        }
    }
}
