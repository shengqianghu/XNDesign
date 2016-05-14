package cn.com.xn.dao;

import java.util.List;

import cn.com.xn.model.ShoppingCar;
import cn.com.xn.util.PageBean;

public class ShoppingCarDao {
	private BaseDao baseDao;
	public ShoppingCarDao(){
		baseDao=new BaseDao();
	}
	
	public void  addShoppingCar(ShoppingCar shoppingCar){
		 baseDao.add(shoppingCar);
	}
	
	public void deleteShoppingCar(int id){
		baseDao.delete(ShoppingCar.class, id);
	}
	
	public ShoppingCar querySingle(int id){
		return (ShoppingCar)baseDao.load(ShoppingCar.class, id);
	}
	
	public void updateShoppingCar(ShoppingCar shoppingCar){
		baseDao.update(shoppingCar);
	}
	
	public  List<ShoppingCar> listShoppingCar(String hql,Object[] objs){
		return baseDao.list(hql, objs); 
	}
	
	public PageBean pageBean(PageBean pageBean,String hql,Object[] objs){
		return baseDao.page(hql, objs, pageBean);
	}

}
