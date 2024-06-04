package com.yh.mapper;

import com.yh.model.Student;

import java.util.List;

/**
 * ClassName:StudentMapper
 * Package:com.yh.mapper
 * Time: 2024/5/31
 */
public interface StudentMapper {

    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> findAll();

    List<Student> findByStudents(Student student);

    /**
     * 添加学生信息
     * @param student 前端提交的数据
     */
    void updateStudents(Student student);

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    int deleteStudents(List<Long> id);

    int addStudent(Student student);
}
