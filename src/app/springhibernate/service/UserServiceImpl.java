package app.springhibernate.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.springhibernate.dao.UserDAO;
import app.springhibernate.model.User;

@Service
@ManagedBean(name="userService")
@SessionScoped
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	 
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
 
    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDAO.listUsers();
    }
}