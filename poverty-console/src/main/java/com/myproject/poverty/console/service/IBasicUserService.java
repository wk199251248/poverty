package com.myproject.poverty.console.service;

import com.myproject.poverty.console.model.BasicUser;
import com.myproject.poverty.console.model.Users;
import com.myproject.poverty.console.model.UsersVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by miracle on 2017/2/28.
 */
public interface IBasicUserService {

    public List<BasicUser> findByUserAccount(String userAccount);
}
