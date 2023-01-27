package com.example.miniproject.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.example.miniproject.model.Faculty;
import com.example.miniproject.repository.FacultyRepository;


class FacultyServiceTest {

	@Mock
	FacultyRepository fr;
	
	@InjectMocks
	FacultyService fs;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	Optional<Faculty> faculty = Optional.of(new Faculty());
	
	@Test
	void saveFacultyTest() {
		Faculty faculty = new Faculty();
		Mockito.when(fr.save(faculty)).thenReturn(faculty);
		assertEquals(faculty,fs.saveFaculty(faculty));
	}
	
	@Test
	void addAllTest() {
		List<Faculty> faculty = new ArrayList<Faculty>();
		Mockito.when(fr.saveAll(faculty)).thenReturn(faculty);
		assertEquals(faculty,fs.addAll(faculty));
	}
	
	@Test
	void getAllFacultyTest() {
		List<Faculty> faculty = new ArrayList<Faculty>();
		Mockito.when(fr.findAll()).thenReturn(faculty);
		assertEquals(faculty,fs.getAllFaculty());
	}
	
	@Test
	void findByFacultyIdTest() {
		Mockito.when(fr.findById(faculty.get().getFaculty_Id())).thenReturn(faculty);
		assertEquals(faculty,Optional.of(fs.findByFacultyId(faculty.get().getFaculty_Id())));
	}
	
	@Test
	void deleteFacultyTest() {
		Mockito.when(fr.findById(faculty.get().getFaculty_Id())).thenReturn(faculty);
		fs.deleteFaculty(faculty.get().getFaculty_Id());
		verify(fr,atLeast(1)).deleteById(faculty.get().getFaculty_Id());
	}
	
	@Test
	void updateFacultyNameTest() {
		Mockito.when(fr.findById(faculty.get().getFaculty_Id())).thenReturn(faculty);
		assertEquals(faculty,Optional.of(fs.updateFacultyName(faculty.get().getF_Name(), faculty.get().getFaculty_Id())));
	}
	
	@Test
	void updateFacultyGenderTest() {
		Mockito.when(fr.findById(faculty.get().getFaculty_Id())).thenReturn(faculty);
		assertEquals(faculty,Optional.of(fs.updateFacultyGender(faculty.get().getFaculty_Id(), faculty.get().getF_Gender())));
	}

	@Test
	void updateFacultyPhoneNumberTest() {
		Mockito.when(fr.findById(faculty.get().getFaculty_Id())).thenReturn(faculty);
		assertEquals(faculty,Optional.of(fs.updateFacultyPhoneNumber(faculty.get().getFaculty_Id(), faculty.get().getF_PhoneNumber())));
	}
	
	@Test
	void updateFacultyLeavesTest() {
		Mockito.when(fr.findById(faculty.get().getFaculty_Id())).thenReturn(faculty);
		//verify(fr,atLeast(1)).findById(faculty.get().getFaculty_Id());
		assertEquals("Faculty leaves updated",fs.updateFacultyLeaves(faculty.get().getFaculty_Id(), faculty.get().getF_AvailableLeaves()));
	}
	
	
	
}
