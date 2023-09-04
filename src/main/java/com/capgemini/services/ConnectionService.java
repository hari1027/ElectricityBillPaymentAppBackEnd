package com.capgemini.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.capgemini.exception.IdAlreadyExistsException;
import com.capgemini.exception.NotFoundException;
import com.capgemini.modules.Connection;
import com.capgemini.repository.ConnectionRepository;

@Service

public class ConnectionService {
	
	@Autowired(required=true)
	ConnectionRepository repository;
	
	
	
	public List<Connection> getAllConnection(){
		return repository.findAll();
	}

	
	public void addConnection( Connection e) throws Exception
	{
		if(!(e.connectionId >= 10000 && e.connectionId <= 99999))
		{
			throw new Exception("Invalid connectionId, connectionId should be 5 digit");
		}
		
		if(!(e.consumerNumber >= 10000 && e.consumerNumber <= 99999))
		{
			throw new Exception("Invalid consumerNumber, consumerNumber should be 5 digit");
		}
		
		Optional<Connection> exisitingConnection=repository.findById(e.getConnectionId());
		if(exisitingConnection.isPresent()) 
		{
			throw new IdAlreadyExistsException("Connection already exist with this Id!!");
		}
		
		Optional<Connection> exisitingConsumer=repository.findByconsumer(e.getConsumerNumber());
		if(exisitingConsumer.isPresent()) 
		{
			throw new IdAlreadyExistsException("Connection already exist with this consumerNumber!!");
		}
		
		Optional<Connection> exisitingCustomer=repository.findBycustomer(e.getCustomerConnection());
		if(exisitingCustomer.isPresent()) 
		{
			throw new IdAlreadyExistsException("Connection already exist with this customerId!!");
		}
		
		Optional<Connection> exisitingAddress=repository.findByaddress(e.getConnectionAddress());
		if(exisitingAddress.isPresent()) 
		{
			throw new IdAlreadyExistsException("Connection already exist with this addressId!!");
		}
		
		
		 repository.save(e);
		 System.out.println("posted sucessfully");
	}


	public void updateConnection(Long connectionId,Connection e)
	{
		try {
		Connection e1 = repository.findById(connectionId).get();
		if(e1 !=null)
		{
			repository.delete(e);
			
			Optional<Connection> exisitingConnection=repository.findById(e.getConnectionId());
			if(exisitingConnection.isPresent()) 
			{
				throw new IdAlreadyExistsException("Connection already exist with this Id!!");
			}
			
			Optional<Connection> exisitingConsumer=repository.findByconsumer(e.getConsumerNumber());
			if(exisitingConsumer.isPresent()) 
			{
				throw new IdAlreadyExistsException("Connection already exist with this consumerNumber!!");
			}
			
			Optional<Connection> exisitingCustomer=repository.findBycustomer(e.getCustomerConnection());
			if(exisitingCustomer.isPresent()) 
			{
				throw new IdAlreadyExistsException("Connection already exist with this customerId!!");
			}
			
			Optional<Connection> exisitingAddress=repository.findByaddress(e.getConnectionAddress());
			if(exisitingAddress.isPresent()) 
			{
				throw new IdAlreadyExistsException("Connection already exist with this addressId!!");
			}
			
			repository.save(e1);
		}
		
	}
		 catch (NoSuchElementException e1)
		  {
			 throw new NotFoundException ("The connectionId you entered is not there in table .So updation is not possible");
				
		  }
	}
	
	public void deleteConnection(Long connectionId)
	{
		try {
	Connection e1 = repository.findById(connectionId).get();
	
	if(e1 !=null)
	{
		repository.delete(e1);
	    System.out.println("deletion sucessfull");
		
	}
		}
	 catch (NoSuchElementException e1)
	  {
		 throw new NotFoundException ("The connectionId you entered is not there in table .So deletion is not possible");
			
	  }
		}
 //////////////////////////////////////////////////////////////////////////////////////
	
	public ResponseEntity <Connection> getConnectionById(Long connectionId)
	{
		Connection c= repository.findById(connectionId)
				.orElseThrow(()->new NotFoundException("connection id does not exists:"+connectionId));
				
		
		return ResponseEntity.ok().body(c);
	}
	
	public List<Connection> readActiveConnectionsByTaluka(String taluka)
	{
		return repository.readActiveConnectionsByTaluka(taluka);
	}
	
	public List<Connection> readActiveConnectionsByVillage(String village)
	{
		return repository.readActiveConnectionsByVillage(village);
	}

	
	public List<Connection> readActiveConnectionsByDistrict(String district)
	{
		return repository.readActiveConnectionsByDistrict(district);
	}


	public List<Connection> readActiveConnectionsByPincode(String pincode) {
		return repository.readActiveConnectionsByPincode(pincode);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	


		
}
