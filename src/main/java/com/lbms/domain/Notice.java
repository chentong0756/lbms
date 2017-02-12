package com.lbms.domain;

public class Notice {
    private Integer noticeid;

    private String noticetile;

    private String noticecontent;

    private String date;

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticetile() {
        return noticetile;
    }

    public void setNoticetile(String noticetile) {
        this.noticetile = noticetile;
    }

    public String getNoticecontent() {
        return noticecontent;
    }

    public void setNoticecontent(String noticecontent) {
        this.noticecontent = noticecontent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}