package app.springhibernate.dao;

import java.util.List;
import app.springhibernate.model.Car;
/**
 * Car data access object interface
 * */

public interface CarDAO {
	
	public void addCar(Car p);
    public List<Car> listCars();
    public void deleteCar(Car p);
    public void updateCar(Car p);

}
