package com.yh;

import com.yh.mapper.one2one.PassengerMapper;
import com.yh.model.one2one.Passenger;
import com.yh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName:One2One
 * Package:com.yh
 * Time: 2024/5/31
 */
public class One2One {
    private static SqlSession sqlSession;
    private static PassengerMapper mapper;

    @Before
    public void init() {
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(PassengerMapper.class);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }

    //根据旅客id查询旅客信息和其护照信息
    @Test
    public void findPassengerById() {
        Passenger byId =mapper.findById(1);
        System.out.println(byId);
    }

}
