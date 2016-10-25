package app.springhibernate.dao;

import java.util.List;
import app.springhibernate.model.User;
/**
 * User data access object interface
 * */
public interface UserDAO {
	
	public List<User> listUsers();
}
