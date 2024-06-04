package com.yh;

import com.yh.mapper.one2many.DepartmentMapper;
import com.yh.mapper.one2many.EmployeeMapper;
import com.yh.mapper.one2one.PassengerMapper;
import com.yh.model.one2many.Department;
import com.yh.model.one2many.Employee;
import com.yh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName:One2Many
 * Package:com.yh
 * Time: 2024/6/2
 */
public class One2Many {
    //private static SqlSession sqlSession;

    /*@Before
    public void init() {
        sqlSession = MybatisUtil.getSqlSession();
    }
*/
    /*@After
    public void destroy() {
        sqlSession.close();
    }*/


    //测试一级缓存(在同一个sqlSession中),一级缓存MyBatis默认开启
    @Test
    public void findDepartmentById1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department deptById1 = departmentMapper.getDeptById(1);

        Department deptById2 = departmentMapper.getDeptById(1);

        System.out.println(deptById1);

        System.out.println(deptById2);

        MybatisUtil.close(sqlSession);
    }

    //测试MyBatis二级缓存(SqlSession对象关闭或提交之后，⼀级缓存中的数据才会被写⼊到⼆级缓存当中。此时⼆级缓存才可⽤)
    @Test
    public void findDepartmentById2() {
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();

        DepartmentMapper departmentMapper1 = sqlSession1.getMapper(DepartmentMapper.class);
        DepartmentMapper departmentMapper2 = sqlSession2.getMapper(DepartmentMapper.class);

        Department deptById1 = departmentMapper1.getDeptById(1);
        System.out.println(deptById1);
        MybatisUtil.close(sqlSession1);

        Department deptById2 = departmentMapper2.getDeptById(1);
        System.out.println(deptById2);

        MybatisUtil.close(sqlSession2);

    }
}
