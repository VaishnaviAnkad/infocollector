package com.AvirantEnterprises.InfoCollector_AE.model.educational;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pucInstitution;
    private double pucPercentage;
    private String degreeName;
    private double degreePercentage;
    private String pgName;
    private Double pgPercentage;
    private String course; // New field



    public String getPucInstitution() {
        return pucInstitution;
    }

    public void setPucInstitution(String pucInstitution) {
        this.pucInstitution = pucInstitution;
    }

    public double getPucPercentage() {
        return pucPercentage;
    }

    public void setPucPercentage(double pucPercentage) {
        this.pucPercentage = pucPercentage;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public double getDegreePercentage() {
        return degreePercentage;
    }

    public void setDegreePercentage(double degreePercentage) {
        this.degreePercentage = degreePercentage;
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    public Double getPgPercentage() {
        return pgPercentage;
    }

    public void setPgPercentage(Double pgPercentage) {
        this.pgPercentage = pgPercentage;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPuc() {
        return "";
    }

    public String getDegree() {
        return "";
    }

    public String getPg() {
        return "";
    }
}
