package com.woniuxy.oa.exception;

import com.woniuxy.oa.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @program: WoniuOA
 * @description: 用户类的自定义异常
 * @author: Carl
 * @create: 2019-09-04 16:21
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserException extends RuntimeException{
   private ExceptionEnum exceptionEnum;
}
