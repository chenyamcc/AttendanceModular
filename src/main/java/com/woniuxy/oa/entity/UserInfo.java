package com.woniuxy.oa.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: WoniuOA
 * @description: ${description}
 * @author: Carl
 * @create: 2019-09-05 10:09
 **/

@Data
public class UserInfo implements Serializable {
    /**
     * 用户详情id
     */
    private Integer uiid;

    /**
     * 1为男，0为女
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电话号码
     */
    private Long telephone;

    /**
     * 生日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    /**
     * 入职时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date hireTime;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private String cardId;

    /**
     * 头像地址
     */
    private String headImg;

    private static final long serialVersionUID = 1L;
}