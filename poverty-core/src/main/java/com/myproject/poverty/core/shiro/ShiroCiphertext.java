package com.myproject.poverty.core.shiro;

/**
 * Created by miracle on 2016/2/23.
 */
public class ShiroCiphertext {

    private String salt;

    private String encryptionPwd;

    public ShiroCiphertext(){}
    public ShiroCiphertext(String salt, String encryptionPwd){
        this.salt = salt;
        this.encryptionPwd = encryptionPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEncryptionPwd() {
        return encryptionPwd;
    }

    public void setEncryptionPwd(String encryptionPwd) {
        this.encryptionPwd = encryptionPwd;
    }
}
