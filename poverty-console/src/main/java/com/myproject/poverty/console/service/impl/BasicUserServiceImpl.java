package com.myproject.poverty.console.service.impl;

import com.github.pagehelper.PageHelper;
import com.myproject.poverty.console.dao.UsersDao;
import com.myproject.poverty.console.model.BasicUser;
import com.myproject.poverty.console.model.Users;
import com.myproject.poverty.console.model.UsersVo;
import com.myproject.poverty.console.repository.BasicUserRepository;
import com.myproject.poverty.console.repository.UsersRepository;
import com.myproject.poverty.console.service.IBasicUserService;
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
public class BasicUserServiceImpl implements IBasicUserService {

    @Autowired
    private BasicUserRepository basicUserRepository;

    public List<BasicUser> findByUserAccount(String userAccount){
        return basicUserRepository.findByUserAccount(userAccount);
    }

}
