/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.myproject.poverty.console.config;

import com.myproject.poverty.console.model.BasicUser;
import com.myproject.poverty.console.model.SystemRole;
import com.myproject.poverty.console.service.IBasicUserService;
import com.myproject.poverty.core.base.exception.ServiceException;
import com.myproject.poverty.core.shiro.ShiroUser;
import com.myproject.poverty.core.shiro.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class ShiroDbRealm extends AuthorizingRealm {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;

	@Autowired
	private IBasicUserService basicUserService;

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		String userAccount = ((UsernamePasswordToken) authcToken).getUsername();
		List<BasicUser> users = basicUserService.findByUserAccount(userAccount);
		if(users == null || (users != null && users.size() == 0)){
			throw new ServiceException("账号不存在！");
		}else if(users != null && users.size() > 1){
			throw new ServiceException("存在同名账号无法识别，请联系管理员！");
		}
		BasicUser user = users.get(0);
		ShiroUser su = new ShiroUser();
		su.setUserId(user.getUserId());
		su.setUserAccount(user.getUserAccount());
		su.setUserName(user.getUserName());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(su, user.getPassword(), getName());
		authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getUserAccount()+user.getSalt()+ ShiroUtils.ENCRYPTION_TEXT));
		return authenticationInfo;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		List<BasicUser> users = basicUserService.findByUserAccount(shiroUser.getUserAccount());
		if(users == null || (users != null && users.size() == 0)){
			throw new ServiceException("账号不存在！");
		}else if(users != null && users.size() > 1){
			throw new ServiceException("存在同名账号无法识别，请联系管理员！");
		}
		BasicUser user = users.get(0);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<String> roles = new ArrayList<String>();
		setRoles(user, roles);
		info.addRoles(roles);
		user = null;
		return info;
	}

	private void setRoles(BasicUser user, List<String> roles){
		StringBuffer strBuff = new StringBuffer();
		if(user != null){
			if(user.getSystemRoles() != null){
				for(SystemRole role : user.getSystemRoles()){
					roles.add(role.getRoleName());
				}
			}
		}
	}
}
