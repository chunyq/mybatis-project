package com.yh.mapper.one2many;

import com.yh.model.one2many.Department;

/**
 * ClassName:DepartmentMapper
 * Package:com.yh.mapper.one2many
 * Time: 2024/6/2
 */
public interface DepartmentMapper {

    //根据id查询一个部门信息，与此同时查询出该部门所有的员工信息
    Department getDeptById(Integer id);
}
