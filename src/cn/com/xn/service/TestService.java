package cn.com.xn.service;

import java.util.List;

import cn.com.xn.dao.TestDao;
import cn.com.xn.model.Test;

public class TestService {
	private TestDao testDao;
	public TestService(){
		testDao=new TestDao();
	}
	
	public List<Test> queryAll(){
		String hql="from Test";
		return testDao.listTest(hql);
	}

}
