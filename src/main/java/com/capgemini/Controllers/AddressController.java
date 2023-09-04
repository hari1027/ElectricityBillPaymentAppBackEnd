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

import com.capgemini.exception.NotFoundException;
import com.capgemini.modules.Address;
import com.capgemini.services.AddressService;

@RestController
@RequestMapping("/ac")
public class AddressController {
	
	@Autowired(required=true)
	AddressService service;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/address",method=RequestMethod.GET)
	public List<Address> getAllAddress()
	{
		return  service.getAllAddress();
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/addaddress",method=RequestMethod.POST)
	public  void addAddress( @RequestBody  Address e) throws Exception
	{
		 service.addAddress(e);
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/update/{addressId}",method=RequestMethod.PUT)
	public void updateAddress(@PathVariable Long addressId,@RequestBody Address e)
	{
		 service.updateAddress(addressId,e);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/delete/{addressId}",method=RequestMethod.DELETE)
	public void  deleteAddress(@PathVariable Long addressId)
	{
		service.deleteAddress(addressId);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////

	@CrossOrigin(origins = "*")
@RequestMapping(value="/addressid/{addressId}",method=RequestMethod.GET)
public ResponseEntity<Address> getAddressById(@PathVariable Long addressId) throws NotFoundException{
	return service.getAddressById(addressId);
  }
}

	