package com.lbms.domain;

public class Cipher {
    private Integer cipid;

    private Integer admid;

    private Integer teaid;

    private Integer numid;

    private String cipher;

    private String power;

    private String username;

    public Integer getCipid() {
        return cipid;
    }

    public void setCipid(Integer cipid) {
        this.cipid = cipid;
    }

    public Integer getAdmid() {
        return admid;
    }

    public void setAdmid(Integer admid) {
        this.admid = admid;
    }

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
        this.teaid = teaid;
    }

    public Integer getNumid() {
        return numid;
    }

    public void setNumid(Integer numid) {
        this.numid = numid;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}