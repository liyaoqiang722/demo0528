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
    User getUser(@Param("phoneNumber") String phoneNumber);
}
