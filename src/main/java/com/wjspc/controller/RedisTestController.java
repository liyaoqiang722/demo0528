package com.wjspc.controller;

import com.wjspc.service.RedisTestService;
import com.wjspc.viewmodel.ResponseViewModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
     * 时间大小测试
     * @return
     */
    @RequestMapping(value = "/01",
            method = RequestMethod.GET)
    public Object test01(){

        redisTestService.test01();

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setData(null);

        return responseViewModel;
    }

}
