package app.springhibernate.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author
 *
 */
@Entity
@Table(name="USERS")
@ManagedBean(name="user")
public class User {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
	@Column(name="name")
    private String name;
    
	@Column(name="login")
    private String login;
    
	@Column(name="passhash")
    private String passhash;
    
    public int getId() {
		return id;
	}

    public void setId(int id) {
		this.id = id;
	}

    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}

    public String getLogin() {
		return login;
	}

    public void setLogin(String login) {
		this.login = login;
	}

    public String getPasshash() {
		return passhash;
	}

    public void setPasshash(String passhash) {
		this.passhash = passhash;
	}

    @Override
    public String toString(){
        return "id="+id+", name="+name + ", login="+login + ", passhash="+passhash;
    }
}