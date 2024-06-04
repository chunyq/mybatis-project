package com.yh.mapper.one2many;

import com.yh.model.one2many.Employee;

/**
 * ClassName:EmployeeMapper
 * Package:com.yh.mapper.one2many
 * Time: 2024/6/2
 */
public interface EmployeeMapper {

    /**
     * 根据id查询员工
     * @param id 员工id
     * @return 员工信息
     */
    Employee findById(Integer id);
}
