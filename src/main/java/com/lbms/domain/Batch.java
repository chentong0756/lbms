package com.lbms.domain;

import java.util.Date;

public class Batch {
    private Integer batid;

    private Integer itemid;

    private Integer teaid;

    private String laboratory;

    private Date date;

    private String segmentation;

    private Boolean sure;

    public Integer getBatid() {
        return batid;
    }

    public void setBatid(Integer batid) {
        this.batid = batid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
        this.teaid = teaid;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSegmentation() {
        return segmentation;
    }

    public void setSegmentation(String segmentation) {
        this.segmentation = segmentation;
    }

    public Boolean getSure() {
        return sure;
    }

    public void setSure(Boolean sure) {
        this.sure = sure;
    }
}