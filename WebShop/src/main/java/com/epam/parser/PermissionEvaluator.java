package com.epam.parser;


public interface PermissionEvaluator {

    boolean hasAccess(String  role, String url);

    boolean isPathSecured(String url);
}
