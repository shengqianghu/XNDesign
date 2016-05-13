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
	 * 娣诲姞
	 * 鏃堕棿锛�2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addCar(Car car){
		carDao.addCar(car);
	}
	/**
	 * 鍒犻櫎
	 * 鏃堕棿锛�2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteCar(Car car){
		if(car!=null&&car.getId()!=0){
			carDao.deleteCar(car.getId());
		}
	}
	
	public Car getCarDetails(Car car){
		return carDao.getCarDetails(car);
	}
	/**
	 * 淇敼
	 * 鏃堕棿锛�2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateCar(Car car){
		carDao.updateCar(car);
	}
	/**
	 * 浠ist鐨勬柟寮忔煡璇�
	 * 鏃堕棿锛�2016-5-9
	 * @param $
	 * @return  List<Car>
	 * 
	 */
	public List<Car> listCar(Car car){
		String hql="from Car b where 1=1 ";
		Object[] objs=null;
		//濡傛灉鏈夋潯浠跺垯甯︿笂鏉′欢锛屼负绌虹殑璇濇煡璇㈠叏閮�
		if(car!=null){
			/* objs=new Object[]{car.getCar().getId()};
			 hql+=" and b.car.id=?";*/
		}
		return carDao.listCar(hql, objs);
	}
	
	/**
	 * 閫氳繃鍒嗛〉鐨勫舰寮忔煡璇�
	 * 鏃堕棿锛�2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Car car){
		String hql="from Car b where 1=1";
		Object[] objs=null;
		//涓虹┖鏃舵煡璇㈠叏閮ㄤ俊鎭�
	/*	if(car!=null){
			objs=new Object[]{car.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//榛樿鐨勪竴椤垫樉绀�10鏉¤褰�
			pageBean.setPageSize(6);
		}
		return carDao.pageBean(pageBean, hql, objs);
	}

}
