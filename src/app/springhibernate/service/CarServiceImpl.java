package app.springhibernate.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import app.springhibernate.dao.CarDAO;
import app.springhibernate.model.Car;


@Service
@ManagedBean(name = "carService")
@SessionScoped
public class CarServiceImpl implements CarService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
	private CarDAO carDAO;

	public void setCarDAO(CarDAO carDAO) {
		this.carDAO = carDAO;
	}

	@Override
	@Transactional
	public void addCar(Car c) {
		this.carDAO.addCar(c);
	}

	@Override
	@Transactional
	public List<Car> listCars() {
		return this.carDAO.listCars();
	}

	@Override
	@Transactional
	public void deleteCar(Car c) {
		this.carDAO.deleteCar(c);
	}

	@Override
	@Transactional
	public void updateCar(Car c) {
		this.carDAO.updateCar(c);
	}

	@Override
	public void testLog() {
		
	}

}