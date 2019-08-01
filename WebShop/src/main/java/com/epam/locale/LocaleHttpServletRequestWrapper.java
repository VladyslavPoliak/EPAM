package com.epam.locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class LocaleHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private Locale locale;

    public LocaleHttpServletRequestWrapper(HttpServletRequest request, Locale locale) {
        super(request);
        this.locale = locale;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public Enumeration<Locale> getLocales() {
        Set<Locale> locales = new HashSet<>();
        locales.add(locale);
        return Collections.enumeration(locales);
    }

}
