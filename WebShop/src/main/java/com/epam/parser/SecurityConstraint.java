package com.epam.parser;

import java.util.ArrayList;
import java.util.List;

public class SecurityConstraint {

    private final String urlPattern;
    private final List<String> roles;

    public SecurityConstraint(String urlPattern, List<String> roles) {
        this.urlPattern = urlPattern;
        this.roles = new ArrayList<>(roles);
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public List<String> getRoles() {
        return new ArrayList<>(roles);
    }

    @Override
    public String toString() {
        return "SecurityConstraint{" +
                "urlPattern='" + urlPattern + '\'' +
                ", roles=" + roles +
                '}';
    }
}
