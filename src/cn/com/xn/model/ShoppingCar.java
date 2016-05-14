package cn.com.xn.model;

public class ShoppingCar {
	private int id;
	private Customer customer;
	private Car car;
	private CarSize carSize;
	private CarColor carColor;
	private int quantity;
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
	public CarSize getCarSize() {
		return carSize;
	}
	public void setCarSize(CarSize carSize) {
		this.carSize = carSize;
	}
	public CarColor getCarColor() {
		return carColor;
	}
	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
