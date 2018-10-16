package com.wjspc.service;

import com.wjspc.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by 79445 on 2018/5/30.
 */
public interface UserService {

    /**
     *
     * @param user
     * @return
     */
    String register(User user);

    /**
     * spring缓存测试
     * @param phone
     * @return
     */
    User getUser(String phone);

    /**
     *
     * @return
     */
    List<User> getUserList();
}
