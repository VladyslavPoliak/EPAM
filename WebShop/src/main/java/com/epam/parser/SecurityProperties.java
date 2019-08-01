package com.epam.parser;

import java.util.ArrayList;
import java.util.List;

public class SecurityProperties {
    private List<SecurityConstraint> securityConstraints;

    public SecurityProperties(List<SecurityConstraint> securityConstraints) {
        this.securityConstraints = new ArrayList<>(securityConstraints);
    }

    public List<SecurityConstraint> getSecurityConstraints() {
        return new ArrayList<>(securityConstraints);
    }

    @Override
    public String toString() {
        return "SecurityProperties{" +
                "securityConstraints=" + securityConstraints +
                '}';
    }
}
