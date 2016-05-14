package cn.com.xn.model;

import java.util.Date;

public class Business {
	private int id;
	private Customer customer;
	private Car car;
	private int cquality;
	private Date buyTime;
	private CarColor carColor;
	private CarSize carSize;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public int getCquality() {
		return cquality;
	}
	public void setCquality(int cquality) {
		this.cquality = cquality;
	}

	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public CarColor getCarColor() {
		return carColor;
	}
	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}
	public CarSize getCarSize() {
		return carSize;
	}
	public void setCarSize(CarSize carSize) {
		this.carSize = carSize;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}
