package com.wjspc.controller;

import com.wjspc.domain.User;
import com.wjspc.service.UserService;
import com.wjspc.viewmodel.ResponseViewModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by 79445 on 2018/8/30.
 */
@Slf4j
@RestController
public class TestController {

    /**
     *
     */
    @Resource
    private UserService userService;

    /**
     * 时间大小测试
     * @return
     */
    @RequestMapping(value = "/test01",
            method = RequestMethod.GET)
    public Object test01(){

        User user = userService.getUser("17637925856");

        boolean test = false;
        if (user.getCreateTime().getTime() < new Date().getTime()){
            test = true;
        };

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setData(test);

        return responseViewModel;
    }

    /**
     * 时间大小测试
     * @return
     */
    @RequestMapping(value = "/test02/{phone}",
            method = RequestMethod.GET)
    public Object test02(@PathVariable String phone){

        User user = userService.getUser(phone);

        Long time = new Date().getTime() - user.getCreateTime().getTime();

        Long result = ( user.getCreateTime().getTime() / (60 * 1000)) - (new Date().getTime() / (60 * 1000));
        int hour = result.intValue() / 60;
        int leftMinute = result.intValue() % 60;
        StringBuffer buffer = new StringBuffer();
        buffer.append(hour == 0 ? "" : hour + "小时")
                .append(leftMinute == 0 ? "" : leftMinute + "分钟");

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setData(buffer.toString());

        return responseViewModel;
    }

}
