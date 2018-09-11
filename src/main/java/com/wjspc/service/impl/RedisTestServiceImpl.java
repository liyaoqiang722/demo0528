package com.wjspc.service.impl;

import com.wjspc.domain.User;
import com.wjspc.service.RedisTestService;
import com.wjspc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 79445 on 2018/8/30.
 */
@Service
public class RedisTestServiceImpl implements RedisTestService {

    /**
     * SpringBoot已经默认配置StringRedisTemplate,可以直接注入
     *
     * StringRedisTemplate只针对键值都是字符型的数据进行操作
     */
    /*@Autowired
    StringRedisTemplate stringRedisTemplate;*/

    /**
     * 指定stringRedisTemplate
     */
    /*@Resource(name="stringRedisTemplate")
    private ValueOperations<String,String> valOpsStr;*/

    /**
     * SpringBoot已经默认配置RedisTemplate,可以直接注入
     */
    /*@Autowired
    RedisTemplate redisTemplate;*/

    /**
     *
     */
    /*@Resource(name="redisTemplate")
    private ValueOperations<Object,Object> valOps;*/

    /**
     *
     */
    @Resource
    private UserService userService;

    /**
     *
     */
    @Override
    public void test01() {

        User user = userService.getUser("17637925856");

        //valOps.set("name",user.getUserName());

    }
}
