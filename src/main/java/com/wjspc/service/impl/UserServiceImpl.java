package com.wjspc.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;
import com.wjspc.constant.UserStatus;
import com.wjspc.dao.UserMapper;
import com.wjspc.domain.User;
import com.wjspc.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by 79445 on 2018/5/30.
 */
@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public String register(User user) {

        user.setId(UUID.randomUUID().toString());
        user.setUserName(user.getPhoneNumber());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setStatus(UserStatus.NOMAL.getValue());
        user.setCreateTime(new Date());

        userMapper.register(user);

        return null;
    }

    /**
     * spring缓存测试
     * @param phone
     * @return
     */
    @Override
    public User getUser(String phone) {

        User user1 = userMapper.getUser(phone);
        log.info("第一次查询user信息：" + user1.toString());

        User user2 = userMapper.getUser(phone);
        user2 = userMapper.getUser(phone);
        log.info("第二次查询user信息：" + user2.toString());

        return user2;
    }

}
