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
import com.example.miniproject.model.Faculty;
import com.example.miniproject.service.AddressService;
import com.example.miniproject.service.DepartmentService;
import com.example.miniproject.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	public FacultyService fservice;
	
	@Autowired
	public AddressService adservice;
	
	@Autowired
	public DepartmentService deptservice;
	
	@PostMapping("/addfaculty")
	public String addAll(@RequestBody List<Faculty> faculty) {
		fservice.addAll(faculty);
		return "faculty saved";
	}
	
	@PostMapping("/addaddress")
	public String saveAddress(@RequestBody Address address) {
		adservice.saveAddress(address);
		return "Address added";
	}
	
	@GetMapping("/getallfaculty")
	public List<Faculty> getAllFaculty() {
		return this.fservice.getAllFaculty();
	}
	
	@GetMapping("/getfacultybyid/{f_Id}")
	public  Faculty findByFacultyId(@PathVariable Integer f_Id) {
		return this.fservice.findByFacultyId(f_Id);
	}
	
	@DeleteMapping("/deleteFaculty/{f_Id}")
	public String deleteFaculty(@PathVariable Integer f_Id) {
		return "studentdeleted" +this.fservice.deleteFaculty(f_Id);
		}
	
	@PutMapping("/updatefacultyname/{f_Id}/{f_Name}")
	public  Faculty updateFacultyName(@PathVariable Integer f_Id, @PathVariable String f_Name) {
		return this.fservice.updateFacultyName(f_Name, f_Id);
	}
	
	@PutMapping("/updatefacultygender/{f_Id}/{f_Gender}")
	public  Faculty updateFacultyGender(@PathVariable  Integer f_Id, @PathVariable String f_Gender) {
		return this.fservice.updateFacultyGender(f_Id, f_Gender);
	}
	
//	@PutMapping("/updatefacultyleaves/{f_Id}/{f_AvailableLeaves}")
//	public  Faculty updateFacultytLeaves(@PathVariable  Integer f_Id, @PathVariable Integer f_AvailableLeaves) {
//		return this.fservice.updateFacultyLeaves(f_Id, f_AvailableLeaves);
//	}
	
	@PutMapping("/updatefacultyphonenumber/{f_Id}/{f_PhoneNumber}")
	public  Faculty updateFacultyPhoneNumber(@PathVariable  Integer f_Id, @PathVariable Integer f_PhoneNumber) {
		return this.fservice.updateFacultyPhoneNumber(f_Id, f_PhoneNumber);
	}
	
	@PutMapping("/updatefacultycity/{a_Id}/{city}")
	public String updateFacultyCity(@PathVariable Integer a_Id, @PathVariable String city) {
		return this.adservice.updateCity(a_Id, city);
	}
	
	@PutMapping("/updatefacultyline1/{a_Id}/{addressLine1}")
	public Address updateFacultyLine1(@PathVariable Integer a_Id, @PathVariable String addressLine1) {
		return this.adservice.updateLine1(a_Id, addressLine1);
	}
	
	@PutMapping("/updatefacultyline2/{a_Id}/{addressLine2}")
	public Address updateFacultyLine2(@PathVariable Integer a_Id, @PathVariable String addressLine2) {
		return adservice.updateLine2(a_Id, addressLine2);
	}
	
	@PutMapping("/updatefacultycountry/{a_Id}/{country}") 
	public Address updateFacultyCountry(@PathVariable Integer a_Id, @PathVariable String country) {
		return adservice.updateCountry(a_Id, country);
	}
	
	@PutMapping("/updatefacultypincode/{a_Id}/{pincode}")
	public Address updateFacultyPincode(@PathVariable Integer a_Id, @PathVariable Integer pincode) {
		return adservice.updatePincode(a_Id, pincode);
	}
	
	@PutMapping("/updatefacultyleaves/{f_Id}/{f_LeaveCount}")
	public String updateFacultyLeaves(@PathVariable Integer f_Id, @PathVariable int f_LeaveCount) {
		return fservice.updateFacultyLeaves(f_Id, f_LeaveCount);
	}
	
	@PutMapping("/facultyaddressenrolled/{f_Id}/{a_Id}")
	public String updateFacultyAddressWithId(@PathVariable Integer f_Id, @PathVariable Integer a_Id) {
		 fservice.updateFacultyAddressWithId(f_Id, a_Id);
		 return "faculty address enrolled";
	}

	 @PutMapping("/enrollfacultywithdept/{f_Id}/{d_Id}")
	    public String updateFacultyDept(@PathVariable Integer f_Id, @PathVariable Integer d_Id) {
	    	fservice.updateFacultyDept(f_Id, d_Id);
	    	return "department added to faculty";
	    }
	 
	 @GetMapping("/getdept")
		public List<Department> getAllDepartment()  {
			return (List<Department>) deptservice.getAllDepartment();
		}
}
