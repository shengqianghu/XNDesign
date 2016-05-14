package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.CarColor;
import cn.com.xn.util.PageBean;

public class CarColorDao {
	private BaseDao baseDao;
	public CarColorDao(){
		baseDao=new BaseDao();
	}
	
	public void  addCarColor(CarColor carColor){
		 baseDao.add(carColor);
	}
	
	public void deleteCarColor(int id){
		baseDao.delete(CarColor.class, id);
	}
	
	public void updateCarColor(CarColor carColor){
		baseDao.update(carColor);
	}
	
	public  List<CarColor> listCarColor(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
