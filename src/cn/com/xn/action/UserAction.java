package cn.com.xn.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
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

	public String login(){
		System.out.println("Hello , You mother fucker!");
		return SUCCESS;
	}
}
