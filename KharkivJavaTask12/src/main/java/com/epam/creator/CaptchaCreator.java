package com.epam.creator;

import com.epam.utils.CaptchaConstants;
import com.epam.utils.Constants;

import javax.naming.directory.NoSuchAttributeException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaCreator {

    private static final Font font = new Font(CaptchaConstants.FONT_NAME, Font.BOLD,
            CaptchaConstants.FONT_SIZE);
    private static final Random random = new Random();
    private String captchaNumbers;
    private int width;
    private int height;
    private int symbolCount;

    public BufferedImage createImage() throws NoSuchAttributeException {
        createCaptchaNumbers();
        BufferedImage image = createCaptchaBackground();
        return getCaptchaWithNumbers(image);
    }

    private void createCaptchaNumbers() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < symbolCount; i++) {
            builder.append(random.nextInt(CaptchaConstants.RANDOM_NUMBERS));
        }
        captchaNumbers = builder.toString();
    }

    private BufferedImage createCaptchaBackground() throws NoSuchAttributeException {
        checkForAllAttributes();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(new Color(random.nextInt(CaptchaConstants.BLACK_COLOR),
                random.nextInt(CaptchaConstants.BLACK_COLOR),
                random.nextInt(CaptchaConstants.BLACK_COLOR)));
        return image;
    }

    private void checkForAllAttributes() throws NoSuchAttributeException {
        if (width == 0 || height == 0) {
            throw new NoSuchAttributeException();
        }
    }

    private BufferedImage getCaptchaWithNumbers(BufferedImage image) {
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setFont(font);
        addNumberInImage(graphics);
        return image;
    }

    private void addNumberInImage(Graphics2D graphics) {
        for (int i = 0; i < symbolCount; i++) {
            if (i % 2 == 0) {
                drawString(graphics, i, CaptchaConstants.UP_Y);
            } else {
                drawString(graphics, i, CaptchaConstants.DOWN_Y);
            }
        }
    }

    private void drawString(Graphics2D graphics, int i, int coordinate) {
        graphics.drawString(captchaNumbers.substring(i, i + 1),
                CaptchaConstants.DEFAULT_X * i,
                coordinate);
    }


    public String getCaptchaNumbers() {
        return captchaNumbers;
    }

    public CaptchaCreator setWidth(int width) {
        this.width = width;
        return this;
    }

    public CaptchaCreator setHeight(int height) {
        this.height = height;
        return this;
    }

    public CaptchaCreator setSymbolCount(int symbolCount) {
        this.symbolCount = symbolCount;
        return this;
    }
}
