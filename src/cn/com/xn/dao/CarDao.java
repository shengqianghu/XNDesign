package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Car;
import cn.com.xn.util.PageBean;

public class CarDao {

	private BaseDao baseDao;
	public CarDao(){
		baseDao=new BaseDao();
	}
	public void addCar(Car car){
		baseDao.add(car);
	}
	public void deleteCar(int id){
		baseDao.delete(Car.class, id);
	}
	public void updateCar(Car car){
		baseDao.update(car);
	}
	public List<Car> listCar(String hql,Object[] objs){
		return baseDao.list(hql, objs);
	}
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}
}
