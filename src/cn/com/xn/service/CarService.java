package cn.com.xn.service;

import java.util.List;

import cn.com.xn.dao.CarDao;
import cn.com.xn.model.Car;
import cn.com.xn.util.PageBean;

public class CarService {
	private CarDao carDao;
	public CarService(){
		carDao=new CarDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addCar(Car car){
		carDao.addCar(car);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteCar(Car car){
		if(car!=null&&car.getId()!=0){
			carDao.deleteCar(car.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateCar(Car car){
		carDao.updateCar(car);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<Car>
	 * 
	 */
	public List<Car> listCar(Car car){
		String hql="from Car b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		if(car!=null){
			/* objs=new Object[]{car.getCar().getId()};
			 hql+=" and b.car.id=?";*/
		}
		return carDao.listCar(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Car car){
		String hql="from Car b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
	/*	if(car!=null){
			objs=new Object[]{car.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return carDao.pageBean(pageBean, hql, objs);
	}

}
