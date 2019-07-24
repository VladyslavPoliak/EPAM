package com.epam.constans;

public final class Constants {

    public static final String USER_SERVICE = "USER_SERVICE";
    public static final String CAPTCHA_SERVICE = "CAPTCHA_SERVICE";
    public static final String CAR_SERVICE = "CAR_SERVICE";
    public static final String CAPTCHA_PRESERVER = "captchaPreserver";
    public static final String CAPTCHA_HANDLER = "captchaHandler";
    public static final String HIDDEN_FIELD_CAPTCHA_HANDLER = "hiddenFieldCaptchaHandler";
    public static final String COOKIE_CAPTCHA_HANDLER = "cookieCaptchaHandler";
    public static final String SESSION_CAPTCHA_HANDLER = "sessionCaptchaHandler";
    public static final String REGISTRATION_JSP = "signUp.jsp";
    public static final String MAIN_PAGE = "index.jsp";

    public static final String APPLICATION_PROPERTIES = "application.properties";
    public static final String CURRENT_ACCOUNT = "CURRENT_ACCOUNT";

    public static final String IMAGE_PARAMETER_NAME = "file";
    public static final String STORAGE_FOLDER_PATH = "storageFolderPath";
    public static final String IMAGE_CREATOR = "IMAGE_CREATOR";
    public static final String DEFAULT_AVATAR = "defaultAvatarPath";
    public static final String CLASSES_LIST = "CLASSES_LIST";
    public static final String MARKS_LIST = "MARKS_LIST";

    public static final int MAX_CARS_FOR_ONE_USER = 20;
    public static final String SUCCESS_REDIRECT_URL_AFTER_SIGN_IN = "SUCCESS_REDIRECT_URL_AFTER_SIGN_IN";
    public static final String CURRENT_REQUEST_URL = "CURRENT_REQUEST_URL";
    public static final String ORDER_SERVICE = "ORDER_SERVICE";
    public static final String CURRENT_SHOPPING_CART = "CURRENT_SHOPPING_CART";


    private Constants() {
    }

    public enum Cookie {
        //1 year ttl
        SHOPPING_CART("iSCC", 60 * 60 * 24 * 365);

        private final String name;
        private final int ttl;

        Cookie(String name, int ttl) {
            this.name = name;
            this.ttl = ttl;
        }

        public String getName() {
            return name;
        }

        public int getTtl() {
            return ttl;
        }
    }
}
