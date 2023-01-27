package com.example.miniproject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	private String s_Name;
	private String s_Gender;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer s_Id;


	private Integer s_AvailableLeaves = 7 ;

	private Integer s_PhoneNumber;

	 

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "a_Id")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "d_Id")
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getS_Name() {
		return s_Name;
	}

	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}

	public String getS_Gender() {
		return s_Gender;
	}

	public void setS_Gender(String s_Gender) {
		this.s_Gender = s_Gender;
	}

	public Integer getS_Id() {
		return s_Id;
	}

	public void setS_Id(Integer s_Id) {
		this.s_Id = s_Id;
	}

	 

	public Integer getS_AvailableLeaves() {
		return s_AvailableLeaves;
	}

	public void setS_AvailableLeaves(Integer s_AvailableLeaves) {
		this.s_AvailableLeaves = s_AvailableLeaves;
	}

	public Integer getS_PhoneNumber() {
		return s_PhoneNumber;
	}

	public void setS_PhoneNumber(Integer s_PhoneNumber) {
		this.s_PhoneNumber = s_PhoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [s_Name=" + s_Name + ", s_Gender=" + s_Gender + ", s_Id=" + s_Id + ", s_AvailableLeaves="
				+ s_AvailableLeaves + ", s_PhoneNumber=" + s_PhoneNumber + ", address=" + address + ", department="
				+ department + "]";
	}

}
