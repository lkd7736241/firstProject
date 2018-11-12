package com.sun.demo;

import com.sun.bean.ApplicationForm;
import com.sun.dao.ApplicationFormDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试数据连接失败捕捉异常
 * create by qiulisun on 2018/11/12.<br>
 */
public class ExceptionDealDemo {

    public static void main(String[] args){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        ApplicationFormDao applicationFormDao = context.getBean(ApplicationFormDao.class);
        try {
            ApplicationForm form = applicationFormDao.selectApplicationFormById(10L);
            System.out.println(form.toString());
        } catch (Exception e){
            System.out.println("DB操作失败");
        } finally {
            context.close();
        }
    }
}
