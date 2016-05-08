package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Test;

public class TestDao  {
	private BaseDao<Test> baseDao;
	
	public TestDao(){
		baseDao=new BaseDao<Test>();
	}

	public void addTest(Test test){
		baseDao.add(test);
	}
	
	public List<Test> listTest(String hql){
		return baseDao.list(hql);
		
	}

}
