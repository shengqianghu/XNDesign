package cn.com.xn.action;

import java.util.List;

import org.hibernate.service.spi.ServiceRegistryAwareService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.com.xn.model.Car;
import cn.com.xn.model.ShoppingCar;
import cn.com.xn.service.CarService;

public class CarAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CarService carService = new CarService();
	// save all the cars for index jsp to show
	private List<Car> cars;
	// the car which contain the informations
	private Car car;

	/**
	 * @return
	 * 
	 */
	public String addCar() {

		return "add";
	}

	/**
	 * @return find all cars in the index files
	 */
	public String showCars() {
		// all the cars
		cars = carService.listCar(null);
		//≤‚ ‘“ªœ¬
		//ActionContext.getContext().getSession().put("commodiety_counts", "bitch");
		
		return SUCCESS;
	}

	/**
	 * @return get the car details and return to the details page
	 */
	public String details() {
		car = carService.getCarDetails(car);
		return "detail";
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
