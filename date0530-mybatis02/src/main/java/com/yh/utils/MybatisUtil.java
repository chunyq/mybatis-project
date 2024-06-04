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

    //静态代码块只执行一次
    static {
        try {
            //加载主配置文件
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    //释放资源
    public static void close(SqlSession sqlSession){
        //提交当前对话所有的修改
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
}
