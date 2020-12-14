package com.qianxia.tourism.service;

import com.qianxia.tourism.domain.User;

public interface UserService {
    User queryUserByTerms(String username, String password);

    int insert(User user);

    User queryUserByUsername(String username);
}
