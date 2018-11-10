package com.sun.demo;

import com.sun.bean.ApplicationForm;
import com.sun.dao.ApplicationFormDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationFormDemo {

    public static void main(String[] args) throws Exception{
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        ApplicationFormDao applicationFormDao = context.getBean(ApplicationFormDao.class);
        ApplicationForm form = applicationFormDao.selectApplicationFormById(1);
        System.out.println(form.toString());
        context.close();
    }
}
