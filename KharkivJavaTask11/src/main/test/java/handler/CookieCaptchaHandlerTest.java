package handler;

import com.epam.captcha.impl.CookieCaptchaHandler;
import com.epam.entity.Captcha;
import com.epam.exception.SessionTimeOutException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CookieCaptchaHandlerTest {

    private static final String[] CAPTCHA_NAMES = new String[]{
            "captcha2", "captcha6", "captcha12", "captcha0",
            "asfs43", "captcha5"
    };

    private static final String[] CAPTCHA_VALUES = new String[]{
            "5", "4", "10", "23", "11", "45"
    };

    @Mock
    Captcha captcha;
    @Mock
    Map<Integer, Captcha> captchaMap;
    @Mock
    HttpServletRequest request;
    @InjectMocks
    CookieCaptchaHandler captchaHandler;
    private Cookie[] cookies;

    @Before
    public void setUp() {
        when(captchaMap.get(any())).thenReturn(captcha);
        cookieInit();
        when(request.getCookies()).thenReturn(cookies);
    }

    private void cookieInit() {
        cookies = new Cookie[CAPTCHA_NAMES.length];
        for (int i = 0; i < CAPTCHA_NAMES.length; i++) {
            cookies[i] = new Cookie(CAPTCHA_NAMES[i], CAPTCHA_VALUES[i]);
        }
    }

    @Test
    public void getCaptchaByOldestCookieValueWhenCallGetCaptcha() throws SessionTimeOutException {
        when(captcha.isValid()).thenReturn(true);
        assertEquals(captcha, captchaHandler.getCaptcha(request));
    }

    @Test(expected = SessionTimeOutException.class)
    public void getExceptionWhenFindCaptchaButTimedOut() throws SessionTimeOutException {
        when(captcha.isValid()).thenReturn(false);
        captchaHandler.getCaptcha(request);
    }
}
