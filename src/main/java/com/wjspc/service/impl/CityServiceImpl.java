
package com.wjspc.service.impl;


import com.wjspc.dao.CityMapper;
import com.wjspc.domain.Province;
import com.wjspc.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 79445 on 2018/5/29.
 */

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public Province test() {
        return cityMapper.test();
    }
}

