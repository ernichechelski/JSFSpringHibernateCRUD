package app.springhibernate.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import app.springhibernate.model.User;
/**
 * User data access object interface implementation
 * */
@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            List<User> usersList = session.createQuery("from User").list();
            for(User u : usersList){
                logger.info("User List::"+u);
            }
            return usersList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
    }

	
	
	
 
}