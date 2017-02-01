package com.lbms.domain;

import java.util.Date;

public class Test {
    private Integer testid;

    private Integer batid;

    private Integer numid;

    private String grade;

    private Integer results;

    private Date date;

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public Integer getBatid() {
        return batid;
    }

    public void setBatid(Integer batid) {
        this.batid = batid;
    }

    public Integer getNumid() {
        return numid;
    }

    public void setNumid(Integer numid) {
        this.numid = numid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}