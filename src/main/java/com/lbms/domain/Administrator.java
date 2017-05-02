package com.lbms.domain;

public class Administrator {
    private Integer admid;
    
    private String username;
    
    private Integer itemid;

    private String name;

    private String sex;

    private String contact;

    public Integer getAdmid() {
        return admid;
    }

    public void setAdmid(Integer admid) {
        this.admid = admid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
}