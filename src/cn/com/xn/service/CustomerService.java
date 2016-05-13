package cn.com.xn.service;

import java.util.Date;
import java.util.List;

import cn.com.xn.dao.CustomerDao;
import cn.com.xn.model.Customer;
import cn.com.xn.model.ShoppingCar;
import cn.com.xn.util.PageBean;

import com.opensymphony.xwork2.ActionContext;

public class CustomerService {
	private CustomerDao customerDao;
	private ShoppingCarService shoppingCarService;
	public CustomerService(){
		customerDao=new CustomerDao();
		shoppingCarService=new ShoppingCarService();
	}
	/**
	 * 娣诲姞
	 * 鏃堕棿锛�2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addCustomer(Customer customer){
		customer.setTime(new Date());
		ActionContext.getContext().getSession().put("customer", customer);
		shoppingCarService.queryCount(customer);
		customerDao.addCustomer(customer);
	}
	
	
	/**
	 * 鍒犻櫎
	 * 鏃堕棿锛�2016-5-9
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
	 * 淇敼
	 * 鏃堕棿锛�2016-5-9
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
			shoppingCarService.queryCount(cus);
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 浠ist鐨勬柟寮忔煡璇�
	 * 鏃堕棿锛�2016-5-9
	 * @param $
	 * @return  List<Customer>
	 * 
	 */
	public List<Customer> listCustomer(Customer customer){
		String hql="from Customer b where 1=1";
		Object[] objs=null;
		//濡傛灉鏈夋潯浠跺垯甯︿笂鏉′欢锛屼负绌虹殑璇濇煡璇㈠叏閮�
		/*if(customer!=null){
			 objs=new Object[]{customer.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return customerDao.listCustomer(hql, objs);
	}
	
	/**
	 * 閫氳繃鍒嗛〉鐨勫舰寮忔煡璇�
	 * 鏃堕棿锛�2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Customer customer){
		String hql="from Customer b where 1=1";
		Object[] objs=null;
		//涓虹┖鏃舵煡璇㈠叏閮ㄤ俊鎭�
		/*if(customer!=null){
			objs=new Object[]{customer.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//榛樿鐨勪竴椤垫樉绀�10鏉¤褰�
			pageBean.setPageSize(6);
		}
		return customerDao.pageBean(pageBean, hql, objs);
	}

}
