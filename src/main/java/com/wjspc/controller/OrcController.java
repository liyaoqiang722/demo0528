package com.wjspc.controller;

import com.wjspc.service.OrcService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 79445 on 2018/6/7.
 */
@RestController
public class OrcController {

    @Resource
    private OrcService orcService;

    @RequestMapping(value = "/orc",
            method = RequestMethod.GET)
    public Object orc(){
        return orcService.orc();
    }
}
