package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.CarKind;
import cn.com.xn.util.PageBean;

public class CarKindDao {

	private BaseDao baseDao;
	public CarKindDao(){
		baseDao=new BaseDao();
	}
	public void addCarKind(CarKind carKind){
		baseDao.add(carKind);
	}
	public void deleteCarKind(int id){
		baseDao.delete(CarKind.class, id);
	}
	public void updateCarKind(CarKind carKind){
		baseDao.update(carKind);
	}
	public List<CarKind> listCarKind(String hql,Object[] objs){
		return baseDao.list(hql, objs);
	}
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}
}
