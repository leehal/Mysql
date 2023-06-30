package com.ezen.prj;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        TestDAO tDao= TestDAO.getInstance();
        List<TestVO> list = tDao.selectAllTest();

        for(TestVO vo : list)
            System.out.println(vo);
    }

}
