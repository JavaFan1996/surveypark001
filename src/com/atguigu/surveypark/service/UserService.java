package com.atguigu.surveypark.service;

import com.atguigu.surveypark.model.User;

/**
 * UserService
 */
public interface UserService extends BaseService<User> {

	/**
	 *  �ж�email�Ƿ�ռ��
	 */
	public boolean isRegisted(String email);
}
