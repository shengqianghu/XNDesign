package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Size;
import cn.com.xn.util.PageBean;

public class SizeDao {
	private BaseDao baseDao;
	public SizeDao(){
		baseDao=new BaseDao();
	}
	
	public void  addSize(Size size){
		 baseDao.add(size);
	}
	
	public void deleteSize(int id){
		baseDao.delete(Size.class, id);
	}
	
	public void updateSize(Size size){
		baseDao.update(size);
	}
	
	public  List<Size> listSize(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
