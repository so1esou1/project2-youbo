package com.csu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.csu.common.lang.Result;
import com.csu.entity.User;
import com.csu.shiro.AccountProfile;


public interface UserService extends IService<User> {

    Result register(User user);

    AccountProfile login(String username, String password);
}
