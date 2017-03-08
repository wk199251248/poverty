package com.myproject.poverty.console.web.controller;

import com.myproject.poverty.core.base.controller.BaseController;
import com.myproject.poverty.console.model.Users;
import com.myproject.poverty.console.model.UsersVo;
import com.myproject.poverty.console.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by miracle on 2017/2/28.
 */
@Controller
public class UsersController extends BaseController {

    @Autowired
    private IUsersService usersService;

    @RequestMapping("/findAllUsers")
    @ResponseBody
    public List<Users> findAllUsers(){
        return usersService.findAllUsers();
    }

    @RequestMapping("/findPageUsers")
    @ResponseBody
    public Page<Users> findPageUsers(UsersVo vo){
        vo.setPageIndex(2);
        return usersService.findPageUsers(vo);
    }

    @RequestMapping("/findByUsername")
    @ResponseBody
    public List<Users> findByUsername(String username){
        return usersService.findByUsername(username);
    }

    @RequestMapping("/queryAllUsers")
    @ResponseBody
    public List<UsersVo> queryAllUsers(){
        return usersService.queryAllUsers();
    }

    @RequestMapping("/queryByUsername")
    @ResponseBody
    public List<UsersVo> queryByUsername(String username){
        return usersService.queryByUsername(username);
    }

    @RequestMapping("/queryPageUsers")
    @ResponseBody
    public com.github.pagehelper.Page<UsersVo> queryPageUsers(UsersVo vo){
        vo.setPageIndex(2);
        return usersService.queryPageUsers(vo);
    }
}
