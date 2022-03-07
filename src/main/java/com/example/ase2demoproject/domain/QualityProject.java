package com.example.ase2demoproject.domain;

import com.example.ase2demoproject.domain.enums.ProjectType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("QualityProject")
public class QualityProject extends Project {
    public QualityProject() {
    }

    public QualityProject(String name) {
        super(name);
        super.type = ProjectType.QUALITY_PROJECT_TYPE.getValue();
    }
}
