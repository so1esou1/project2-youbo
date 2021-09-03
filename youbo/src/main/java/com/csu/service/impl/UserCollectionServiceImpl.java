package com.csu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csu.entity.UserCollection;
import com.csu.mapper.UserCollectionMapper;
import com.csu.service.UserCollectionService;
import org.springframework.stereotype.Service;


@Service
public class UserCollectionServiceImpl extends ServiceImpl<UserCollectionMapper, UserCollection> implements UserCollectionService {

}
