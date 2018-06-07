package com.wjspc.viewmodel;

import lombok.Data;

@Data
public class ResponseViewModel<T> {

    private Result result ;

    private T data;

    public ResponseViewModel(){
        result = new Result();
        result.setCode(0);
        result.setMessage("成功！");
    }

    public ResponseViewModel(T data){
        result = new Result();
        result.setCode(0);
        result.setMessage("成功！");
        setData(data);
    }

}
