package com.epam.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.*;

@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 300;
        int height = 80;
        List<Character> arrayList = new ArrayList<>();
        String capcode = "0123456789";
        for (int i = 1; i < capcode.length(); i++) {
            arrayList.add(capcode.charAt(i));
        }
        Collections.shuffle(arrayList);
        StringBuilder s2 = new StringBuilder();

        arrayList.forEach(s2::append);

        String s1 = s2.substring(0, 6);
        char[] s3 = s1.toCharArray();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setFont(new Font("Georgia", Font.BOLD, 35));
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(new Color(20, 183, 2));
        Random r = new Random();
        String captcha = String.copyValueOf(s3);
        request.getSession().setAttribute("captcha", captcha);
        int x = 0;
        int y;
        for (int i = 0; i < s3.length; i++) {
            x += 20 + (Math.abs(r.nextInt()) % 15);
            y = 40 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(s3, i, 1, x, y);
        }
        g2d.dispose();
        response.setContentType("image/png");

        OutputStream os = response.getOutputStream();
        ImageIO.write(bufferedImage, "png", os);
        os.flush();
        os.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
