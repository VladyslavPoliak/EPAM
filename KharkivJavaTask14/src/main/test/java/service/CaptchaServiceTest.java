package service;

import com.epam.captcha.CaptchaHandler;
import com.epam.container.CaptchaContainer;
import com.epam.entity.Captcha;
import com.epam.exception.SessionTimeOutException;
import com.epam.service.impl.CaptchaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.naming.directory.NoSuchAttributeException;
import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CaptchaServiceTest {

    private static final String CAPTCHA_NUMBERS = "666";
    private CaptchaContainer captchaContainer = new CaptchaContainer();

    @Mock
    private HttpServletRequest request;

    @Mock
    private Captcha captcha;

    @Mock
    private CaptchaHandler captchaHandler;

    @InjectMocks
    private CaptchaServiceImpl captchaService;

    @Before
    public void setUp() {
        captchaService = new CaptchaServiceImpl(captchaContainer);
    }

    @Test
    public void createCaptcha() throws NoSuchAttributeException {
        captchaService.create();
    }

    @Test
    public void checkCaptchaOnValidAndReturnTrueWhenCaptchaIsValid() throws SessionTimeOutException {
        when(captchaHandler.getCaptcha(request)).thenReturn(captcha);
        when(captcha.getNumbers()).thenReturn(CAPTCHA_NUMBERS);
        when(request.getParameter(anyString())).thenReturn(CAPTCHA_NUMBERS);
        assertTrue(captchaService.checkValid(request, captchaHandler));
    }

    @Test
    public void checkCaptchaOnValidAndReturnFalseWhenCaptchaIsNotValid() throws SessionTimeOutException {
        when(captchaHandler.getCaptcha(request)).thenThrow(SessionTimeOutException.class);
        assertFalse(captchaService.checkValid(request, captchaHandler));
    }

}
