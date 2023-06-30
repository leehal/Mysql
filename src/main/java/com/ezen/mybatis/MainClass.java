package com.ezen.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session=null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println("sqlSessionFactory : "+sqlSessionFactory);

            session = sqlSessionFactory.openSession();
            System.out.println("session : "+session);
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            System.out.println("mapper : "+mapper);

//            TestVO vo = mapper.selectOne(1);
//            System.out.println(vo);

//            List<TestVO> list = mapper.selectAllList();
//
//            for(TestVO vo: list)
//                System.out.println(vo);

            TestVO vo = new TestVO();
            vo.setName("서연주");
            vo.setPhone("010-9999-9999");
            vo.setAddress("777번 버스");
            vo.setId(3);

//            mapper.insertTest(vo);
            mapper.insertTest(vo);
            session.commit();

            List<TestVO> list = mapper.selectAllList();

            for(TestVO vo2 :list)
                System.out.println(vo2);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
