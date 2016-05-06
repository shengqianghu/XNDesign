package cn.com.xn.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	/**
	 * hh
	 */
	private static final long serialVersionUID = 7988995756875725795L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("fuck you!");
		return super.execute();
	}

	/**
	 * @return 返回的页面
	 * 用户登录Action
	 * 
	 */
	public String login(){
		return SUCCESS;
	}
	
	public String regist(){
		return "regist_success";
	}
	
}
