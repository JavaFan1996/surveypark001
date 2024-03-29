package com.atguigu.surveypark.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 抽象action,专门用于继承
 */
public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T>, Preparable {

	private static final long serialVersionUID = 9180917383072055589L;

	@Override
	public void prepare() throws Exception {
	}

	@Override
	public abstract T getModel() ;
}
