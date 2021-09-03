package com.csu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csu.entity.UserAction;
import com.csu.mapper.UserActionMapper;
import com.csu.service.UserActionService;
import org.springframework.stereotype.Service;


@Service
public class UserActionServiceImpl extends ServiceImpl<UserActionMapper, UserAction> implements UserActionService {

}
