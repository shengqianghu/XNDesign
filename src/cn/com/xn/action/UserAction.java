package cn.com.xn.action;

import cn.com.xn.model.Customer;
import cn.com.xn.service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport {
	private Customer customer;
	private CustomerService customerService=new CustomerService();
	private String result;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7988995756875725795L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("fuck you!");
		return super.execute();
	}
	public String regist(){
		customerService.addCustomer(customer);
		return "regist";
	}
	
	public String login(){
		boolean bool=customerService.login(customer);
		if(bool){
			result="登录成功！！！";
			return SUCCESS;
		}else{
			result="用户名或者密码错误！！！";
			return ERROR;
		}
	}

	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
}
