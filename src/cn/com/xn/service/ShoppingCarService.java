package cn.com.xn.service;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.com.xn.dao.ShoppingCarDao;
import cn.com.xn.model.Customer;
import cn.com.xn.model.ShoppingCar;
import cn.com.xn.util.PageBean;

public class ShoppingCarService {
	private ShoppingCarDao shoppingCarDao;
	public ShoppingCarService(){
		shoppingCarDao=new ShoppingCarDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addShoppingCar(ShoppingCar shoppingCar){
		shoppingCarDao.addShoppingCar(shoppingCar);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteShoppingCar(ShoppingCar shoppingCar){
		if(shoppingCar!=null&&shoppingCar.getId()!=0){
			shoppingCarDao.deleteShoppingCar(shoppingCar.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateShoppingCar(ShoppingCar shoppingCar){
		shoppingCarDao.updateShoppingCar(shoppingCar);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<ShoppingCar>
	 * 
	 */
	public List<ShoppingCar> listShoppingCar(ShoppingCar shoppingCar){
		String hql="from ShoppingCar b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		if(shoppingCar.getCustomer()!=null){
			 objs=new Object[]{shoppingCar.getCustomer().getId()};
			 hql+=" and b.customer.id=?";
		}
		return shoppingCarDao.listShoppingCar(hql, objs);
	}
	
	public void queryCount(Customer customer){
		String hql="from ShoppingCar b where 1=1 and b.customer.id="+customer.getId();
		List<ShoppingCar> list=shoppingCarDao.listShoppingCar(hql, null);
		ActionContext.getContext().getSession().put("shoppingCar", list.size());
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,ShoppingCar shoppingCar){
		String hql="from ShoppingCar b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
		/*if(shoppingCar!=null){
			objs=new Object[]{shoppingCar.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return shoppingCarDao.pageBean(pageBean, hql, objs);
	}

}
