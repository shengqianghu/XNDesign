package cn.com.xn.util;

import java.util.List;

import cn.com.xn.model.Test;
import cn.com.xn.service.TestService;

public class TestMain {

	/**
	 * 时间：2016-5-6
	 * @param $
	 * @return  void
	 * 
	 */
	public static void main(String[] args) {
		
		/*Test test=new Test();
		test.setName("zhangsan");*/
		TestService testService=new TestService();
		Test test=new Test();
		test.setName("Zhangsan");
		List<Test> list=testService.queryAll(test);
		System.out.println(list);
		
	}

}
