package com.wjspc.dao;

import com.wjspc.domain.User;
import org.apache.ibatis.annotations.Mapper;

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
}
