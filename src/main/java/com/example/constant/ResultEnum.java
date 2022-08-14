package com.example.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: monitor server
 * @description: 结果返回默认值
 * @author: Jiao
 * @create: 2022-08-08 10：39
 */
@Getter
@AllArgsConstructor
public enum ResultEnum implements StatusCode {

    /**
     * 登陆成功
     */
    SUCCESS(200,"请求成功"),

    REQUEST_FALSE(400,"请求失败"),
    PARAMETER_NOT_VALID(400,"参数不合法"),


    ;
    /**
     * 编号
     */
    private int code;
    /**
     * 信息
     */
    private String msg;
}
