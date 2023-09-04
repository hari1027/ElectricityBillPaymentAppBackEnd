package com.capgemini.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.capgemini.exception.IdAlreadyExistsException;
import com.capgemini.exception.NotFoundException;
import com.capgemini.modules.Address;
import com.capgemini.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired(required=true)
	AddressRepository repository;
	
	public List<Address> getAllAddress(){
		return repository.findAll();
	}
	
	public void addAddress( Address e) throws Exception
	{
		if(!(e.addressId >= 100000 && e.addressId <= 999999))
		{
			throw new Exception("Invalid addressId, addressId should be 6 digit");
		}
		
		if(!(e.flatOrHouseNumber > 0 && e.flatOrHouseNumber < 1000))
		{
			throw new Exception("Invalid flatOrHouseNumber, flatOrHouseNumber should be less than 1000");
		}
		
		Optional<Address> exisitingAddress=repository.findById(e.getAddressId());
		if(exisitingAddress.isPresent()) 
		{
			 throw new IdAlreadyExistsException("Address already exist with this Id!!");
		}
			 repository.save(e);
			 System.out.println("posted sucessfully");
		}
		
	public void updateAddress(Long addressId,Address e)
	{
		try {
		Address e1 = repository.findById(addressId).get();
		if(e1 !=null)
		{
			repository.delete(e);
			
			Optional<Address> exisitingAddress=repository.findById(e.getAddressId());
			if(exisitingAddress.isPresent()) 
			{
				 throw new IdAlreadyExistsException("Address already exist with this Id!!");
			}
			
		    repository.save(e1);
		    System.out.println("Updated sucessfully");
		}
		
	}
		 catch (NoSuchElementException e1)
		  {
			 throw new NotFoundException ("The addressId you entered is not there in table .So updation is not possible");
				
		  }
	}

	
	public void deleteAddress(long addressId)
	{
		try {
	Address e1 = repository.findById(addressId).get();
	
	if(e1 !=null)
	{
		repository.delete(e1);
	    System.out.println("deletion sucessfull");
	}
		}
	
	catch(NoSuchElementException e1)
	  {
		 throw new NotFoundException ("The customerId you entered is not there in table .So deletion is not possible");
			
	  }
	}

//////////////////////////////////////////////////////////////////////////////////////////////
	
	public ResponseEntity<Address> getAddressById(long addressId)throws NotFoundException{
		
		Address ad= repository.findById(addressId)
				.orElseThrow(()->new NotFoundException("address id does not exists:"+addressId));
		return ResponseEntity.ok().body(ad);
	}
}