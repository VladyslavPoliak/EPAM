package handler;

import com.epam.captcha.impl.HiddenFieldCaptchaHandler;
import com.epam.entity.Captcha;
import com.epam.exception.SessionTimeOutException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HiddenFieldCaptchaHandlerTest {

    private static final String HIDDEN_FIELD_VALUE = "10";

    @Mock
    private Captcha captcha;

    @Mock
    private HttpServletRequest request;

    @Mock
    private Map<Integer, Captcha> captchas;

    @InjectMocks
    private HiddenFieldCaptchaHandler handler;

    @Before
    public void setUp() {
        when(request.getParameter(any())).thenReturn(HIDDEN_FIELD_VALUE);
        when(captchas.get(any())).thenReturn(captcha);
    }

    @Test
    public void getCaptchaByIdInHiddenFieldWhenCallGetCaptcha() throws SessionTimeOutException {
        when(captcha.isExpiredValid()).thenReturn(true);
        assertEquals(captcha, handler.getCaptcha(request));
    }

    @Test(expected = SessionTimeOutException.class)
    public void throwExceptionGetCaptchaByIdInHiddenFieldButTimeOut() throws SessionTimeOutException {
        when(captcha.isExpiredValid()).thenReturn(false);
        handler.getCaptcha(request);
    }

}
