package com.myproject.poverty.console.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by miracle on 2017/3/8.
 */
@Entity
@Table(name = "system_permission", schema = "poverty")
public class SystemPermission implements Serializable {
    private int permissionId;
    private String permissionName;
    private String permissionUrls;
    private String permissionDesc;
    private byte hasDeleted;

    @Id
    @Column(name = "permission_id")
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "permission_name")
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Basic
    @Column(name = "permission_urls")
    public String getPermissionUrls() {
        return permissionUrls;
    }

    public void setPermissionUrls(String permissionUrls) {
        this.permissionUrls = permissionUrls;
    }

    @Basic
    @Column(name = "permission_desc")
    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    @Basic
    @Column(name = "has_deleted")
    public byte getHasDeleted() {
        return hasDeleted;
    }

    public void setHasDeleted(byte hasDeleted) {
        this.hasDeleted = hasDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemPermission that = (SystemPermission) o;

        if (permissionId != that.permissionId) return false;
        if (hasDeleted != that.hasDeleted) return false;
        if (permissionName != null ? !permissionName.equals(that.permissionName) : that.permissionName != null)
            return false;
        if (permissionUrls != null ? !permissionUrls.equals(that.permissionUrls) : that.permissionUrls != null)
            return false;
        if (permissionDesc != null ? !permissionDesc.equals(that.permissionDesc) : that.permissionDesc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionId;
        result = 31 * result + (permissionName != null ? permissionName.hashCode() : 0);
        result = 31 * result + (permissionUrls != null ? permissionUrls.hashCode() : 0);
        result = 31 * result + (permissionDesc != null ? permissionDesc.hashCode() : 0);
        result = 31 * result + (int) hasDeleted;
        return result;
    }
}
