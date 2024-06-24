package com.tf.pojo;
import java.util.Date;

public class Provider {
    private String proCode;
    private String proName;
    private String proDesc;
    private String proContact;
    private String proPhone;
    private String proAddress;
    private String proFax;
    private Long createdBy;
    private Date creationDate;
    private Date modifyDate;
    private Long modifyBy;

    public Provider() {
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public void setProContact(String proContact) {
        this.proContact = proContact;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    public void setProFax(String proFax) {
        this.proFax = proFax;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getProCode() {
        return proCode;
    }

    public String getProName() {
        return proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public String getProContact() {
        return proContact;
    }

    public String getProPhone() {
        return proPhone;
    }

    public String getProAddress() {
        return proAddress;
    }

    public String getProFax() {
        return proFax;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }
}
