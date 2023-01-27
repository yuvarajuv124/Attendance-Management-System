package com.example.miniproject.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.miniproject.model.Address;
import com.example.miniproject.model.Department;
import com.example.miniproject.model.Student;
import com.example.miniproject.repository.AddressRepository;
import com.example.miniproject.repository.DepartmentRepository;
import com.example.miniproject.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
 public class StudentServiceTest {

	@InjectMocks
	StudentService ss;
	
	@Mock
	StudentRepository sr;
	
	@Mock
	AddressRepository ar;
	
	@Mock
	DepartmentRepository dr;
	
	@InjectMocks
	AddressService as;
	
	@InjectMocks
	DepartmentService ds;
	
	Optional<Student> student = Optional.of(new Student());

	@Test
	void saveStudentTest() {
		Student student = new Student();
		Mockito.when(sr.save(student)).thenReturn(student);
		assertEquals(student,ss.saveStudent(student));
	}
	
	@Test
	void addAllTest() {
		List<Student> student = new ArrayList<Student>();
		Mockito.when(sr.saveAll(student)).thenReturn(student);
		assertEquals(student,ss.addAll(student));
	}
	
	@Test
	void getAllStudentsTest() {
		List<Student> student = new ArrayList<Student>();
		Mockito.when(sr.findAll()).thenReturn(student);
		assertEquals(student,ss.getAllStudents());
	}
	
	@Test
	void findStudentByIdTest() {
		//Optional<Student> student = Optional.of(new Student());
		Mockito.when(sr.findById(student.get().getS_Id())).thenReturn(student);
		assertEquals(student,Optional.of(ss.findStudentById(student.get().getS_Id())));
	}
	
	@Test
	void deleteStudentTest() {
		Mockito.when(sr.findById(student.get().getS_Id())).thenReturn(student);
		ss.deleteStudent(student.get().getS_Id());
		verify(sr,atLeast(1)).deleteById(student.get().getS_Id());
	}
	
	
	@Test
	void updateStudentNameTest() {
		Mockito.when(sr.findById(student.get().getS_Id())).thenReturn(student);
		assertEquals(student,Optional.of(ss.updateStudentName(student.get().getS_Id(), student.get().getS_Name())));
	}
	
	@Test
	void updateStudentGenderTest() {
		Mockito.when(sr.findById(student.get().getS_Id())).thenReturn(student);
		assertEquals(student,Optional.of(ss.updateStudentGender(student.get().getS_Id(), student.get().getS_Gender())));
	}

	@Test
	void updateStudentPhoneNumberTest() {
		Mockito.when(sr.findById(student.get().getS_Id())).thenReturn(student);
		assertEquals(student,Optional.of(ss.updateStudentPhoneNumber(student.get().getS_Id(), student.get().getS_PhoneNumber())));
	}
	
	@Test
	void getStudentAddressTest() {
		List<Address> a_List = new ArrayList<Address>();
		Mockito.when(ar.findAll()).thenReturn(a_List);
		assertEquals(a_List,as.getAddress());
	}
	
	@Test
	void updateStudentLeavesTest() {
		Mockito.when(sr.findById(student.get().getS_Id())).thenReturn(student);
		//assertEquals(student,Optional.of(ss.updateStudentLeaves(student.get().getS_Id(), student.get().getS_AvailableLeaves())));
	    ss.updateStudentLeaves(student.get().getS_Id(), student.get().getS_AvailableLeaves());
		verify(sr,times(1)).findById(student.get().getS_Id());
	}
	
	
//	@Test
//	void updateStudentDeptTest() {
//		 Department dept = new Department();
//		 List<Department> dept1 = ds.getAllDepartment();
//		Mockito.when(sr.findById(student.get().getS_Id())).thenReturn(student);
//		Mockito.when(dr.findById(dept.getD_Id())).thenReturn(dept1);
//		ss.updateStudentDept(student.get().getS_Id(),dept1);
//		verify(sr,times(1)).findById(student.get().getS_Id());
//	}
//	
}


