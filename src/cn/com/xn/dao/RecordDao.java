package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Record;
import cn.com.xn.util.PageBean;

public class RecordDao {
	private BaseDao baseDao;
	public RecordDao(){
		baseDao=new BaseDao();
	}
	
	public void  addRecord(Record record){
		 baseDao.add(record);
	}
	
	public void deleteRecord(int id){
		baseDao.delete(Record.class, id);
	}
	
	public void updateRecord(Record record){
		baseDao.update(record);
	}
	
	public  List<Record> listRecord(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
