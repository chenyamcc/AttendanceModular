package com.woniuxy.oa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @program: WoniuOA
 * @description: 异常处理的枚举
 * @author: Carl
 * @create: 2019-09-05 11:33
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum  ExceptionEnum {
    /**
     * 用户数据没有查询到
     */
    USER_NOT_FIND(HttpStatus.NOT_FOUND,"用户数据没有查询到","/system/userList"),
    UID_REQUIRE(HttpStatus.BAD_REQUEST,"必须需要用户id","redirect:/user/list"),
    USER_INFO_NOT_FIND(HttpStatus.NOT_FOUND,"用户详情没有查到","redirect:/user/list"),
    USER_ADDRESS_NOT_FIND(HttpStatus.NOT_FOUND,"用户的备忘录数据没有查到","/system/addressList")
    ;
    private HttpStatus code;
    private String message;
    private String resultPath;
}
