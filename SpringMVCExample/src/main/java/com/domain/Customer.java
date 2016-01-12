package com.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private String city;
	private String street;
	private String state;
	private String country;
	//@Column(name="zip_code")
	private String zipCode;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
	@OrderColumn(name = "idx")
	private List<Order> ordersPlaced = new ArrayList<Order>();
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	@NotFound(action = NotFoundAction.IGNORE)//if not found just ignore
	private PhoneInformation phoneInfo;
	
	public PhoneInformation getPhoneInfo() {
		return phoneInfo;
	}

	public void setPhoneInfo(PhoneInformation phoneInfo) {
		this.phoneInfo = phoneInfo;
	}


	public List<Order> getOrdersPlaced() {
		return ordersPlaced;
	}

	public void setOrdersPlaced(List<Order> ordersPlaced) {
		this.ordersPlaced = ordersPlaced;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String toString() {
		return name + " " + Integer.toString(customerId);
	}

}