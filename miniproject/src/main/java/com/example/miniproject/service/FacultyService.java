package com.example.miniproject.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniproject.exception.FacultyNotFoundException;
import com.example.miniproject.exception.InsufficientLeaveBalanceException;
import com.example.miniproject.exception.InvalidNameException;
import com.example.miniproject.exception.NameCannotBeNullException;
import com.example.miniproject.exception.NumberCantBeNegativeException;
import com.example.miniproject.exception.NumberCantBeNullException;
import com.example.miniproject.model.Address;
import com.example.miniproject.model.Department;
import com.example.miniproject.model.Faculty;
import com.example.miniproject.repository.DepartmentRepository;
import com.example.miniproject.repository.FacultyRepository;

@Service
public class FacultyService {
	
	List<Faculty> f_List =  new ArrayList<Faculty>();
	
	@Autowired
    public FacultyRepository f_Repo;
	
	@Autowired
	public AddressService adservice;
	
	@Autowired
	public DepartmentService deptservice;
	
	@Autowired
	public DepartmentRepository d_Repo;
	
	public Faculty saveFaculty( Faculty faculty) {
		
		try {
		f_Repo.save(faculty);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return faculty;
	}
	
	public List<Faculty> addAll(List<Faculty> faculty) {
		List<Faculty> facultyList = faculty;
		
		for(Faculty fac : facultyList) {
			try {
				if(fac.getF_Name().isBlank()) {
					throw new InvalidNameException();
				}
			}
			catch (Exception e) {
				throw new NameCannotBeNullException();
			}
			if(!Character.isLetter(fac.getF_Name().charAt(0))) {
				throw new InvalidNameException();
			}
			
			for(int index = 0; index < fac.getF_Name().length(); index++) {
				
				if(!(Character.isLetter(fac.getF_Name().charAt(index))) || Character.isWhitespace(fac.getF_Name().charAt(index))) {
					throw new InvalidNameException();
				}
			}
			
			try {
				if(fac.getF_Gender().isBlank()) {
					throw new InvalidNameException();
				}
			}
			catch (Exception e) {
				throw new NameCannotBeNullException();
			}
			try {
				if(fac.getF_PhoneNumber()==null) {
					throw new NumberCantBeNullException();
				}
			}
			catch (Exception e) {
				throw new NumberCantBeNullException();
			}
			if(fac.getF_PhoneNumber()<0) {
				throw new NumberCantBeNegativeException();
			}
			
		}
		try {
			f_Repo.saveAll(faculty);
		}
		catch (Exception e) {
			throw new FacultyNotFoundException();
		}
		return facultyList;
	}
	
	public List<Faculty> getAllFaculty() {
		try {
		List<Faculty> f_List = (List<Faculty>) f_Repo.findAll();
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return f_List;
		}
	
	public  Faculty findByFacultyId(Integer f_Id) {
		try {
		  return f_Repo.findById(f_Id).get();
		}
		catch (Exception e) {
			throw new FacultyNotFoundException();
		}
	}
	
	public String deleteFaculty(Integer f_Id ) {
		Faculty faculty = findByFacultyId(f_Id);
		try {
		 f_Repo.deleteById(f_Id);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		 return "faculty deleted";
	}
	
	public Faculty updateFacultyName(String f_Name, Integer f_Id) {
		Faculty faculty = findByFacultyId(f_Id);
		faculty.setF_Name(f_Name);
		try {
		f_Repo.save(faculty);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return faculty;
		 
	}
	
	public  Faculty updateFacultyGender(Integer f_Id, String f_Gender) {
		 Faculty faculty = findByFacultyId(f_Id);
		faculty.setF_Gender(f_Gender);
		try {
		f_Repo.save(faculty);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return faculty;
		 
	}
	
	
	public  Faculty updateFacultyPhoneNumber(Integer f_Id, Integer f_PhoneNumber) {
		 Faculty faculty = findByFacultyId(f_Id);
		faculty.setF_PhoneNumber(f_PhoneNumber);
		try {
		f_Repo.save(faculty);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
		return faculty;
		 
	}
	
	public List<Address> getFacultyAddress() {
		List<Address> a_List = adservice.getAddress();
		return a_List;
	}
	
	public String updateFacultyAddress(Integer a_Id, String city, String addressLine1, String addressLine2,String country,
			Integer pincode) {
		adservice.findByAddressId(a_Id);
		adservice.updateCity(a_Id, city);
		adservice.updateLine1(a_Id, addressLine1);
		adservice.updateLine1(a_Id, addressLine1);
		adservice.updateCountry(a_Id, country);
		adservice.updatePincode(a_Id, pincode);
		return "faculty address updated";
	}
 
	public String updateFacultyLeaves(Integer f_Id, Integer f_LeaveCount) {
		Faculty faculty = findByFacultyId(f_Id);
		int f_Leaves = faculty.getF_AvailableLeaves();
		if(f_LeaveCount<0) {
			throw new NumberCantBeNegativeException();
		}
		if(f_LeaveCount<=f_Leaves) {
			f_Leaves = f_Leaves - f_LeaveCount;
			faculty.setF_AvailableLeaves(f_Leaves);
			try {
			f_Repo.save(faculty);
			}
			catch (Exception e) {
				System.out.println("Exception" +e);
			}
		}
		else {
			throw new InsufficientLeaveBalanceException();
		}
		return "Faculty leaves updated";
	}
	
	public void updateFacultyAddressWithId(Integer f_Id, Integer a_Id) {
		Faculty faculty = findByFacultyId(f_Id);
		Address address = adservice.findByAddressId(a_Id);
		faculty.setAddress(address);
		try {
		f_Repo.save(faculty);
		}
		catch (Exception e) {
			System.out.println("Exception" +e);
		}
	}
 
	 
		public void  updateFacultyDept(Integer f_Id, Integer d_Id)      {
			Faculty faculty = findByFacultyId(f_Id);
	        Department dept = deptservice.getByDepartmentId(d_Id);
	        faculty.setDepartment(dept);
	        try {
	        f_Repo.save(faculty);
	        }
	        catch (Exception e) {
				System.out.println("Exception" +e);
			}
	        
		}

}
