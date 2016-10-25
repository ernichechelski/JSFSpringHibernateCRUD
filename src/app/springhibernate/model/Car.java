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
 */
@Entity
@Table(name="CARS")
@ManagedBean(name="car")
public class Car {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
     
	@Column(name="make")
    private String make;
	
	@Column(name="model")
    private String model;
	
	@Column(name="sub_model")
    private String submodel;
	
	@Column(name="year")
    private short year;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSubmodel() {
		return submodel;
	}

	public void setSubmodel(String submodel) {
		this.submodel = submodel;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", submodel=" + submodel + ", year=" + year
				+ "]";
	}
	
	
	public String getDescription() {
		return make + " " + model + " " + submodel + " " + year;
 	}
	
}