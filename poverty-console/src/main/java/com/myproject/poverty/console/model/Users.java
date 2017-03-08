package com.myproject.poverty.console.model;

import com.myproject.poverty.core.base.result.BasePageEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by miracle on 2017/2/28.
 */
@Entity
public class Users extends BasePageEntity implements Serializable {
    private int userId;
    private String osUsername;
    private String osPassword;
    private String phone;
    private String email;
    private String imageNamespace;
    private String username;
    private String description;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String userStatus;
    private String userType;
    private String hnaAccountId;
    private Integer harborId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "os_username")
    public String getOsUsername() {
        return osUsername;
    }

    public void setOsUsername(String osUsername) {
        this.osUsername = osUsername;
    }

    @Basic
    @Column(name = "os_password")
    public String getOsPassword() {
        return osPassword;
    }

    public void setOsPassword(String osPassword) {
        this.osPassword = osPassword;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "image_namespace")
    public String getImageNamespace() {
        return imageNamespace;
    }

    public void setImageNamespace(String imageNamespace) {
        this.imageNamespace = imageNamespace;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "user_status")
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "hna_account_id")
    public String getHnaAccountId() {
        return hnaAccountId;
    }

    public void setHnaAccountId(String hnaAccountId) {
        this.hnaAccountId = hnaAccountId;
    }

    @Basic
    @Column(name = "harbor_id")
    public Integer getHarborId() {
        return harborId;
    }

    public void setHarborId(Integer harborId) {
        this.harborId = harborId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (osUsername != null ? !osUsername.equals(users.osUsername) : users.osUsername != null) return false;
        if (osPassword != null ? !osPassword.equals(users.osPassword) : users.osPassword != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (imageNamespace != null ? !imageNamespace.equals(users.imageNamespace) : users.imageNamespace != null)
            return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (description != null ? !description.equals(users.description) : users.description != null) return false;
        if (createTime != null ? !createTime.equals(users.createTime) : users.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(users.updateTime) : users.updateTime != null) return false;
        if (userStatus != null ? !userStatus.equals(users.userStatus) : users.userStatus != null) return false;
        if (userType != null ? !userType.equals(users.userType) : users.userType != null) return false;
        if (hnaAccountId != null ? !hnaAccountId.equals(users.hnaAccountId) : users.hnaAccountId != null) return false;
        if (harborId != null ? !harborId.equals(users.harborId) : users.harborId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (osUsername != null ? osUsername.hashCode() : 0);
        result = 31 * result + (osPassword != null ? osPassword.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (imageNamespace != null ? imageNamespace.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (hnaAccountId != null ? hnaAccountId.hashCode() : 0);
        result = 31 * result + (harborId != null ? harborId.hashCode() : 0);
        return result;
    }
}
