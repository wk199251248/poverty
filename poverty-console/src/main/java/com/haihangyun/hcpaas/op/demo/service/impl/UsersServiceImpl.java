package com.haihangyun.hcpaas.op.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.haihangyun.hcpaas.op.demo.dao.UsersDao;
import com.haihangyun.hcpaas.op.demo.model.Users;
import com.haihangyun.hcpaas.op.demo.model.UsersVo;
import com.haihangyun.hcpaas.op.demo.repository.UsersRepository;
import com.haihangyun.hcpaas.op.demo.service.IUsersService;
import org.apache.ibatis.session.RowBounds;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by miracle on 2017/2/28.
 */
@Component
@CacheConfig(cacheNames = "users")
public class UsersServiceImpl implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersDao usersDao;

    @Cacheable
    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    }

    public Page<Users> findPageUsers(UsersVo vo){
        return usersRepository.findAll(vo.getPageable());
    }

    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,rollbackFor=Exception.class)
    public com.github.pagehelper.Page<UsersVo> queryPageUsers(UsersVo vo){
        PageHelper.startPage(vo.getPageIndex(), vo.getPageSize());
        List<UsersVo> list = usersDao.selectByPage(null);
        return (com.github.pagehelper.Page)list;
    }

    public List<Users> findByUsername(String username){
        return usersRepository.findByUsername(username);
    }

    public List<UsersVo> queryAllUsers(){
        return usersDao.selectByPage(null);
    }

    public List<UsersVo> queryByUsername(String username){
        return usersDao.selectByUserName(username);
    }
}
