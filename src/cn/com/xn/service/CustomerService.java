package cn.com.xn.service;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.com.xn.dao.CustomerDao;
import cn.com.xn.model.Customer;
import cn.com.xn.util.PageBean;

public class CustomerService {
	private CustomerDao customerDao;
	public CustomerService(){
		customerDao=new CustomerDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addCustomer(Customer customer){
		customer.setTime(new Date());
		ActionContext.getContext().getSession().put("customer", customer);
		customerDao.addCustomer(customer);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteCustomer(Customer customer){
		if(customer!=null&&customer.getId()!=0){
			customerDao.deleteCustomer(customer.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateCustomer(Customer customer){
		customerDao.updateCustomer(customer);
	}
	
	public boolean login(Customer customer){
		String hql="from Customer c where c.userName=? and c.password=?";
		Object[] objs=new Object[]{customer.getUserName(),customer.getPassword()};
		List<Customer> list=customerDao.listCustomer(hql, objs);
		if(list!=null&&list.size()>0){
			Customer cus=list.get(0);
			ActionContext.getContext().getSession().put("customer", cus);
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<Customer>
	 * 
	 */
	public List<Customer> listCustomer(Customer customer){
		String hql="from Customer b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		/*if(customer!=null){
			 objs=new Object[]{customer.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return customerDao.listCustomer(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Customer customer){
		String hql="from Customer b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
		/*if(customer!=null){
			objs=new Object[]{customer.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return customerDao.pageBean(pageBean, hql, objs);
	}

}
