package com.example.miniproject.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniproject.exception.DepartmentNotFoundException;
import com.example.miniproject.exception.StudentNotFoundException;
import com.example.miniproject.model.Department;
import com.example.miniproject.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired 
	public DepartmentRepository deptRepo;
	
	public List<Department> DeptService() {
		List<Department> d_List = new ArrayList<Department>();
		d_List.add(new Department("Ece",101));
		d_List.add(new Department("Cse",102));
		d_List.add(new Department("It",103));
		d_List.add(new Department("Mechanical",104));
		d_List.add(new Department("Civil",105));
		d_List.add(new Department("EEE",106));
		d_List.add(new Department("IOT",107));
		d_List.add(new Department("AI",108));
		deptRepo.saveAll(d_List);
		 return d_List;
	}
	
	 
	
	public String saveDepartment(Department department) {
		try {
		 deptRepo.save(department);
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
		 return "department saved";
	}
	
	public List<Department> getAllDepartment() { 
		DeptService();
		try {
		return  (List<Department>) deptRepo.findAll();
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
		
	}
	
	public Department getByDepartmentId(Integer d_Id) {
		DeptService();
		try {
		return deptRepo.findById(d_Id).get();
		}
		catch (Exception e) {
			throw new DepartmentNotFoundException();
		}
   }
    
	 
	 
 
	

}
