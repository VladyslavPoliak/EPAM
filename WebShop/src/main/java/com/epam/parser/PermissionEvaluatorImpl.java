package com.epam.parser;

public class PermissionEvaluatorImpl implements PermissionEvaluator {

    private SecurityProperties securityProperties;

    public PermissionEvaluatorImpl(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public boolean hasAccess(String role, String url) {
        if (!isPathSecured(url)) {
            return true;
        } else {
            for (SecurityConstraint c : securityProperties.getSecurityConstraints()) {
                if (url.matches(c.getUrlPattern())) {
                    return c.getRoles().contains(role);
                }
            }
            return false;
        }
    }

    @Override
    public boolean isPathSecured(String url) {
        for (SecurityConstraint c : securityProperties.getSecurityConstraints()) {
            if (url.matches(c.getUrlPattern())) {
                return true;
            }
        }
        return false;
    }
}
