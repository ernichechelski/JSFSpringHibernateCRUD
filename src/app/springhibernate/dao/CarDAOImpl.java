package app.springhibernate.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import app.springhibernate.model.Car;
/**
 * Car data access object interface implementation
 * */
@Repository
public class CarDAOImpl implements CarDAO {

	private static final Logger logger = LoggerFactory.getLogger(CarDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addCar(Car p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("Car saved successfully, Car Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<Car> listCars() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Car> carsList = session.createQuery("from Car").list();
	        for(Car c : carsList) {
	            logger.info("Car List::"+c);
	        }
	        return carsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteCar(Car c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("Car deleted successfully, Car Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateCar(Car c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("Car updated successfully, Car Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}
}
