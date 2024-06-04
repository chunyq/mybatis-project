package com.yh;

import com.yh.mapper.StudentMapper;
import com.yh.model.Student;
import com.yh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName:MybatisTest
 * Package:com.yh
 * Time: 2024/5/31
 */
public class MybatisTest {
    private static SqlSession sqlSession;

    private static StudentMapper mapper;
    @Before
    public void init() {
        sqlSession = MybatisUtil.getSqlSession();
        //通过sqlSession获取mapper，动态代理对象
        mapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void destroy() {
        MybatisUtil.close(sqlSession);
    }

    @Test
    public void testfindAll() {
        //调用mapper的方法
        mapper.findAll().forEach(System.out::println);
    }

    //动态select
    @Test
    public void testfindByStudents() {
        //调用mapper
        Student student = new Student();
        //student.setId(202304550101L);
        //student.setName("张三");
        student.setAge(19);
        student.setSex("男");

        mapper.findByStudents(student).forEach(System.out::println);
    }

    //动态update
    @Test
    public void testupdateStudents() {
        Student student = new Student();
        student.setId(202304550116L);
        student.setName("樟树听");
        student.setMajor("网络安全");
        //student.setAge(23);
        //student.setSex("女");

        mapper.updateStudents(student);



    }

    //动态delete
    @Test
    public void testdeleteStudents() {
        int i = mapper.deleteStudents(Arrays.asList(202304550144L,202304550145L));
        System.out.println("删除了"+i+"位同学");
    }

    //动态add
    @Test
    public void testaddStudent() {
        Student student = new Student();
        student.setId(null);
        student.setName("王爷");
        //student.setAge(20);
        //student.setSex("男");
        student.setMajor("计算机科学与技术");
        student.setCollege("华中科技大学");

        int i = mapper.addStudent(student);
        System.out.println("添加了" + i + "条数据");
        System.out.println(student);
    }

}
