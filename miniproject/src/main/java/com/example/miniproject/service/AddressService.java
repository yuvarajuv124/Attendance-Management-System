package com.example.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniproject.exception.AddressLineCantBeNullException;
import com.example.miniproject.exception.AddressNotFoundException;
import com.example.miniproject.exception.CityNameCantBeNullException;
import com.example.miniproject.exception.CountryCantBeNullException;
import com.example.miniproject.exception.InvalidAddressLineException;
import com.example.miniproject.exception.InvalidCityException;
import com.example.miniproject.exception.InvalidCountryException;
import com.example.miniproject.exception.InvalidPincodeException;
import com.example.miniproject.exception.NameCannotBeNullException;
import com.example.miniproject.exception.NumberCantBeNegativeException;
import com.example.miniproject.exception.StudentNotFoundException;
import com.example.miniproject.model.Address;
import com.example.miniproject.repository.AddressRepository;

@Service
public class AddressService {
 
	
	@Autowired
	public AddressRepository addressrepo;
	
	 
	
	public void saveAddress(Address address) {
		try {
		if(address.getCountry().isBlank()) {
			throw new InvalidCountryException();
		}
		}
		catch (NullPointerException e) {
			throw new CountryCantBeNullException();
		}
		 
		try {
		if(address.getAddressLine1().isBlank()) {
			throw new InvalidAddressLineException();
		}
		if(address.getAddressLine2().isBlank()) {
			throw new InvalidAddressLineException();
		}
		}
		catch (NullPointerException e) {
			throw new AddressLineCantBeNullException();
		}
		
		try {
			 if(address.getCity().isBlank()) {
				 throw new InvalidCityException();
			 }
		}
		catch (NullPointerException e) {
			throw new CityNameCantBeNullException();
		}
		try {
			 if(address.getPincode()==null) {
				 throw new InvalidPincodeException();
			 }
		}
		catch (Exception e) {
			throw new InvalidPincodeException();
		}
			if(address.getPincode()<=0) {
				throw new NumberCantBeNegativeException();
		}
		
		try {
		addressrepo.save(address);
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
	}
	
	public List<Address> getAddress() {
		List<Address> a_List=   (List<Address>) addressrepo.findAll();
		return a_List;
	}
	
	public Address findByAddressId(Integer a_Id) {
		try {
		return addressrepo.findById(a_Id).get();
		}
		catch (Exception e) {
			throw new AddressNotFoundException();
		}
	}
	 
	
	 

	public String updateCity(Integer a_Id,String city) {
		Address address = findByAddressId(a_Id);
		 address.setCity(city);
		 try {
		 addressrepo.save(address);
		 }
		 catch (Exception e) {
				throw new StudentNotFoundException();
			}
		 return "address/city updated";
	}
	
	public Address updateLine1(Integer a_Id, String addressLine1) {
		Address address = findByAddressId(a_Id);
		address.setAddressLine1(addressLine1);
		try {
		addressrepo.save(address);
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
		return address;
	}
	
	public Address updateLine2(Integer a_Id, String addressLine2) {
		Address address = findByAddressId(a_Id);
		address.setAddressLine2(addressLine2);
		addressrepo.save(address);
		return address;
	}
	
	public Address updateCountry(Integer a_Id, String country) {
		Address address = findByAddressId(a_Id);
		address.setCountry(country);
		try {
		addressrepo.save(address);
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
		return address;
	}
	
	public Address updatePincode(Integer a_Id, Integer pincode) {
		Address address = findByAddressId(a_Id);
		address.setPincode(pincode);
		try {
		addressrepo.save(address);
		}
		catch (Exception e) {
			throw new StudentNotFoundException();
		}
		return address;
	}
}

	 
