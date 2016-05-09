package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Business;
import cn.com.xn.util.PageBean;

public class BusinessDao {
	private BaseDao baseDao;
	public BusinessDao(){
		baseDao=new BaseDao();
	}
	
	public void  addBusiness(Business business){
		 baseDao.add(business);
	}
	
	public void deleteBusiness(int id){
		baseDao.delete(Business.class, id);
	}
	
	public void updateBusiness(Business business){
		baseDao.update(business);
	}
	
	public  List<Business> listBusiness(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
