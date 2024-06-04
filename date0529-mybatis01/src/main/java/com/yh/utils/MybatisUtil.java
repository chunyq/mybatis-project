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
 * Time: 2024/5/30
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 静态代码块，用于初始化MyBatis的SqlSessionFactory。
     * 此块代码在类加载时执行，用于加载MyBatis的配置文件并构建SqlSessionFactory。
     *
     * 本代码块只运行一次
     */
    static {
        try {
            // 加载主配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 根据配置文件构建SqlSessionFactory工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            // 处理加载配置文件时可能发生的IO异常
            e.printStackTrace();
        }
    }

    /**
     * 获取一个SqlSession实例。
     * <p>此方法不接受任何参数，它会打开一个新的SqlSession。</p>
     *
     * @return SqlSession 返回一个SqlSession实例，该实例可用于执行SQL命令。
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(); // 打开一个新的SqlSession实例并返回
    }


    /**
     * 关闭SqlSession会话。
     * 该方法首先提交当前会话中的所有更改，然后关闭会话。
     *
     * @param sqlSession 待关闭的SqlSession对象。
     */
    public static void close(SqlSession sqlSession){
        // 提交当前会话中的所有更改
        sqlSession.commit();
        // 关闭SqlSession会话
        sqlSession.close();
    }

}
