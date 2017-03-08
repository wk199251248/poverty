package com.haihangyun.hcpaas.op.core.shiro;

import com.haihangyun.hcpaas.op.core.base.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;


public class ShiroUtils {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final String ENCRYPTION_TEXT = "AMZ!@#$%^&SHA.?QQ";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	/**
	 * 判断是否超级管理员.
	 */
	public boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	public String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getUserAccount();
	}
	
	public static ShiroUser getCurrentUser() {
		Subject subject = getSubject();
		if(subject != null){
			return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		}
		return null;
	}
	
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 对密码进行md5加密,并返回密文和salt，包含在User对象中
	 * @param username 用户名
	 * @param password 密码
	 * @return 密文和salt
	 */
	public static ShiroCiphertext md5Password(String username,String password){
		if(StringUtils.isBlank(username)){
			throw new ServiceException("用户账号为空！");
		}
		if(StringUtils.isBlank(password)){
			throw new ServiceException("密码为空！");
		}
		SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator();
		secureRandomNumberGenerator.setDefaultNextBytesSize(SALT_SIZE);
		String salt= secureRandomNumberGenerator.nextBytes().toHex();
		//组合username,两次迭代，对密码进行加密
		String password_cipherText= new Md5Hash(password,username+salt+ENCRYPTION_TEXT,HASH_INTERATIONS).toHex();
		return  new ShiroCiphertext(salt, password_cipherText);
	}
	/**
	 * 通过username,password,salt,校验密文是否匹配 ，校验规则其实在配置文件中，这里为了清晰，写下来
	 * @param username 用户名
	 * @param password 原密码
	 * @param salt  盐
	 * @param md5cipherText 密文
	 * @return
	 */
	public static  boolean checkMd5Password(String username,String password,String salt,String md5cipherText)
	{
		if(StringUtils.isBlank(username)){
			throw new ServiceException("用户名为空！");
		}
		if(StringUtils.isBlank(password)){
			throw new ServiceException("密码为空！");
		}
		//组合username,两次迭代，对密码进行加密
		String password_cipherText= new Md5Hash(password,username+salt+ENCRYPTION_TEXT,HASH_INTERATIONS).toHex();
		return md5cipherText.equals(password_cipherText);
	}

}
