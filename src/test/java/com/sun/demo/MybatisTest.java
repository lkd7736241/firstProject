package com.sun.demo;

import com.sun.bean.ApplicationForm;
import com.sun.dao.ApplicationFormDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MybatisTest {

	@Autowired
	ApplicationFormDao applicationFormDao;
	
	@Test
	public void test() {
		ApplicationForm form = applicationFormDao.selectApplicationFormById(1);
		
		System.out.println(form.toString());
	}
	
	@Test
	public void name() {
		System.out.println("......");
	}
}
