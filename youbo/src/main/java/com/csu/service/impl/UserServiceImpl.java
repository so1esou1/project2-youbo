package com.csu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csu.common.lang.Result;
import com.csu.entity.User;
import com.csu.mapper.UserMapper;
import com.csu.service.UserService;
import com.csu.shiro.AccountProfile;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //实现注册：
    @Override
    public Result register(User user) {
        int count = this.count(new QueryWrapper<User>()
                .eq("email", user.getEmail())
                .or()
                .eq("username", user.getUsername())
        );

        if(count > 0) {
            return Result.fail("用户名或邮箱已被占用");
        }

        User temp = new User();
        temp.setUsername(user.getUsername());
        temp.setPassword(SecureUtil.md5(user.getPassword()));   //hutool里的md5加密工具
        temp.setEmail(user.getEmail());
        temp.setAvatar("/res/images/avatar/default.png");   //默认图像

        temp.setCreated(new Date());
        temp.setPoint(0);
        temp.setVipLevel(0);
        temp.setCommentCount(0);
        temp.setPostCount(0);
        temp.setGender("0");
        this.save(temp);

        return Result.success();
    }


    //实现登录的方法:
    @Override
    public AccountProfile login(String email, String password) {

        //获取这个用户：
        User user = this.getOne(new QueryWrapper<User>().eq("email", email));
        if(user == null) {
            throw new UnknownAccountException();    //用户不存在
        }
        if(!user.getPassword().equals(password)){
            throw new IncorrectCredentialsException();  //密码错误
        }

        user.setLasted(new Date());
        this.updateById(user);

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        return profile;
    }
}
