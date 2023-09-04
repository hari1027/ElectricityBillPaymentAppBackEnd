package com.capgemini.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.modules.Customer;
import com.capgemini.services.CustomerService;

@RestController //(applied to class to mark it as request handler)
@RequestMapping("/cc") //(used to map HTTP requests to handler methods of MVC and restController)
public class CustomerController {
	
	@Autowired(required=true) //(automatically injects the dependent beans into the associated class
	CustomerService service;
	
	@CrossOrigin(origins = "*") //(to avoid cross origin error while connecting with front end)
	@RequestMapping(value="/customer",method=RequestMethod.GET)
	public List<Customer> getAllCustomer()
	{
		return  service.getAllCustomer();
	}
	
	

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/addcustomer",method=RequestMethod.POST)
	public void addCustomer( @RequestBody  Customer e) throws Exception 
	{
	     service.addCustomer(e);
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/update/{customerId}",method=RequestMethod.PUT)
	public void updateCustomer(@PathVariable Long customerId,@RequestBody Customer e)//(method parameter should be bound to URI template variable)
	{
		 service.updateCustomer(customerId,e);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/delete/{customerId}",method=RequestMethod.DELETE)
	public void  deleteCustomer(@PathVariable Long customerId) 
	{
		service.deleteCustomer(customerId);
	}
///////////////////////////////////////////////////
	
	
	
	
	@RequestMapping(value="/customerId/{customerId}",method=RequestMethod.GET)
	public ResponseEntity<Customer> searchCustomerById(@PathVariable Long customerId)
	{
		return service.searchCustomerById(customerId);
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/customerid/{customerId}",method=RequestMethod.GET)
	public List<Customer> searchCustomerByid(@PathVariable Long customerId)
	{
		return service.searchCustomerByid(customerId);
	}
	
	
	@RequestMapping(value="/Email/{email}",method=RequestMethod.GET)
	public ResponseEntity<Customer> searchCustomerByEmail(@PathVariable String email )
	{
		return service.searchCustomerByEmail(email);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/email/{email}",method=RequestMethod.GET)
	public List<Customer> searchCustomerByemail(@PathVariable String email )
	{
		return service.searchCustomerByemail(email);
	}
	
	
	@RequestMapping(value="/Mobilenumber/{mobileNumber}",method=RequestMethod.GET)
	public ResponseEntity<Customer> searchCustomerByMobile(@PathVariable String mobileNumber)
	{
		return service.searchCustomerByMobile(mobileNumber);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/mobilenumber/{mobileNumber}",method=RequestMethod.GET)
	public List<Customer> searchCustomerBymobile(@PathVariable String mobileNumber)
	{
		return service.searchCustomerBymobile(mobileNumber);
	}
	
	
    @RequestMapping(value="/Aadharnumber/{aadharNumber}",method=RequestMethod.GET)
	public ResponseEntity<Customer> SearchCustomerByAadhar(@PathVariable Long aadharNumber)
	{
		return service.SearchCustomerByAadhar(aadharNumber);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/aadharnumber/{aadharNumber}",method=RequestMethod.GET)
	public List<Customer> SearchCustomerByaadhar(@PathVariable Long aadharNumber)
	{
		return service.SearchCustomerByaadhar(aadharNumber);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/firstname/{firstName}",method=RequestMethod.GET)
	public List<Customer> SearchCustomerByName(@PathVariable String firstName)
	{
		return service.SearchCustomerByName(firstName);
	}
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/username/{userName}",method=RequestMethod.GET)
	public List<Customer> searchUserByUserName(@PathVariable String userName)
	{
		return service.searchUserByUserName(userName);
	}
	
	
	@RequestMapping(value="/userId/{userId}",method=RequestMethod.GET)
	public ResponseEntity<Customer> searchUserByUserId(@PathVariable Long userId)
	{
		return service.searchUserByUserId(userId);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/userid/{userId}",method=RequestMethod.GET)
	public List<Customer> searchUserByUserid(@PathVariable Long userId)
	{
		return service.searchUserByUserid(userId);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/updatepassword/{customerId}",method=RequestMethod.PUT)
	public void updatePassword(@PathVariable Long customerId,@RequestBody Customer e)
	{
		 service.updatepassword(customerId,e);
	}
	


	
	
	
		
	
	
	
	

	
}
