package com.example.amdocs;

public class singleItem {

	public singleItem(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	int id;
	String name;
	String description;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String Description) {
		description = Description;
	}

	@Override
	public String toString() {
		return "singleItem [id=" + id + ", name=" + name + ", Description=" + description + "]";
	}
	
	
}
