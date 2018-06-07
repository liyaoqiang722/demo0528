package com.wjspc.dao;

import com.wjspc.domain.Province;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by 79445 on 2018/5/29.
 */
@Mapper
public interface CityMapper {

    public Province test();
}
