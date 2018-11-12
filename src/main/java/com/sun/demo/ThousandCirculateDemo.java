package com.sun.demo;

import com.sun.bean.ApplicationForm;
import com.sun.dao.ApplicationFormDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by qiulisun on 2018/11/12.<br>
 */
public class ThousandCirculateDemo {

    public static void main(String[] args){

        for (int i = 0; i < 1000; i++){
            AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
            ApplicationFormDao applicationFormDao = context.getBean(ApplicationFormDao.class);
            ApplicationForm form = applicationFormDao.selectApplicationFormById(10L);
            System.out.println(form.toString() + "_" + i);
        }
//        context.close();
    }
}
