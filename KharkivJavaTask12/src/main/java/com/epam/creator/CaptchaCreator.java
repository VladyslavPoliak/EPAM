package com.epam.creator;

import com.epam.utils.Constants;
import com.epam.utils.ConstantsForCaptcha;

import javax.naming.directory.NoSuchAttributeException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaCreator {

    private static final Font font = new Font(ConstantsForCaptcha.FONT_NAME, Font.BOLD,
            ConstantsForCaptcha.FONT_SIZE);
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
            builder.append(random.nextInt(Constants.RANDOM_NUMBERS));
        }
        captchaNumbers = builder.toString();
    }

    private BufferedImage createCaptchaBackground() throws NoSuchAttributeException {
        checkForAllAttributes();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(new Color(random.nextInt(ConstantsForCaptcha.BLACK_COLOR),
                random.nextInt(ConstantsForCaptcha.BLACK_COLOR),
                random.nextInt(ConstantsForCaptcha.BLACK_COLOR)));
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
                graphics.drawString(captchaNumbers.substring(i, i + 1),
                        ConstantsForCaptcha.DEFAULT_X * i,
                        ConstantsForCaptcha.UP_Y);
            } else {
                graphics.drawString(captchaNumbers.substring(i, i + 1),
                        ConstantsForCaptcha.DEFAULT_X * i,
                        ConstantsForCaptcha.DOWN_Y);
            }
        }
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
