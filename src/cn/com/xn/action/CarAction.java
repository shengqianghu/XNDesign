package cn.com.xn.action;

import com.opensymphony.xwork2.ActionSupport;

public class CarAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String carDetail(){
		return SUCCESS;
	}
	
	public String repairOrder(){
		return "repairOrder_success";
	}
}
