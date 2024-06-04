package com.yh.mapper;

import com.yh.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:CustomerMapper.xml
 * Package:com.yh.mapper
 * Time: 2024/5/29
 */
public interface CustomerMapper {
    /**
     * 查询所有客户
     * @return 客户集合
     */
    List<Customer> findAll();

    //用来测试resultMap
    List<Customer> findAllCustomers();

    /**
     * 根据id查询客户
     * @param id 客户id
     * @return 客户
     */
    Customer findById(Integer id);

    /**
     * 根据id删除客户
     * @param id 客户id
     * @return 删除的记录数
     */

    //@Parm("id") 是告诉mybatis，id的值是方法参数中的id
    int deleteById(@Param("id") Integer id);

    /**
     * 添加客户
     * @param customer 客户
     * @return 添加的记录数
     */
    int addCustomer(Customer customer);

    /**
     * 修改客户
     * @param customer 客户
     * @return 修改的记录数
     */
    int updateCustomer(Customer customer);

    /**
     * 根据名称模糊查询客户
     * @param name 客户名称
     * @return 客户集合
     */
    List<Customer> findByNameLike(String name);

    /**
     * 分页查询客户
     * @param start 起始位置
     * @param rows 每页显示的记录数
     * @return 客户集合
     */
    List<Customer> findAllLimit(@Param("start") Integer start, @Param("rows") Integer rows);

    /**
     * 查询总记录数
     * @return 总记录数
     */
    Integer findTotal();

    /**
     * 根据id和名称查询客户
     * @param customer 客户
     * @return 客户集合
     */
    List<Customer> findByIdAndNameIf(Customer customer);
}
