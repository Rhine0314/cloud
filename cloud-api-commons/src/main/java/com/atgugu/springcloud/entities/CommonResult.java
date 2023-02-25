package com.atgugu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T>{
    private int code;

    private String message;

    private T data;

    public CommonResult(int code, String message){
        this(code, message, null);
    }
}
