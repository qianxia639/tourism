package com.qianxia.tourism.mapper;

import com.qianxia.tourism.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> queryUserByTerms(Map<String, String> map);

    List<User> queryUserByUsername(String username);
}