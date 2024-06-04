package com.yh;

import com.mysql.cj.protocol.Security;
import com.yh.mapper.CustomerMapper;
import com.yh.model.Customer;
import com.yh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * ClassName:CustomerTest
 * Package:com.yh
 * Time: 2024/5/29
 */
public class CustomerTest {
    private static SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        //    1.加载主配置
        //    2.构建SqlSessionFactory工厂
        //    3.开启会话
        //以上三个步骤封装在了一个工具类中
        sqlSession = MybatisUtil.getSqlSession();
    }

    @After
    public void close() {
        //释放资源
        MybatisUtil.close(sqlSession);
    }

    @Test
    public void testFindAll() throws IOException {
        //两种方法查询
        // 获取接口的代理对象(看成实现类)
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        // 调用接口
        List<Customer> all = mapper.findAll();
        all.forEach(System.out::println);

        //传统方法（不建议）：使用sqlSession的方法selectList
        /*List<Object> objects = sqlSession.selectList("com.yh.mapper.CustomerMapper.findAll");
        objects.forEach(System.out::println);*/
    }

    @Test
    public void testFindById() throws IOException {
        //    获取接口的代理对象(看成实现类)
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //    调用接口
        Customer customer = mapper.findById(1);
        System.out.println(customer);
    }
    @Test
    public void deleteById() throws IOException {
        //    获取接口的代理对象(看成实现类)
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //    调用接口
        int i = mapper.deleteById(7);
        System.out.println("删除了" + i + "条记录");
    }

    @Test
    public void addCustomer() throws IOException {
        //    获取接口的代理对象(看成实现类)
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        System.out.println("========以上是准备工作====交给spring=======");
        //    调用接口
        Customer customer = new Customer();
        System.out.println(customer);

        customer.setId(null);
        customer.setName("李四");
        customer.setGender("男");
        customer.setAge(18);
        customer.setAddress("武汉");
        customer.setQq("123456789");
        customer.setEmail("123@qq.com");
        customer.setStatus(0);

        int i = mapper.addCustomer(customer);
        System.out.println("添加了" + i + "条记录");
        System.out.println(customer);
    }


    @Test
    public void updateCustomer() throws IOException {
        //  获取接口的代理对象(看成实现类)
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        int i = mapper.updateCustomer(new Customer(11, "李四", "女", 18, "武汉", "123456789", "123@qq.com", 0));
        System.out.println("修改了" + i + "条记录");
    }

    //模糊查询
    @Test
    public void findByLike() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> nameLike = mapper.findByNameLike("马");
        nameLike.forEach(System.out::println);
    }


    //测试resultMap
    @Test
    public void findAllCustomer() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allCustomers = mapper.findAllCustomers();

        allCustomers.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void findAllLimit() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allLimit = mapper.findAllLimit(5, 5);
        allLimit.forEach(System.out::println);
    }

    //查询总记录数
    @Test
    public void findAllCount() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Integer total = mapper.findTotal();
        System.out.println("总记录数："+total);
    }


    //动态SQL if标签
    @Test
    public void findByIdAndNameIf() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();

        //customer.setId(7);
        //customer.setName("刘大头");

        List<Customer> byIdAndNameIf = mapper.findByIdAndNameIf(customer);

        byIdAndNameIf.forEach(System.out::println);
    }


}
