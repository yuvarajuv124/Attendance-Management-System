package com.example.miniproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionControllerClass {
	
	@ExceptionHandler(value=InsufficientLeaveBalanceException.class)
	public ResponseEntity<Object> exception(InsufficientLeaveBalanceException exception) {
		return new ResponseEntity<>("Leaves cannot be granted due to insufficient leave balance", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<Object> exception(StudentNotFoundException exception) {
		return new ResponseEntity<>("student not found",HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=DepartmentNotFoundException.class)
	public ResponseEntity<Object> exception(DepartmentNotFoundException exception) {
     return new ResponseEntity<>("department not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=AddressNotFoundException.class)
	public ResponseEntity<Object> exception(AddressNotFoundException exception) {
		return new ResponseEntity<>("address not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=FacultyNotFoundException.class)
	public ResponseEntity<Object> exception(FacultyNotFoundException exception) {
		return new ResponseEntity<>("faculty not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidNameException.class)
	public ResponseEntity<Object> exception(InvalidNameException exception) {
		return new ResponseEntity<>("name/gender is invalid",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidCountryException.class) 
	public ResponseEntity<Object> exception(InvalidCountryException exception) {
		return new ResponseEntity<>("country name is invalid",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidAddressLineException.class) 
	public ResponseEntity<Object> exception(InvalidAddressLineException exception) {
		return new ResponseEntity<>("address line is invalid",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=NameCannotBeNullException.class) 
	public ResponseEntity<Object> exception(NameCannotBeNullException exception) {
		return new ResponseEntity<>("name/gender cannot be null",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=AddressLineCantBeNullException.class) 
	public ResponseEntity<Object> exception(AddressLineCantBeNullException exception) {
		return new ResponseEntity<>("address line cannot be null",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidCityException.class) 
	public ResponseEntity<Object> exception(InvalidCityException exception) {
		return new ResponseEntity<>("city name is invalid",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=CityNameCantBeNullException.class) 
	public ResponseEntity<Object> exception(CityNameCantBeNullException exception) {
		return new ResponseEntity<>("city name cant be null",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidPincodeException.class) 
	public ResponseEntity<Object> exception(InvalidPincodeException exception) {
		return new ResponseEntity<>("pioncode cant be null",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=NumberCantBeNegativeException.class) 
	public ResponseEntity<Object> exception(NumberCantBeNegativeException exception) {
		return new ResponseEntity<>("number cant be negative",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=NumberCantBeNullException.class) 
	public ResponseEntity<Object> exception(NumberCantBeNullException exception) {
		return new ResponseEntity<>("number cant be null",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=CountryCantBeNullException.class) 
	public ResponseEntity<Object> exception(CountryCantBeNullException exception) {
		return new ResponseEntity<>("country name cant be null",HttpStatus.NOT_FOUND);
	}
	
	
	
}