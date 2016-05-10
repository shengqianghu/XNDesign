package cn.com.xn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.xn.util.HibernateSessionFactory;
import cn.com.xn.util.PageBean;


public class BaseDao<T> {
	public void add(Object obj) {
		Session session=null;
		Transaction tr=null;
		try {
			 session = HibernateSessionFactory.getSession();
			tr=session.beginTransaction();
			session.save(obj);
			tr.commit();			
		} catch (Exception e) {
			// TODO: handle exception
			if(tr!=null)
			{
				tr.rollback();
			}
		}finally{
			HibernateSessionFactory.closeSession();
		}
	
	}
	
	public void update(Object obj) {
		Session session = HibernateSessionFactory.getSession();
		session.update(obj);
		HibernateSessionFactory.closeSession();
	}
	
	public Object load(Class<?> clz, Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Object obj = session.get(clz, id);
		HibernateSessionFactory.closeSession();
		return obj;
	}
	
	public void delete(Class<?> clz, Integer id) {
		Session session = HibernateSessionFactory.getSession();
		session.delete(this.load(clz, id));
		HibernateSessionFactory.closeSession();
	}
	
	/**
	 * 查询 无条件
	 * @param hql
	 * @return
	 */
	public List<T> list(String hql) {
		return this.list(hql, null);
	}
	
	/**
	 * 查询 唯一条件
	 * @param hql
	 * @param obj
	 * @return
	 */
	public List<T> list(String hql, Object obj) {
		return this.list(hql, new Object[]{obj});
	}
	
	/**
	 * 查询 多条件
	 * @param hql
	 * @param objs
	 * @return
	 */
	public List<T> list(String hql, Object[] objs) {
		Session session = HibernateSessionFactory.getSession();
		
		Query query = session.createQuery(hql);		
		
		this.setParameter(query, objs);
		
		List<T> list = query.list();
		
		HibernateSessionFactory.closeSession();
		
		return list;
	}
	
	/**
	 * 分页查询 多条件
	 * @param hql
	 * @param objs
	 * @param pageBean 用到了当前页  和总页数 
	 * @return
	 */
	public PageBean page(String hql, Object[] objs, PageBean pageBean) {
		Session session = HibernateSessionFactory.getSession();
		
		Query query = session.createQuery(hql);		
		
		this.setParameter(query, objs);
		System.out.println(query.getQueryString());
		query.setFirstResult((pageBean.getCurrentPage() - 1) * pageBean.getPageSize());
		
		query.setMaxResults(pageBean.getPageSize());
		
		pageBean.setList(query.list());
		
		String countHql = getHQLCount(hql);
		Query query1=session.createQuery(countHql);
		this.setParameter(query1, objs);	
		Integer total = Integer.parseInt(String.valueOf(query1.uniqueResult()));
		pageBean.setTotal(total);
			
		HibernateSessionFactory.closeSession();
		
		return pageBean;
	}
	
	
	private String getHQLCount(String hql) {
		String s = hql.substring(0, hql.indexOf("from"));
		
		if(s.equals("")) {
			hql = "select count(*) " + hql;
		} else {
			hql = hql.replace(s, "select count(*) ");
		}
		
		return hql;
	}
	
	private void setParameter(Query query, Object[] objs) {
		if(objs != null && objs.length > 0) {
			for(int i = 0; i < objs.length; i ++) {
				query.setParameter(i, objs[i]);
			}
		}
	}
}
