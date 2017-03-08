package com.haihangyun.hcpaas.op.demo.service;

import com.haihangyun.hcpaas.op.demo.model.Users;
import com.haihangyun.hcpaas.op.demo.model.UsersVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by miracle on 2017/2/28.
 */
public interface IUsersService {

    public List<Users> findAllUsers();

    public List<Users> findByUsername(String username);

    public List<UsersVo> queryAllUsers();

    public List<UsersVo> queryByUsername(String username);

    public Page<Users> findPageUsers(UsersVo vo);

    public com.github.pagehelper.Page<UsersVo> queryPageUsers(UsersVo vo);
}
