package com.myproject.poverty.console.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by miracle on 2017/3/8.
 */
@Entity
@Table(name = "system_role", schema = "poverty")
public class SystemRole implements Serializable {
    private int roleId;
    private String roleName;
    private Byte hasDeleted;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "has_deleted")
    public Byte getHasDeleted() {
        return hasDeleted;
    }

    public void setHasDeleted(Byte hasDeleted) {
        this.hasDeleted = hasDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemRole that = (SystemRole) o;

        if (roleId != that.roleId) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (hasDeleted != null ? !hasDeleted.equals(that.hasDeleted) : that.hasDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (hasDeleted != null ? hasDeleted.hashCode() : 0);
        return result;
    }
}
