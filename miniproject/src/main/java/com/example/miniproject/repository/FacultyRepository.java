package com.example.miniproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.miniproject.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty,Integer> {
	 
//	public List<Faculty> getAllFaculty();
//	public void saveFaculty(Faculty faculty);
//	public Student findFacultyByName(String f_Name);
//	public String deleteFaculty(String f_Name );
//	public Student updateFacultyName(String f_Name);
//	public Student updateFacultyGender(String f_Gender);
//	public Student updateFacultyLeaves(int f_AvailableLeaves);
//	public Student updateFacultyPhoneNumber(int f_PhoneNumber);
//	public String updateDepartment(Department department);
//	public String updateAddress(Address address);
	

}
