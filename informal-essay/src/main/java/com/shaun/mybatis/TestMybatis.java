package com.shaun.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class TestMybatis {

    public static void main(String[] args) throws Exception{

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = build.openSession();
        // 测试，暂时没有mapper文件
        TestMybatis mapper = sqlSession.getMapper(TestMybatis.class);
    }
}
