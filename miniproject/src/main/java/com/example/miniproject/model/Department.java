package com.example.miniproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {
    
	private String d_Name;
    @Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer d_Id;
	
	public String getD_Name() {
		return d_Name;
	}
	public void setD_Name(String d_Name) {
		this.d_Name = d_Name;
	}
	
	public Integer getD_Id() {
		return d_Id;
	}
	public void setD_Id(Integer d_Id) {
		this.d_Id = d_Id;
	}
	 
	public Department(String d_Name, Integer d_Id) {
		super();
		this.d_Name = d_Name;
		this.d_Id = d_Id;
	}
	
	public Department() {
		
	}

}
