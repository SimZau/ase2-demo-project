package com.example.ase2demoproject.domain;

import com.example.ase2demoproject.domain.enums.ProjectType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DesignProject")
public class DesignProject extends Project {
    private Integer innovationLevel;

    public Integer getInnovationLevel() {
        return innovationLevel;
    }

    public void setInnovationLevel(Integer innovationLevel) {
        this.innovationLevel = innovationLevel;
    }

    public DesignProject() {
    }

    public DesignProject(String name) {
        super(name);
        super.type = ProjectType.DESIGN_PROJECT_TYPE.getValue();
    }
}
