package cn.com.xn.action;


import java.util.List;

import cn.com.xn.model.Business;
import cn.com.xn.model.Car;
import cn.com.xn.model.Customer;
import cn.com.xn.model.ShoppingCar;
import cn.com.xn.service.BusinessService;
import cn.com.xn.service.ShoppingCarService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCarAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5017318465790767923L;
	//present which car
	private Car car;
	//
	private String result;
	
	private ShoppingCar shoppingCar;
	
	private List<ShoppingCar> shoppingCarList;
	
	private String ids;
	private String quantities;
	private Business business;
	private BusinessService businessService=new BusinessService();
	
	private ShoppingCarService shopCarService=new ShoppingCarService();
	/**
	 * @return
	 * add car to shopping car
	 */
	public String addToCar(){
		//���ȼ���Ƿ��¼
		Customer customer = (Customer)ActionContext.getContext().getSession().get("customer");
		//��ʾû�е�¼
		if(customer == null){
			result = "faile";
		}else{
			shoppingCar.setCustomer(customer);
			shopCarService.addShoppingCar(shoppingCar);
			List<ShoppingCar> list=shopCarService.listShoppingCar(shoppingCar);
			result = list.size()+"";
		}
		return "addToCar";
	}
	
	public String addToBusiness(){
		businessService.addBusiness(ids,quantities);
		return "addToBusiness";
	}
	
	public String deleteShoppingCar(){
		shopCarService.deleteShoppingCar(shoppingCar);
		return "deleteShoppingCar";
	}
	
	public String selectAll(){
		shoppingCarList=shopCarService.listShoppingCar(shoppingCar);
		return "selectAll";
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

 
	public ShoppingCar getShoppingCar() {
		return shoppingCar;
	}

	public void setShoppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}

	public ShoppingCarService getShopCarService() {
		return shopCarService;
	}

	public void setShopCarService(ShoppingCarService shopCarService) {
		this.shopCarService = shopCarService;
	}

	public List<ShoppingCar> getShoppingCarList() {
		return shoppingCarList;
	}

	public void setShoppingCarList(List<ShoppingCar> shoppingCarList) {
		this.shoppingCarList = shoppingCarList;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getQuantities() {
		return quantities;
	}

	public void setQuantities(String quantities) {
		this.quantities = quantities;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}
	
	
	
	
	
	
	
	
}
