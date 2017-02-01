package com.lbms.domain;

import java.util.Date;

public class Student {
    private Integer numid;

    private String name;

    private String sex;

    private String specialization;

    private String grade;

    private Date date;

    private String contact;

    public Integer getNumid() {
        return numid;
    }

    public void setNumid(Integer numid) {
        this.numid = numid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}