package com.yh.model.one2many;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:Department
 * Package:com.yh.model.one2many
 * Time: 2024/6/2
 */

@Data
public class Department implements Serializable {
    //使用MyBatis二级缓存需要将对应的实体类序列化
    private Integer id;
    private String name;
    private String location;


    //员工集合
    List<Employee> employees;
}
