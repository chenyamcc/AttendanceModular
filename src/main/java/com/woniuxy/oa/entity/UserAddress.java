package com.woniuxy.oa.entity;

import lombok.Data;

import java.io.Serializable;

/**
* @program: WoniuOA
*
* @description: ${description}
*
* @author: Carl
*
* @create: 2019-09-06 10:01
**/

@Data
public class UserAddress implements Serializable {
    /**
    * 用户住址id
    */
    private Integer uaid;

    /**
    * 家庭住址
    */
    private String address;

    /**
    * 移动电话
    */
    private Integer mobilePhone;

    /**
    * 固定电话
    */
    private String fixedPhone;

    /**
    * 联系人
    */
    private String emergency;

    private static final long serialVersionUID = 1L;
}