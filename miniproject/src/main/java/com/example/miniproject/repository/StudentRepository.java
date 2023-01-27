package com.example.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.miniproject.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

	 
	
//	public List<Student> getAllStudents();
//	public void saveStudent(Student student);
//	public Student findStudentById(int s_Id);
//	public String deleteStudent(int s_Id );
 //   public Student updateByStudentName(String s_Name);
//	public Student updateStudentGender(String s_Gender);
//	public Student updateStudentLeaves(int s_AvailableLeaves);
//	public Student updateStudentPhoneNumber(int s_PhoneNumber);
//	public String updateDepartment(Department department);
//	public String updateAddress(Address address);
}
