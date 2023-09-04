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
import com.capgemini.modules.Reading;
import com.capgemini.services.ReadingService;

@RestController
@RequestMapping("/rc")

public class ReadingController {

	@Autowired(required=true)
	ReadingService service;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/reading",method=RequestMethod.GET)
	public List<Reading> getAllReading()
	{
		return  service.getAllReading();
	}
	
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/addreading",method=RequestMethod.POST)
	public void addReading( @RequestBody  Reading e) throws Exception
	{
		service.addReading(e);
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/update/{readingId}",method=RequestMethod.PUT)
	public void updateReading(@PathVariable Long readingId,@RequestBody Reading e)
	{
		 service.updateReading(readingId,e);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/delete/{readingId}",method=RequestMethod.DELETE)
	public void  deleteReading(@PathVariable Long readingId)
	{
		service.deleteReading(readingId);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/readingid/{readingId}",method=RequestMethod.GET)
	public ResponseEntity <Reading> getReadingById(@PathVariable Long readingId) throws NotFoundException
	{
		return service.getReadingById(readingId);
	}
	
	
		
	}


