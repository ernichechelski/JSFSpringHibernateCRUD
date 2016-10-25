package app.controllers;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import app.springhibernate.model.User;


@ManagedBean(name="LoginController")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private String login;
	private String pass;
	private SessionFactory sessionFactory;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String login() {
		
		 
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String userName = "";
        Session session = this.sessionFactory.openSession();
       
        Criteria cr = session.createCriteria(User.class);
        Criterion salary = Restrictions.eq("login", login);
        
        String generatedHash = DigestUtils.md5Hex(pass);
        logger.info("Generated hash:"+ generatedHash);
        
        Criterion name = Restrictions.eq("passhash",generatedHash);
       
        LogicalExpression andExp = Restrictions.and(salary, name);
        cr.add( andExp );
        
        @SuppressWarnings("unchecked")
		List<User> usersList = cr.list();
        if(usersList.size()>0)
        {
        	User u = usersList.get(0);
        	loggedIn = true;
    		userName = u.getName();
        }
        if(loggedIn)
        {
        	logger.info("First matching user logged in ::"+userName);
        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome: "+userName,null );
        	FacesContext.getCurrentInstance().addMessage(null, message);
        	context.addCallbackParam("loggedIn", loggedIn);
        	return "CarsList";
        }
        else
        {
        	logger.info("Wrong password or login");
        	message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Wrong password or login");
        	FacesContext.getCurrentInstance().addMessage(null, message);
        	context.addCallbackParam("loggedIn", loggedIn);
        	return "Login";
        }
    }   

}
