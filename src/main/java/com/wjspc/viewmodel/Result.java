package com.wjspc.viewmodel;


import lombok.Data;

import java.util.List;

@Data
public class Result {

    // 0 -> success
    // 1 -> failure
    private int code;

    // if code is 0, the message will always be '成功',
    // otherwise the message will be error content
    private String message;

    private List<String> errorMessage;
}
