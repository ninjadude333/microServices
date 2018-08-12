package com.example.amdocs;

public class singleOrder {

	public singleOrder(int id, String name, String customerDetails) {
		super();
		this.id = id;
		this.name = name;
		this.customerDetails = customerDetails;
	}

	int id;
	String name;
	String customerDetails;
	
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

	public String getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public String toString() {
		return "singleOrder [id=" + id + ", name=" + name + ", Customer Details=" + customerDetails + "]";
	}
	
	
}
