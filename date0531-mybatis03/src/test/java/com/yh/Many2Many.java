package com.yh;

import com.yh.mapper.many2many.StudentMapper;
import com.yh.mapper.many2many.SubjectMapper;
import com.yh.model.many2many.Student;
import com.yh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName:Many2Many
 * Package:com.yh
 * Time: 2024/6/2
 */
public class Many2Many {
    private static SqlSession sqlSession;

    @Before
    public void init() {
        sqlSession = MybatisUtil.getSqlSession();
    }

    @After
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void findStudentById() {
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student studentById = studentMapper.findStudentById(1);

        System.out.println(studentById);
    }

    @Test
    public void findSubjectById() {
        SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);

        System.out.println(subjectMapper.findSubjectById(1001));
    }
}
