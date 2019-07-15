package com.epam.servlet;

import com.epam.entity.User;
import com.epam.utils.Constants;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/avatar-image")
public class AvatarController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) getServletContext().getAttribute(Constants.CURRENT_ACCOUNT);

        resp.setContentType("image/jpeg");

        File f = new File(Constants.STORAGE_FOLDER_PATH + File.separator
                + user.getImageUrl());
        BufferedImage bi = ImageIO.read(f);
        OutputStream out = resp.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.close();
    }
}
