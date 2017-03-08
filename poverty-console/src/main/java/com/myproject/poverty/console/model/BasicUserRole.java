package com.myproject.poverty.console.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by miracle on 2017/3/8.
 */
@Entity
@Table(name = "basic_user_role", schema = "poverty")
public class BasicUserRole implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "role_id" ,nullable = false)
    private Integer roleId;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id" ,nullable = false)
    private Integer userId;


    @ManyToOne
    @JoinColumn(name="user_id" ,insertable=false,updatable=false)
    private BasicUser basicUser;

    @ManyToOne
    @JoinColumn(name="role_id" ,insertable=false,updatable=false)
    private SystemRole systemRole;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BasicUser getBasicUser() {
        return basicUser;
    }

    public void setBasicUser(BasicUser basicUser) {
        this.basicUser = basicUser;
    }

    public SystemRole getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }
}
