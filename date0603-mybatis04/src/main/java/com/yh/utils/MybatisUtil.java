package com.yh.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName:MybatisUtil
 * Package:com.yh.utils
 * Time: 2024/5/31
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void close(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }
}
