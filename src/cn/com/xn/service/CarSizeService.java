package cn.com.xn.service;

import java.util.List;

import cn.com.xn.dao.CarSizeDao;
import cn.com.xn.model.CarSize;
import cn.com.xn.util.PageBean;

public class CarSizeService {
	private CarSizeDao carSizeDao;
	public CarSizeService(){
		carSizeDao=new CarSizeDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addCarSize(CarSize carSize){
		carSizeDao.addCarSize(carSize);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteCarSize(CarSize carSize){
		if(carSize!=null&&carSize.getId()!=0){
			carSizeDao.deleteCarSize(carSize.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateCarSize(CarSize carSize){
		carSizeDao.updateCarSize(carSize);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<CarSize>
	 * 
	 */
	public List<CarSize> listCarSize(CarSize carSize){
		String hql="from CarSize b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		/*if(carSize!=null){
			 objs=new Object[]{carSize.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return carSizeDao.listCarSize(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,CarSize carSize){
		String hql="from CarSize b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
		/*if(carSize!=null){
			objs=new Object[]{carSize.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return carSizeDao.pageBean(pageBean, hql, objs);
	}

}
