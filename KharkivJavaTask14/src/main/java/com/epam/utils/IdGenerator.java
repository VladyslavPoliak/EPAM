package com.epam.utils;

public class IdGenerator {

    private static int idCaptcha = 1;

    public static int getIdCaptcha() {
        return idCaptcha++;
    }

}
