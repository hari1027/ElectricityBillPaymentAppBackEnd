package com.capgemini.services;




import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.capgemini.exception.IdAlreadyExistsException;
import com.capgemini.exception.NotFoundException;
import com.capgemini.modules.Reading;
import com.capgemini.repository.ReadingRepository;

@Service
public class ReadingService {

	
	@Autowired(required=true)
	ReadingRepository repository;
	
	public List<Reading> getAllReading(){
		return repository.findAll();
	}
	
	public void addReading( Reading e) throws Exception
	{
		if(!(e.readingId >= 10000 && e.readingId <= 99999))
		{
			throw new Exception("Invalid readingId, readingId should be 5 digit");
		}
		
		if(!e.readingPhoto.equalsIgnoreCase("Taken") && !e.readingPhoto.equalsIgnoreCase("NotTaken"))
		{
			throw new Exception("Invalid readingPhoto, it should contain only Taken and NotTaken");
		}
		
		if(!(Reading.pricePerUnits >=1 && Reading.pricePerUnits <= 10))
		{
			throw new Exception("Invalid pricePerUnits, pricePerUnits should be less than 11 ruppees");
		}
		
		if(!(e.unitsConsumed >= 0 && e.unitsConsumed <= 100000))
		{
			throw new Exception("Invalid unitsConsumed, unitsConsumed should be in the range 0 to 100000");
		}
		
		Optional<Reading> exisitingReading=repository.findById(e.getReadingId());
		if(exisitingReading.isPresent()) 
		{
			throw new IdAlreadyExistsException("Reading already exist with this Id!!");
		}
		
		Optional<Reading> exisitingConnection=repository.findByconnection(e.getReadingForConnection());
		if(exisitingConnection.isPresent()) 
		{
			throw new IdAlreadyExistsException("Reading already exist with this connectionId!!");
		}
		
		repository.save(e);
		
	}
	
	public void updateReading(Long readingId,Reading e)
	{
		try {
		Reading e1 = repository.findById(readingId).get();
		if(e1 !=null)
		{
			repository.delete(e);
			
			Optional<Reading> exisitingReading=repository.findById(e.getReadingId());
			if(exisitingReading.isPresent()) 
			{
				throw new IdAlreadyExistsException("Reading already exist with this Id!!");
			}
			
			Optional<Reading> exisitingConnection=repository.findByconnection(e.getReadingForConnection());
			if(exisitingConnection.isPresent()) 
			{
				throw new IdAlreadyExistsException("Reading already exist with this connectionId!!");
			}
			
			repository.save(e1);
		  }
		}
		 catch (NoSuchElementException e1)
		  {
			 throw new NotFoundException ("The readingId you entered is not there in table .So updation is not possible");
				
		  }
	}
	
	public void deleteReading(Long readingId)
	{
	try 
	{
	      Reading e1 = repository.findById(readingId).get();
	
	if(e1 !=null)
	{
		repository.delete(e1);
	    System.out.println("deletion sucessfull");
	}
	}
	catch(NoSuchElementException e1)
	  {
		 throw new NotFoundException ("The readingId you entered is not there in table .So deletion is not possible");
					
	   }
	
	
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	public ResponseEntity<Reading> getReadingById(Long readingId)throws NotFoundException{
		
		Reading R= repository.findById(readingId)
				.orElseThrow(()->new NotFoundException("reading id does not exists:"+readingId));
		return ResponseEntity.ok().body(R);
	}
	
	
	
	
}