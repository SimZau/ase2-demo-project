package com.example.ase2demoproject.domain.enums;

public enum ProjectType {

    DESIGN_PROJECT_TYPE("DesignProjectType"),
    QUALITY_PROJECT_TYPE("DesignProjectType");

    private final String value;

    ProjectType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
