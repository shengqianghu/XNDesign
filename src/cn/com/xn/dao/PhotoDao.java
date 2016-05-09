package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Photo;
import cn.com.xn.util.PageBean;

public class PhotoDao {
	private BaseDao baseDao;
	public PhotoDao(){
		baseDao=new BaseDao();
	}
	
	public void  addPhoto(Photo photo){
		 baseDao.add(photo);
	}
	
	public void deletePhoto(int id){
		baseDao.delete(Photo.class, id);
	}
	
	public void updatePhoto(Photo photo){
		baseDao.update(photo);
	}
	
	public  List<Photo> listPhoto(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
