package cn.com.xn.service;

import java.util.List;

import cn.com.xn.dao.CarKindDao;
import cn.com.xn.model.CarKind;
import cn.com.xn.util.PageBean;

public class CarKindService {
	private CarKindDao carKindDao;
	public CarKindService(){
		carKindDao=new CarKindDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addCarKind(CarKind carKind){
		carKindDao.addCarKind(carKind);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteCarKind(CarKind carKind){
		if(carKind!=null&&carKind.getId()!=0){
			carKindDao.deleteCarKind(carKind.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateCarKind(CarKind carKind){
		carKindDao.updateCarKind(carKind);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<CarKind>
	 * 
	 */
	public List<CarKind> listCarKind(CarKind carKind){
		String hql="from CarKind b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		/*if(carKind!=null){
			 objs=new Object[]{carKind.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return carKindDao.listCarKind(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,CarKind carKind){
		String hql="from CarKind b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
	/*	if(carKind!=null){
			objs=new Object[]{carKind.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return carKindDao.pageBean(pageBean, hql, objs);
	}

}
