package controller;

import com.epam.captcha.CaptchaHandler;
import com.epam.creator.ImageCreator;
import com.epam.service.CaptchaService;
import com.epam.service.UserService;
import com.epam.servlet.RegistrationController;
import com.epam.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerControllerTest {

    private static final String LOGIN = "login";
    private static final int ONE_TIME = 1;
    @Mock
    ImageCreator creator;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private ServletContext servletContext;
    @Mock
    private HttpServletRequest request;
    @Mock
    private CaptchaHandler captchaHandler;
    @Mock
    private HttpServletResponse response;
    @Mock
    private CaptchaService captchaService;
    @Mock
    private UserService userService;
    @Mock
    private RequestDispatcher dispatcher;
    @InjectMocks
    private RegistrationController controller;

    @Before
    public void setUp() {
        when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(dispatcher);
        when(request.getParameter(Mockito.anyString())).thenReturn(LOGIN);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
    }

    @Test
    public void goToRegistrationPageIfUserExist() throws ServletException, IOException {
        when(userService.isUserExists(LOGIN)).thenReturn(true);
        controller.doPost(request, response);
        verify(dispatcher, Mockito.times(ONE_TIME)).forward(request, response);
    }

    @Test
    public void goToMainPageIfUserNoExist() throws ServletException, IOException {
        when(userService.isUserExists(LOGIN)).thenReturn(false);
        when(captchaService.checkValid(request, captchaHandler)).thenReturn(true);
        when(creator.getFileNameForSpecificUser()).thenReturn("sds");
        controller.doPost(request, response);
        verify(response, Mockito.times(ONE_TIME)).sendRedirect(Constants.MAIN_PAGE);
    }
}
