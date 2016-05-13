package cn.com.xn.model;

import java.util.Date;
import java.util.List;

public class Car {
	private int id;
	private CarKind carKind;
	private String brand;
	private int repertory;
	private float money;
	private Date ttm;
	private String details;
	private String poster;
	private List<Photo> photos;
	private List<Color> colors;
	private List<Size> sizes;
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
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public List<Color> getColors() {
		return colors;
	}
	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
	public List<Size> getSizes() {
		return sizes;
	}
	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	
	

}
