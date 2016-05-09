package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Color;
import cn.com.xn.util.PageBean;

public class ColorDao {
	private BaseDao baseDao;
	public ColorDao(){
		baseDao=new BaseDao();
	}
	
	public void  addColor(Color color){
		 baseDao.add(color);
	}
	
	public void deleteColor(int id){
		baseDao.delete(Color.class, id);
	}
	
	public void updateColor(Color color){
		baseDao.update(color);
	}
	
	public  List<Color> listColor(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
