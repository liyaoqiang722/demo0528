package com.wjspc.controller;

import com.wjspc.domain.Province;
import com.wjspc.domain.User;
import com.wjspc.service.UserService;
import com.wjspc.viewmodel.ResponseViewModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 79445 on 2018/5/30.
 */
@Slf4j
@RestController
public class LoginController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/register",
            method = RequestMethod.POST)
    public Object register(@RequestBody User user){
        String register = userService.register(user);

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setData(user);

        return responseViewModel;
    }

    /**
     * spring缓存测试
     * @param phone
     * @return
     */
    @RequestMapping(value = "/getUser/{phone}",
            method = RequestMethod.GET)
    public Object getUser(@PathVariable String phone){
        User user = userService.getUser(phone);

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setData(user);

        return responseViewModel;
    }
}
