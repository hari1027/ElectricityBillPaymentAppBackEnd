package com.capgemini.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.capgemini.exception.IdAlreadyExistsException;
import com.capgemini.exception.NotFoundException;
import com.capgemini.modules.Customer;
import com.capgemini.repository.CustomerRepository;

@Service

public class CustomerService {
	
	
	@Autowired(required=true)
	public CustomerRepository repository;
	
   	
	
	public List<Customer> getAllCustomer(){
		return repository.findAll();
	}

	
	public void addCustomer( Customer e) throws Exception
	{
		if(!(e.userId >= 10000 && e.userId <= 99999))
		{
			throw new Exception("Invalid UserId, userId should be 5 digit");
		}
		if(!(String.valueOf(e.customerId).length() == 10))
		{
			throw new Exception("Invalid customerId, customerId should be 10 digit");
		}
		if(!(String.valueOf(e.aadharNumber).length() == 12))
		{
			throw new Exception("Invalid aadharNumber, aadharNumber should be 12 digit");
		}
		if(!(String.valueOf(e.mobileNumber).length() == 10))
		{
			throw new Exception("Invalid mobileNumber, mobileNumber should be 10 digit");
		}
		
		if(!e.gender.equalsIgnoreCase("Male") && !e.gender.equalsIgnoreCase("Female") && !e.gender.equalsIgnoreCase("Others"))
		{
			throw new Exception("Invalid gender");
		}
		
		
			Optional <Customer> exisitingCustomer=repository.findById(e.getCustomerId());
			{
			if(exisitingCustomer.isPresent()) {
				throw new IdAlreadyExistsException("Customer already exist with this Id!!");
			}
			 
			}
		
			Optional <Customer> existingEmail=repository.findByemail(e.getEmail());
			{
			   if(existingEmail.isPresent()) {
				    throw new IdAlreadyExistsException("Customer already exist with this Email!!");
				   
		          }	
			}
			
			Optional <Customer> existingAadhar=repository.findByaadharNumber(e.getAadharNumber());
			{
			   if(existingAadhar.isPresent()) {
				    throw new IdAlreadyExistsException("Customer already exist with this AadharNumber!!");
				   
		          }	
			}
			
			Optional <Customer> existingMobile=repository.findBymobileNumber(e.getMobileNumber());
			{
			   if(existingMobile.isPresent()) {
				    throw new IdAlreadyExistsException("Customer already exist with this MobileNumber!!");
				   
		          }	
			}
			
			Optional <Customer> existingUserId=repository.findByuserId(e.getUserId());
			{
			   if(existingUserId.isPresent()) {
				    throw new IdAlreadyExistsException("Customer already exist with this UserId!!");
				   
		          }	
			}
			   repository.save(e);
			   System.out.println("posted sucessfully");
			
	}

			
	public void updateCustomer(Long customerId,Customer e)
	{
		try {
		Customer e1 = repository.findById(customerId).get();
		if(e1 !=null)
		{
			repository.delete(e);	
			
			Optional <Customer> exisitingCustomer=repository.findById(e.getCustomerId());
			{
			if(exisitingCustomer.isPresent()) {
				throw new IdAlreadyExistsException("Customer already exist with this Id!!");
			}
			 
			}
			
			Optional <Customer> existingEmail=repository.findByemail(e.getEmail());
			{
			   if(existingEmail.isPresent()) {
				    throw new IdAlreadyExistsException("Customer already exist with this Email!!");
				   
		          }	
			}
			
			Optional <Customer> existingAadhar=repository.findByaadharNumber(e.getAadharNumber());
			{
			   if(existingAadhar.isPresent()) {
				    throw new IdAlreadyExistsException("Customer already exist with this AadharNumber!!");
				   
		          }	
			}
			
			Optional <Customer> existingMobile=repository.findBymobileNumber(e.getMobileNumber());
			{
			   if(existingMobile.isPresent()) {
				    throw new IdAlreadyExistsException("Customer already exist with this MobileNumber!!");
				   
		          }	
			}
			
			Optional <Customer> existingUserId=repository.findByuserId(e.getUserId());
			{
			   if(existingUserId.isPresent()) {
				    throw new IdAlreadyExistsException("Customer already exist with this UserId!!");
				   
		          }	
			}
			
	
			
			 repository.save(e1);
			 System.out.println("updated sucessfully");
		}
		
	}
		 catch (NoSuchElementException e1)
		  {
			 throw new NotFoundException ("The customerId you entered is not there in table .So updation is not possible");
				
		  }
	}
	
	public void deleteCustomer(Long customerId)
	{
		try {
	Customer e1 = repository.findById(customerId).get();
	
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
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ResponseEntity<Customer> searchCustomerById(Long customerId) throws NotFoundException{
		
		Customer c= repository.findById(customerId)
				.orElseThrow(()->new NotFoundException("customer id does not exists:"+customerId));
				
		
		return ResponseEntity.ok().body(c);
	}
	
    public List<Customer> searchCustomerByid(Long customerId) {
		
		return repository.searchCustomerById(customerId);
	}
	
	
	public ResponseEntity<Customer> searchCustomerByMobile(String mobileNumber) throws NotFoundException
	{
		Customer c1 = repository.findBymobileNumber(mobileNumber)
				.orElseThrow(()->new NotFoundException("mobileNumber does not exists:"+mobileNumber));
		
		return ResponseEntity.ok().body(c1);
		
	 }
	
    public List<Customer> searchCustomerBymobile(String mobileNumber) {
		
		return repository.searchCustomerByMobile(mobileNumber);
	}
	
	public ResponseEntity<Customer> SearchCustomerByAadhar(Long aadharNumber) throws NotFoundException
	{
		Customer c1 = repository.findByaadharNumber(aadharNumber)
				.orElseThrow(()->new NotFoundException("aadharNumber does not exists:"+aadharNumber));
		
		return ResponseEntity.ok().body(c1);	
	}
	
   public List<Customer> SearchCustomerByaadhar(Long aadharNumber) {
		
		return repository.SearchCustomerByAadhar(aadharNumber) ;
	}
	

	public List<Customer> SearchCustomerByName(String firstName) 
	{
		return repository.SearchCustomerByName(firstName);
    }
	
	
	public List<Customer> searchUserByUserName(String userName)
	{
		return repository.searchUserByUserName(userName);
	}
	

	public ResponseEntity<Customer> searchUserByUserId(Long userId) throws NotFoundException
	{
		Customer c1 = repository.findByuserId(userId)
				.orElseThrow(()->new NotFoundException("userId does not exists:"+userId));
		
		return ResponseEntity.ok().body(c1);
	}
	

	public List<Customer> searchUserByUserid(Long userId) {
		return repository.searchUserByUserId(userId);
	}
	
	
	public ResponseEntity<Customer> searchCustomerByEmail(String email) throws NotFoundException
	{
		Customer c1 = repository.findByemail(email)
				.orElseThrow(()->new NotFoundException("email does not exists:"+email));
		
		return ResponseEntity.ok().body(c1);
		
    }
	
     public List<Customer> searchCustomerByemail(String email) {
		
		return repository.searchCustomerByEmail(email);
	}


	public void updatepassword(Long customerId, Customer e) {
		Customer e1 = repository.findById(customerId).get();
		if(e1 !=null)
		{
			e1.setPassword(e.getPassword());
		}
		else
		{
			System.out.println("CustomerId you entered is not in table.So ResetPassword is not possible");
		}
		repository.save(e1);
		
	System.out.println("updated sucessfully");
		
	}




	


	


	
}
	
	


