package com.yh.mapper.many2many;

import com.yh.model.many2many.Student;

/**
 * ClassName:StudentMapper
 * Package:com.yh.mapper.many2many
 * Time: 2024/6/2
 */
public interface StudentMapper {


    /**
     * 根据id查询学生信息
     * @param id
     * @return 学生信息
     */
    Student findStudentById(Integer id);
}
