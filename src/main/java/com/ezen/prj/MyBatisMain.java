package com.ezen.prj;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisMain {
    public static void main(String[] args) {

        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
