/*
 * UsersDao.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2016-05-25 Created
 */
package com.haihangyun.hcpaas.op.demo.dao;


import com.haihangyun.hcpaas.op.core.base.mybatis.MyMapper;
import com.haihangyun.hcpaas.op.demo.model.UsersVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 表名：users
 * 
 * @author WengKai
 * @version 1.0 2016-05-25
 */
public interface UsersDao extends MyMapper<UsersVo> {

    List<UsersVo> selectByPage(Map<String, Object> params);

    List<UsersVo> selectByPage(Map<String, Object> params, RowBounds rowBounds);

    List<UsersVo> selectByUserName(String userName);
}