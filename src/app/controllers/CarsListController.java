package app.controllers;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import app.springhibernate.model.Car;
import app.springhibernate.service.CarService;
 
@ManagedBean(name="CarsListController")
@ViewScoped
public class CarsListController implements Serializable {
   
	private static final Logger logger = LoggerFactory.getLogger(CarsListController.class);
	private static final long serialVersionUID = 8604437196619149720L;
	

	@ManagedProperty("#{carService}")
    private CarService carService;
	
	private Car car;
	private List<Car> cars;
   
	@PostConstruct
    public void init() {
		try
		{
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
    	car = new Car();
        cars = carService.listCars();
        logger.info("Initialized");
    }
    
    public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
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

	public String addCar() {
		try
		{
			carService.addCar(car);
			cars = carService.listCars();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Car "+this.car.getDescription()+" Is Added Successfully"));
			logger.info("Car "+this.car+" Is Added Successfully");
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return "";
	}
	

	public String deleteCar(Car car) {
		try
		{
			carService.deleteCar(car);
			cars = carService.listCars();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("The Car "+ this.car.getDescription() +" Is Deleted Successfully"));
			logger.info("The Car "+ this.car +" Is Deleted Successfully");
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return "";
	}
	
	public void onRowEdit(RowEditEvent event) {
		try
		{
			logger.info("The Car "+ this.car +" Is Edited Successfully");
	        Car c = (Car)event.getObject();
	        carService.updateCar(c);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	 }
    
	public String logout() {
		try
		{
			logger.info("Log out");
			return "Login";
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			return null;
		}
	}   

}