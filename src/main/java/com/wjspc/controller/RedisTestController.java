package com.wjspc.controller;

import com.wjspc.domain.User;
import com.wjspc.service.RedisTestService;
import com.wjspc.viewmodel.ResponseViewModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 79445 on 2018/8/30.
 */
@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    /**
     *
     */
    @Resource
    private RedisTestService redisTestService;

    /**
     * redis测试
     * @return
     */
    @RequestMapping(value = "/01",
            method = RequestMethod.GET)
    public Object test01(){

        User user = redisTestService.test01();

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setData(user);

        return responseViewModel;
    }

    /**
     * redis穿透测试
     * @return
     */
    @RequestMapping(value = "/0101",
            method = RequestMethod.GET)
    public Object test0101(){

        /*
            ExecutorService executorService =
                    Executors //java.util下的工具类，用于并发编程
                    .newFixedThreadPool(5);//new了一个线程池

            executorService.submit(new Runnable() {//new Runnable()实现线程的一种方式
                @Override
                public void run() {
                    test01();
                }
            });
        或者*/


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                test01();
            }
        };

        ExecutorService executorService =
                Executors //java.util下的工具类，用于并发编程
                        .newFixedThreadPool(30);//new了一个线程池
        for (int i = 0;i<10000;i++){
            executorService.submit(runnable);
        }
        return executorService;
    }

}
