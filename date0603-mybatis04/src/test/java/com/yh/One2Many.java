package com.yh;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.mapper.EmployeeMapper;
import com.yh.pojo.Employee;
import com.yh.pojo.EmployeeExample;
import com.yh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName:One2Many
 * Package:com.yh
 * Time: 2024/6/3
 */
public class One2Many {

    @Test
    public void findAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList = mapper.selectByExample(null);

        employeeList.forEach(System.out::println);

        sqlSession.close();
    }


    @Test
    public void findAllByExample() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        //构建条件
        EmployeeExample example = new EmployeeExample();
        example.setOrderByClause("id desc,NAME");
        example.setDistinct(true); //去重

        //构建条件标准
        EmployeeExample.Criteria criteria = example.createCriteria();
        //criteria.andIdEqualTo(101); //id=101
        //criteria.andIdIn(Arrays.asList(101,106)); //id in (101,102)
        criteria.andIdBetween(101,106); //id between 101 and 104

        //criteria.andNameLike("%三%"); //name like '%三%'

        List<Employee> employeeList = mapper.selectByExample(example); //条件查询
        employeeList.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void add() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setName("yousa");
        employee.setSalary(10000.0);
        employee.setDeptId(1);

        int i = mapper.insertSelective(employee);
        if (i > 0) {
            System.out.println("添加成功");
            System.out.println(employee);
        } else {
            System.out.println("添加失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        /**
         * 创建一个EmployeeExample实例，用于后续的员工条件查询。
         * EmployeeExample是查询条件的容器，它可以通过Criteria对象定义复杂的查询条件。
         */
        EmployeeExample employeeExample = new EmployeeExample();

        /**
         * 创建一个Criteria实例，用于定义查询条件。
         * Criteria提供了一种链式调用的方式来构建查询条件，使得代码更加清晰。
         */
        EmployeeExample.Criteria criteria = new EmployeeExample.Criteria();

        /**
         * 设置查询条件为员工ID等于101。
         * 这里的andIdEqualTo方法是Criteria链式调用的一部分，用于指定查询条件。
         * 其中的101是期望查询的员工ID值。
         */
        criteria.andIdEqualTo(101);

        /**
         * 将当前criteria对象作为或条件添加到employeeExample中。
         * 这里的or方法用于将当前的查询条件与其他条件进行逻辑或操作，扩大查询结果的范围。
         * 它使得查询不仅匹配当前criteria定义的条件，还匹配employeeExample中之前定义的所有条件。
         */
        employeeExample.or(criteria);


        Employee employee = new Employee();
        employee.setId(106);
        employee.setName("xiaoyuan");
        employee.setSalary(17000.0);
        employee.setDeptId(2);

        int i = mapper.updateByExampleSelective(employee, employeeExample);

        if (i > 0) {
            System.out.println("修改成功");
            System.out.println(employee);
        } else {
            System.out.println("修改失败");
        }

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void delete() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andIdEqualTo(107);
        int i = mapper.deleteByExample(employeeExample);

        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findByPage() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        //设置分页标准（后面的第一条查询语句才会实现分页）
        PageHelper.startPage(1, 2);
        List<Employee> employees = mapper.selectByExample(null);
        employees.forEach(System.out::println);

        //PageInfo 包含分页需要的所有数据
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);

        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页记录数：" + pageInfo.getPageSize());
        System.out.println("是否有前一页：" + pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页：" + pageInfo.isHasNextPage());
        System.out.println("前一页：" + pageInfo.getPrePage());
        System.out.println("后一页：" + pageInfo.getNextPage());
        sqlSession.close();

    }



}
