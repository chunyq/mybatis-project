package com.yh.model.one2many;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:Employee
 * Package:com.yh.model.one2many
 * Time: 2024/6/2
 */

@Data
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private Double salary;

    //员工从属部门信息
    private Department department;
}
