package com.atguigu.surveypark.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atguigu.surveypark.dao.BaseDao;
import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.UserService;
import com.atguigu.surveypark.util.ValidateUtil;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	/**
	 * 重写该方法,目的是为了覆盖超类中该方法的注解,指明注入指定的Dao对象,否则spring
	 * 无法确定注入哪个Dao---有四个满足条件的Dao.
	 */
	@Override
	@Resource(name="userDao")
	public void setDao(BaseDao<User> dao) {
		super.setDao(dao);
	}
	
	/**
	 *  判断email是否占用
	 */
	@Override
	public boolean isRegisted(String email){
		String hql = "from User u where u.email = ?" ;
		List<User> list = this.findEntityByHQL(hql, email);
		return ValidateUtil.isValid(list) ;
	}
}
