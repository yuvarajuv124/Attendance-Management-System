package com.example.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniproject.model.Address;
import com.example.miniproject.model.Department;
import com.example.miniproject.model.Student;
import com.example.miniproject.service.AddressService;
import com.example.miniproject.service.DepartmentService;
import com.example.miniproject.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	public StudentService stservice;
	
	@Autowired
	public AddressService adservice;
	
	@Autowired
	public DepartmentService deptservice;
	
	@PostMapping("/addStudent")
	public String addAll(@RequestBody List<Student> student) {
		stservice.addAll(student);
		return "student saved";
	}
	
	@PostMapping("/addaddress")
	public String saveAddress(@RequestBody Address address) {
		adservice.saveAddress(address);
		return "Address added";
	}
	
	@GetMapping("/getallstudent")
	public List<Student> getAllStudents() {
		return this.stservice.getAllStudents();
	}
	
	@GetMapping("/getaddress")
	public List<Address> getAddress() {
		return adservice.getAddress();
	}
	
	@GetMapping("/getstudentbyid/{s_Id}")
	public Student findStudentById(@PathVariable Integer s_Id) {
		return this.stservice.findStudentById(s_Id);
	}
	
	@DeleteMapping("/deletestudent/{s_Id}")
	public String deleteStudent(@PathVariable Integer s_Id) {
		return "studentdeleted" +this.stservice.deleteStudent(s_Id);
		}
	
	@PutMapping("/updatestudentname/{s_Id}/{s_Name}")
	public Student updateStudentName(@PathVariable Integer s_Id, @PathVariable String s_Name) {
		return this.stservice.updateStudentName(s_Id, s_Name);
	}
	
	@PutMapping("/updatestudentgender/{s_Id}/{s_Gender}")
	public Student updateStudentGender(@PathVariable  Integer s_Id, @PathVariable String s_Gender) {
		return this.stservice.updateStudentGender(s_Id, s_Gender);
	}
 
	
	@PutMapping("/updatestudentphonenumber/{s_Id}/{s_PhoneNumber}")
	public Student updateStudentPhoneNumber(@PathVariable  Integer s_Id, @PathVariable Integer s_PhoneNumber) {
		return this.stservice.updateStudentPhoneNumber(s_Id, s_PhoneNumber);
	}
	
	 
	
	@PutMapping("/updatecity/{a_Id}/{city}")
	public String updateCity(@PathVariable Integer a_Id, @PathVariable String city) {
		return this.adservice.updateCity(a_Id, city);
	}
	
	@PutMapping("/updateline1/{a_Id}/{addressLine1}")
	public Address updateLine1(@PathVariable Integer a_Id,@PathVariable String addressLine1) {
		return this.adservice.updateLine1(a_Id, addressLine1);
	}
	
	@PutMapping("/updateline2/{a_Id}/{addressLine2}")
	public Address updateLine2(@PathVariable Integer a_Id, @PathVariable String addressLine2) {
		return this.adservice.updateLine2(a_Id, addressLine2);
	}
	
	@PutMapping("/updatecountry/{a_Id}/{country}") 
	public Address updateCountry(@PathVariable Integer a_Id, @PathVariable String country) {
		return this.adservice.updateCountry(a_Id, country);
	}
	
	@PutMapping("/updatepincode/{a_Id}/{pincode}")
	public Address updatePincode(@PathVariable Integer a_Id, @PathVariable Integer pincode) {
		return this.adservice.updatePincode(a_Id, pincode);
	}
	
	@PutMapping("/updateleaves/{s_Id}/{leavecount}")
	public String updateStudentLeaves(@PathVariable Integer s_Id, @PathVariable Integer leavecount) {
		return stservice.updateStudentLeaves(s_Id, leavecount);
	}
	
	@GetMapping("/getdept")
	public List<Department> getAllDepartment()  {
		return (List<Department>) deptservice.getAllDepartment();
	}
	
    @PutMapping("/enrollstudentwithdept/{s_Id}/{d_Id}")
    public String updateStudentWithDept(@PathVariable Integer s_Id, @PathVariable Integer d_Id) {
    	stservice.updateStudentDept(s_Id, d_Id);
    	return "department added to student";
    }
    
    @PutMapping("/enrollstudentwithaddress/{s_Id}/{a_Id}")
    public String updateStudentWithAddress(@PathVariable Integer s_Id, @PathVariable Integer a_Id) {
    	 stservice.updateStudentAddressWithId(s_Id, a_Id);
    	return "adress enrolled to student";
    }
    
    @PutMapping("/updatestudentleaves/{s_Id}/{s_LeaveCount}")
	public String updateFacultyLeaves(@PathVariable Integer s_Id, @PathVariable int s_LeaveCount) {
		return stservice.updateStudentLeaves(s_Id, s_LeaveCount);
	}
	
	
	 
}
