package com.qianxia.tourism.service.impl;

import com.qianxia.tourism.common.LoginException;
import com.qianxia.tourism.domain.User;
import com.qianxia.tourism.mapper.UserMapper;
import com.qianxia.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByTerms(String username, String password) {

        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);


        List<User> list = userMapper.queryUserByTerms(map);
        if ("[]".equals(list.toString())){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    public int insert(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User queryUserByUsername(String username) {

        List<User> list = userMapper.queryUserByUsername(username);
        if ("[]".equals(list.toString())){
            return null;
        }else {
            return list.get(0);
        }
    }
}
