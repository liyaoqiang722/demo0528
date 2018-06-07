package com.wjspc.controller;

import com.wjspc.domain.Province;
import com.wjspc.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by liyaoqiang on 2018/5/28.
 */
@Controller
public class CityController {

    @Resource
    private CityService cityService;

    @RequestMapping(value = "/cityTest01",
                    method = RequestMethod.GET)
    @ResponseBody
    public Province cityTest01(){
        return cityService.test();
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
