package cn.com.xn.model;

import java.util.Date;

public class Car {
	private int id;
	private CarKind carKind;
	private String brand;
	private int repertory;
	private float money;
	private Date ttm;
	private String details;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	public CarKind getCarKind() {
		return carKind;
	}
	public void setCarKind(CarKind carKind) {
		this.carKind = carKind;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRepertory() {
		return repertory;
	}
	public void setRepertory(int repertory) {
		this.repertory = repertory;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Date getTtm() {
		return ttm;
	}
	public void setTtm(Date ttm) {
		this.ttm = ttm;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	

}
