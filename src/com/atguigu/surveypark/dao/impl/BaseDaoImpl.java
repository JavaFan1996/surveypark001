package com.atguigu.surveypark.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.atguigu.surveypark.dao.BaseDao;

/**
 * �����daoʵ��,ר�����ڼ̳�
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	//ע��sessionFactory
	@Resource
	private SessionFactory sf ;
	
	private Class<T> clazz ;
	
	public BaseDaoImpl(){
		//�õ����ͻ�����
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	@Override
	public void saveEntity(T t) {
		sf.getCurrentSession().save(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		sf.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void updateEntity(T t) {
		sf.getCurrentSession().update(t);
	}

	@Override
	public void deleteEntity(T t) {
		sf.getCurrentSession().delete(t);
	}

	/**
	 * ����HQL��������������
	 */
	@Override
	public void batchEntityByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
	}

	@Override
	public T loadEntity(Integer id) {
		return (T) sf.getCurrentSession().load(clazz, id);
	}

	@Override
	public T getEntity(Integer id) {
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> findEntityByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}
}