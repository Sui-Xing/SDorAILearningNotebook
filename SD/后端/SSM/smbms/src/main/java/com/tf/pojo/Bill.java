package com.tf.pojo;



public class Bill {
    private Long id;
    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private String productCount;
    private String totalPrice;
    private String isPayment;
    private String createdBy;
    private String creationDate;
    private String modifyDate;
    private String providerId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setIsPayment(String isPayment) {
        this.isPayment = isPayment;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Long getId() {
        return id;
    }

    public String getBillCode() {
        return billCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public String getProductCount() {
        return productCount;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getIsPayment() {
        return isPayment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public String getProviderId() {
        return providerId;
    }
}
