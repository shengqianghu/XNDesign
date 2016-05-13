package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.Car;
import cn.com.xn.model.CarKind;
import cn.com.xn.model.Color;
import cn.com.xn.model.Photo;
import cn.com.xn.model.Size;
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
	/**
	 * @param car
	 * @return
	 * in here , we need to get the colors and the sizes that the car includes
	 */
	public Car getCarDetails(Car car){
		String hql = "form Car car where 1= 1  ";
		car = (Car) baseDao.load(Car.class, car.getId());
		//now the kind
		
		hql = "select ck.brand  from Car car,CarKind ck where car.carKind = ck and car.id = " + car.getId();
		List<String> brands  = baseDao.list(hql);
		String brand = null;
		if(brands != null && brands.size() > 0)
		brand=(String) baseDao.list(hql).get(0);
		CarKind ck = new CarKind();
		ck.setBrand(brand);
		car.setCarKind(ck);
		
		
		//then the color 
		hql = "select c from Car car,CarColor cc,Color c where cc.car = car and cc.color = c and car.id = " + car.getId();
		List<Color> colors  = baseDao.list(hql);
		car.setColors(colors);
		//then the size
		
		hql = "select s from Car car,CarSize cs,Size s where cs.car = car and cs.size = s and car.id = " + car.getId() ;
		List<Size> sizes  = baseDao.list(hql);
		car.setSizes(sizes);
		for(Size size:sizes)
			System.out.println("the size is:"+size.getSize());
		
		//then the pictures
		hql = "select ph from Car car,Photo ph where ph.car = car and car.id = " + car.getId();
		List<Photo> photos  = baseDao.list(hql);
		car.setPhotos(photos);
		for(Photo po:photos)
			System.out.println(po.getPhoto());
		return car;
	}
	
	public List<Car> listCar(String hql,Object[] objs){
		return baseDao.list(hql, objs);
	}
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}
}
