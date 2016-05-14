package cn.com.pso.interceptor;

import cn.com.xn.model.Customer;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class BackgroundInterceptor implements Interceptor {

	private String packageName="cn.com.xn.action.";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("访问的类:" + arg0.getAction().getClass().getName());
		System.out.println("访问的url路径:" + arg0.getProxy().getActionName());
		System.out.println("访问的方法:" + arg0.getProxy().getMethod());
		String className=arg0.getAction().getClass().getName();
		String method=arg0.getProxy().getMethod();
		String result=this.backOrFore(className, method, arg0);
		return result;
		
	}
	
	private String backOrFore(String className,String method,ActionInvocation arg0) throws Exception {
		Customer customer=(Customer)arg0.getInvocationContext().getSession().get("customer");
		if(className.equals(packageName+"userAction")){
				return arg0.invoke();
		}else if(className.equals(packageName+"ShoppingCarAction")
				||className.equals(packageName+"RecordAction")){
			if(customer!=null){
				return arg0.invoke();
			}else{
				return "foregroundLogin";
			}
		}else{
			return arg0.invoke();
		}
	}
		

}
