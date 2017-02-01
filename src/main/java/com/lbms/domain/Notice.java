package com.lbms.domain;

import java.util.Date;

public class Notice {
    private Integer noticeid;

    private String noticetile;

    private String noticecontent;

    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}