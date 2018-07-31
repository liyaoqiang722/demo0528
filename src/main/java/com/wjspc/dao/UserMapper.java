package com.wjspc.dao;

import com.wjspc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by 79445 on 2018/5/30.
 */
@Mapper
public interface UserMapper {

    /**
     *
     * @param user
     * @return
     */
    void register(User user);

    /**
     *
     * @param phoneNumber
     * @return
     */
    /*@Cacheable(cacheNames = "users")    //下次请求此方法时直接从缓存中获取
    User getUser(@Param("phoneNumber") String phoneNumber);*/

    @Cacheable(value = "user", key = "#root.targetClass + #username", unless = "#result eq null")
    User getUser(@Param("phoneNumber") String phoneNumber);
}
