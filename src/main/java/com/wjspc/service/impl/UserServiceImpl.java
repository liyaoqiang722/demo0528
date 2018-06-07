package com.wjspc.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;
import com.wjspc.constant.UserStatus;
import com.wjspc.dao.UserMapper;
import com.wjspc.domain.User;
import com.wjspc.service.UserService;
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

}
