package com.example.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniproject.exception.InsufficientLeaveBalanceException;
import com.example.miniproject.exception.InvalidNameException;
import com.example.miniproject.exception.NameCannotBeNullException;
import com.example.miniproject.exception.NumberCantBeNegativeException;
import com.example.miniproject.exception.NumberCantBeNullException;
import com.example.miniproject.exception.StudentNotFoundException;
import com.example.miniproject.model.Address;
import com.example.miniproject.model.Department;
import com.example.miniproject.model.Student;
import com.example.miniproject.repository.StudentRepository;

@Service
public class StudentService {
	 
	
	
	@Autowired
	public StudentRepository repository;
	
	@Autowired
	public AddressService adservice;
	
	@Autowired 
	public DepartmentService deptservice;
	 
	
	public Student saveStudent(Student student) {

		try {
		 return repository.save(student);
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
	}
	
	public Iterable<Student> addAll(List<Student> student)   {
		
		List<Student> studentList = student;
		
		for(Student std:studentList) {
		     
			try {
			if(std.getS_Name().isBlank()) {
			throw new InvalidNameException();
		}
			}
			catch (NullPointerException e) {
				throw new NameCannotBeNullException();
			}
			
		if(!Character.isLetter(std.getS_Name().charAt(0))) {
			throw new InvalidNameException();
		}
		
		for(int index = 0; index < std.getS_Name().length(); index++) {
			
			if(!(Character.isLetter(std.getS_Name().charAt(index))) || Character.isWhitespace(std.getS_Name().charAt(index))) {
				throw new InvalidNameException();
			}
		}
		try {
			if(std.getS_Gender().isBlank()) {
				throw new InvalidNameException();
			}
		}
		catch (NullPointerException e) {
			throw new NameCannotBeNullException();
		}
		
		try {
			if(std.getS_PhoneNumber()==null) {
				throw new NumberCantBeNullException();
			}
		}
			catch(Exception e) {
				 throw new NumberCantBeNullException();
			}
		 
			if(std.getS_PhoneNumber()<=0) {
				throw new NumberCantBeNegativeException();
		}
		}
		 
		try {
		return repository.saveAll(student);
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
	}
	
	public List<Student> getAllStudents() {
		List<Student> s_List = (List<Student>) repository.findAll();
		return s_List;
	}
	
	public Student findStudentById(Integer s_Id) {
		try {
		return repository.findById(s_Id).get();
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
	}
	
	public String deleteStudent(Integer s_Id) {
		Student student = findStudentById(s_Id);
		try {
		repository.deleteById(s_Id);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return "student deleted";
	}
	
	public Student updateStudentName(Integer s_Id, String s_Name) {
		Student student = findStudentById(s_Id);
		student.setS_Name(s_Name);
		try {
		repository.save(student);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return student;
	}
	
	public Student updateStudentGender(Integer s_Id, String s_Gender) {
		Student student = findStudentById(s_Id);
		student.setS_Gender(s_Gender);
		try {
		repository.save(student);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return student;
		 
	}
	
//	public Student updateStudentLeaves(Integer s_Id, Integer s_AvailableLeaves) {
//		Student student = findStudentById(s_Id);
//		if(student==null) {
//			return null;
//		}
//		student.setS_AvailableLeaves(s_AvailableLeaves);
//		repository.save(student);
//		return student;
//		 
//	}
	
	public Student updateStudentPhoneNumber(Integer s_Id, Integer s_PhoneNumber) {
		Student student = findStudentById(s_Id);
		student.setS_PhoneNumber(s_PhoneNumber);
		try {
		repository.save(student);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return student;
		 
	}
	
	public List<Address> getStudentAddress() {
		List<Address> a_List = (List<Address>) adservice.getAddress();
		return a_List;
	}
	
	public String updateStudentAddress(Integer a_Id, String city, String addressLine1,String addressLine2,
			String country,Integer pincode    ) {
		 adservice.findByAddressId(a_Id);
		 adservice.updateCity(a_Id, city);
		 adservice.updateLine1(a_Id, addressLine1);
		 adservice.updateLine2(a_Id, addressLine2);
		 adservice.updateCountry(a_Id, country);
		 adservice.updatePincode(a_Id, pincode);
		 //adservice.saveAddress(address);
		 //repository.saveAll(address);
		 return "student address updated";
		 
	}
	
	public String updateStudentLeaves(Integer s_Id, Integer leaveCount)  {
		Student student = findStudentById(s_Id);
		int leaves = student.getS_AvailableLeaves();
		if(leaveCount<0) {
			throw new NumberCantBeNegativeException();
		}
		if(leaveCount<=leaves) {
			leaves = leaves-leaveCount;
			student.setS_AvailableLeaves(leaves);
			try {
			repository.save(student);
			}
			catch (Exception e) {
				System.out.println("Exception" +e);
			}
		}
		else {
			throw  new InsufficientLeaveBalanceException();
		}
		return "leave granted";
	}
	
	 
	public void  updateStudentDept(Integer s_Id, Integer d_Id)      {
		Student student = findStudentById(s_Id);
        Department dept = deptservice.getByDepartmentId(d_Id);
        student.setDepartment(dept);
        try { 
        repository.save(student);
        }
        catch (Exception e) {
			System.out.println("Exception" +e);
		}
    }
	
	public void updateStudentAddressWithId(Integer s_Id, Integer a_Id) {
		Student student = findStudentById(s_Id);
		Address address = adservice.findByAddressId(a_Id);
		student.setAddress(address);
		try {
		repository.save(student);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		}
}



