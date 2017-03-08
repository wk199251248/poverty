package com.myproject.poverty.console.service.impl;

import com.github.pagehelper.PageHelper;
import com.myproject.poverty.console.dao.UsersDao;
import com.myproject.poverty.console.model.Users;
import com.myproject.poverty.console.model.UsersVo;
import com.myproject.poverty.console.repository.UsersRepository;
import com.myproject.poverty.console.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
