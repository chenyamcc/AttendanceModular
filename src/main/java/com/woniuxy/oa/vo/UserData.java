package com.woniuxy.oa.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: WoniuOA
 * @description: 向前端返回的用户管理数据
 * @author: Carl
 * @create: 2019-09-04 15:45
 **/
@Data
public class UserData {
    private Integer uid;
    private String uname;
    private Integer age;
    private Integer sex;
    private Long telephone;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireTime;
    private Integer flag;
}
