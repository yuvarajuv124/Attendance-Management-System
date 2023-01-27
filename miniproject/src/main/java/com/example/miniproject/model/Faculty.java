package com.example.miniproject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Faculty {
	
	private String f_Name;
	
	private String f_Gender;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer f_Id;
	 
		 private Integer f_AvailableLeaves = 10;
		 
		 private Integer f_PhoneNumber;
		 
		 @OneToOne(cascade = CascadeType.ALL)
		 @JoinColumn(name = "a_Id")
		 private Address address;
	 
		 @OneToOne(cascade = CascadeType.ALL)
		 @JoinColumn(name = "d_Id")
		 private  Department department;
		 
		public Department getDepartment() {
			return department;
		}
		public void setDepartment(Department dept) {
			this.department = dept;
		}
		
		public String getF_Name() {
			return f_Name;
		}
		public void setF_Name(String f_Name) {
			this.f_Name = f_Name;
		}
		
		public String getF_Gender() {
			return f_Gender;
		}
		public void setF_Gender(String f_Gender) {
			this.f_Gender = f_Gender;
		}
		
		public Integer getFaculty_Id() {
			return f_Id;
		}
		public void setFaculty_Id(Integer faculty_Id) {
			this.f_Id = faculty_Id;
		}
		
		
		public Integer getF_AvailableLeaves() {
			return f_AvailableLeaves;
		}
		public void setF_AvailableLeaves(Integer f_AvailableLeaves) {
			this.f_AvailableLeaves = f_AvailableLeaves;
		}
		
		public Integer getF_PhoneNumber() {
			return f_PhoneNumber;
		}
		public void setF_PhoneNumber(Integer f_PhoneNumber) {
			this.f_PhoneNumber = f_PhoneNumber;
		}
		
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		 
		 public Faculty() {
			 
		 }
		 

}
