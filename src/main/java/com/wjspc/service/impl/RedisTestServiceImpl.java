package com.wjspc.service.impl;

import com.wjspc.domain.User;
import com.wjspc.service.RedisTestService;
import com.wjspc.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 79445 on 2018/8/30.
 */
@Log4j2
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
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *
     */
    @Override
    public User test01() {

        //User一定到实现序列化，才可以set
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        User user = (User) redisTemplate.opsForValue().get("user");

        int i = 1;
        log.info("redis=======：：：" + i);

        //双重检测锁，预防缓存穿透
        if (user == null ){
            synchronized (this){
                user = (User) redisTemplate.opsForValue().get("user");
                int j = 1;
                log.info("redisMMMMMMMMMM：：：" + j);
                if (user == null ){
                    user = userService.getUser("17637925856");
                    int z = 1;
                    log.info("数据库【【【【【【：：：" + z);
                    redisTemplate.opsForValue().set("user",user);
                }
            }
        }

        return user;

    }
}
