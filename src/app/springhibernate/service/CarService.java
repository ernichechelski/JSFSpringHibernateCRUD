package app.springhibernate.service;

import java.util.List;

import app.springhibernate.model.Car;

public interface CarService {
	
	public void addCar(Car c);
    public List<Car> listCars();
    public void deleteCar(Car c);
    public void updateCar(Car c);
    public void testLog();
}
