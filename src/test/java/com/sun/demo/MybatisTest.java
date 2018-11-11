package com.sun.demo;

import com.sun.bean.ApplicationForm;
import com.sun.dao.ApplicationFormDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MybatisTest {

	@Autowired
	ApplicationFormDao applicationFormDao;
	
	@Test
	public void test() {
		ApplicationForm form = applicationFormDao.selectApplicationFormById(1L);
		
		System.out.println(form.toString());
	}
	
	@Test
	public void name() {
		System.out.println("......");
	}

	@Test
	public void addTest() {
	    ApplicationForm form = new ApplicationForm();
	    form.setName("王五");
	    form.setQq("12345678");
	    form.setType("Android工程师");
	    form.setAdmissionTime(new Date().getTime());
	    form.setGraduateSchoo("清华池");
	    form.setStudentIdOnWeb("123456");
	    form.setDailyLink("dailyLink");
	    form.setSlogan("口号");
	    form.setBrother("兄弟");
	    form.setMessageChannel("知乎");
	    form.setCreateAt(new Date().getTime());
	    form.setUpdateAt(new Date().getTime());
        long id = applicationFormDao.addForm(form);
        System.out.println(id);
        System.out.println(form.getId());
    }

    @Test
    public void deleteForm() {
        ApplicationForm form = new ApplicationForm();
        form.setId(2L);
        boolean flag = delete(form);
        if (flag) {
        	System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    private boolean delete(ApplicationForm form) {

        int count = applicationFormDao.deleteForm(form);
        if (count == 0) {
        	return false;
        } else {
            return true;
        }
    }

    @Test
    public void updateForm() {
	    ApplicationForm form = new ApplicationForm();
        boolean flag = update(form);
        if (flag) {
        	System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    private boolean update(ApplicationForm form){
        int count = applicationFormDao.updateForm(form);
        if (count == 0) {
        	return false;
        } else {
            return true;
        }
    }

    @Test
    public void selectApplicationFormByName() {
        ApplicationForm form = applicationFormDao.selectApplicationFormByName("苏正荣3");
        System.out.println(form.toString());
    }

    @Test
    public void selectApplicationFormByQQ() {
        ApplicationForm form = applicationFormDao.selectApplicationFormByQQ("22101263163");
        System.out.println(form.toString());
    }
}
