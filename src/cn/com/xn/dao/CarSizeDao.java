package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.CarSize;
import cn.com.xn.util.PageBean;

public class CarSizeDao {
	private BaseDao baseDao;
	public CarSizeDao(){
		baseDao=new BaseDao();
	}
	
	public void  addCarSize(CarSize carSize){
		 baseDao.add(carSize);
	}
	
	public void deleteCarSize(int id){
		baseDao.delete(CarSize.class, id);
	}
	
	public void updateCarSize(CarSize carSize){
		baseDao.update(carSize);
	}
	
	public  List<CarSize> listCarSize(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
