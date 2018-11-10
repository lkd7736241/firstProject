package com.sun.dao;

import com.sun.bean.ApplicationForm;

public interface ApplicationFormDao {

	/**
	 * 根据id查找到报名表（application_form）
	 * @param id
	 * @return
	 */
	ApplicationForm selectApplicationFormById(int id);
}
