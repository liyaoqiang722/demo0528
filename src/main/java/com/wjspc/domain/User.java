package com.wjspc.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by 79445 on 2018/6/4.
 */
@Data
public class User {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String phoneNumber;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String status;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private String updateBy;

    /**
     *
     */
    private Date updateTime;

}
