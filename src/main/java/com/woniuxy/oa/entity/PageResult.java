package com.woniuxy.oa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: WoniuOA
 * @description: 分页数据
 * @author: Carl
 * @create: 2019-09-04 15:40
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private Integer pageIndex;
    private Integer rows;
    private Long dataCount;
    private Integer pageCount;
    private List<T> list;
}
