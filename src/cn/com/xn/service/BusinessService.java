package cn.com.xn.service;

import java.util.Date;
import java.util.List;

import cn.com.xn.dao.BusinessDao;
import cn.com.xn.dao.ShoppingCarDao;
import cn.com.xn.model.Business;
import cn.com.xn.model.ShoppingCar;
import cn.com.xn.util.PageBean;

public class BusinessService {
	private BusinessDao businessDao;
	private ShoppingCarDao shoppingCarDao;
	public BusinessService(){
		businessDao=new BusinessDao();
		shoppingCarDao=new ShoppingCarDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addBusiness(String ids,String quantities){
		String[] idStr=ids.split(",");
		String[] quan=quantities.split(",");
		if(idStr.length!=0){
			for(int i=0;i<idStr.length;i++){
				int id=Integer.parseInt(idStr[i]);
				ShoppingCar sc=shoppingCarDao.querySingle(id);
				Business business=new Business();
				business.setCar(sc.getCar());
				business.setCarColor(sc.getCarColor());
				business.setCarSize(sc.getCarSize());
				int quantity=Integer.parseInt(quan[i]);
				business.setCquality(quantity);
				business.setCustomer(sc.getCustomer());
				business.setPrice(quantity*sc.getCar().getMoney());
				business.setBuyTime(new Date());
				businessDao.addBusiness(business);
			}
		}
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteBusiness(Business business){
		if(business!=null&&business.getId()!=0){
			businessDao.deleteBusiness(business.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateBusiness(Business business){
		businessDao.updateBusiness(business);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<Business>
	 * 
	 */
	public List<Business> listBusiness(Business business){
		String hql="from Business b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		/*if(business!=null){
			 objs=new Object[]{business.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return businessDao.listBusiness(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Business business){
		String hql="from Business b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
		/*if(business!=null){
			objs=new Object[]{business.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return businessDao.pageBean(pageBean, hql, objs);
	}

}
