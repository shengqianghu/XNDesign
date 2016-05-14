package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Customer;
import cn.com.xn.util.PageBean;

public class CustomerDao {
	private BaseDao baseDao;
	public CustomerDao(){
		baseDao=new BaseDao();
	}
	
	public void  addCustomer(Customer customer){
		 baseDao.add(customer);
	}
	
	public void deleteCustomer(int id){
		baseDao.delete(Customer.class, id);
	}
	
	public void updateCustomer(Customer customer){
		baseDao.update(customer);
	}
	
	public  List<Customer> listCustomer(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
