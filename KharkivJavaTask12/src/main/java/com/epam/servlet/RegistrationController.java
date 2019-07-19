package com.epam.servlet;

import com.epam.constans.Constants;
import com.epam.entity.User;
import com.epam.form.RegistrationForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class RegistrationController extends AbstractController {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("userEmail");
        // TODO: 7/18/2019 || !getCaptchaService().checkValid(req, getCaptchaHandler())
        if (getUserService().isUserExists(login)) {
            saveInfo(req);
            req.getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, resp);
        } else {
            createNewUser(req);
            resp.sendRedirect(Constants.MAIN_PAGE);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(Constants.MAIN_PAGE);
    }

    private void createNewUser(HttpServletRequest req) throws IOException, ServletException {
        User user = new RegistrationForm().createUserByRequest(req);
        getImageCreator().loadAndSaveImage(req.getPart(Constants.IMAGE_PARAMETER_NAME), user.getEmail());
        user.setImageUrl(getImageCreator().getFileNameForSpecificUser());
        getUserService().addNewUser(user);
        getServletContext().setAttribute(Constants.CURRENT_ACCOUNT, user);
    }

    private void saveInfo(HttpServletRequest req) {
        req.setAttribute("name", req.getParameter("userName"));
        req.setAttribute("surName", req.getParameter("userSurname"));
        req.setAttribute("login", req.getParameter("userEmail"));
        req.setAttribute("password", req.getParameter("userPassword"));
    }
}
