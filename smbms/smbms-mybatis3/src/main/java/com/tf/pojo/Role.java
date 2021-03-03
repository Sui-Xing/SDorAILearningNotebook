package com.tf.pojo;


import java.util.Date;

public class Role {
    private Long id;
    private String roleCode;
    private String roleName;
    private Long createdBy;
    private Date creationDate;
    private Long modifyBy;
    private Date modeifyDate;

    public Role() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public void setModeifyDate(Date modeifyDate) {
        this.modeifyDate = modeifyDate;
    }

    public Long getId() {
        return id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public Date getModeifyDate() {
        return modeifyDate;
    }
}
