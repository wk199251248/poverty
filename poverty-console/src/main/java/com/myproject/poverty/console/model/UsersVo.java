/*
 * UsersVo.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2016-05-30 Created
 */
package com.myproject.poverty.console.model;

/**
 * users
 * 
 * @author WengKai
 * @version 1.0 2016-05-30
 */
public class UsersVo extends Users {

    private String domainUserAccount;

    private String userAccount;

    private String userPwd;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getDomainUserAccount() {
        return domainUserAccount;
    }

    public void setDomainUserAccount(String domainUserAccount) {
        this.domainUserAccount = domainUserAccount;
    }

}