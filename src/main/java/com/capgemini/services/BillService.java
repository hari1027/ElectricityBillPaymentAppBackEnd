package com.capgemini.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.capgemini.exception.IdAlreadyExistsException;
import com.capgemini.exception.NotFoundException;
import com.capgemini.modules.Bill;
import com.capgemini.modules.Reading;
import com.capgemini.repository.BillRepository;


@Service

public class BillService {
	
	@Autowired(required=true)
	BillRepository repository;
	
	public List<Bill> getAllBill(){
		return repository.findAll();
	}
	
	
	public void addBill(Bill e ) throws Exception {
		
	
		e.billAmount=(e.unitsConsumed)*(Reading.pricePerUnits);
		
		if(!(e.billId >= 10000000 && e.billId <= 99999999))
		{
			throw new Exception("Invalid billId, billId should be 8 digit");
		}
		
		if(!(e.billAmount >= 0))
		{
			throw new Exception("Invalid billAmount");
		}
		
		if(!(e.unitsConsumed >= 0 && e.unitsConsumed <= 100000))
		{
			throw new Exception("Invalid unitsConsumed, unitsConsumed should be in the range 0 to 100000");
		}
		
		Optional<Bill> exisitingBill=repository.findById(e.getBillId());
		if(exisitingBill.isPresent()) 
		{
			throw new IdAlreadyExistsException("Bill already exist with this Id!!");
		}
		
		Optional<Bill> exisitingReading=repository.findByreading(e.getBillForReading());
		if(exisitingReading.isPresent()) 
		{
			throw new IdAlreadyExistsException("Bill already exist with this readingId!!");
		}
		
		
		
		repository.save(e);
		 System.out.println("posted sucessfull");
		
	}

	

	

	
		
	public void updateBill(Long billId,Bill e)
	{
		try {
		Bill e1 = repository.findById(billId).get();
		if(e1 !=null)
		{
		   repository.delete(e);
		   
		   Optional<Bill> exisitingBill=repository.findById(e.getBillId());
			if(exisitingBill.isPresent()) 
			{
				throw new IdAlreadyExistsException("Bill already exist with this Id!!");
			}
			
			Optional<Bill> exisitingReading=repository.findByreading(e.getBillForReading());
			if(exisitingReading.isPresent()) 
			{
				throw new IdAlreadyExistsException("Bill already exist with this readingId!!");
			}
			
			repository.save(e1);
			 System.out.println("updation sucessfull");
		}
	}
		 catch (NoSuchElementException e1)
		  {
			 throw new NotFoundException ("The billId you entered is not there in table .So updation is not possible");
				
		  }
	}
	
	public void deleteBill(Long billId)
	{
		try {
	Bill e1 = repository.findById(billId).get();
	
	if(e1 !=null)
	{
		repository.delete(e1);
	    System.out.println("deletion sucessfull");
		
	}
		}
	catch(NoSuchElementException e1)
	  {
		 throw new NotFoundException ("The billId you entered is not there in table .So deletion is not possible");
			
	  }
		
	}
////////////////////////////////////////////////////////////////////////////////////
	
public ResponseEntity<Bill> getBillById(Long billId)throws NotFoundException{
		
		Bill B= repository.findById(billId)
				.orElseThrow(()->new NotFoundException("bill id does not exists:"+billId));
		return ResponseEntity.ok().body(B);
	}
////////////////////////////////////////////////////////////////////////////////////

	public List<Bill> ViewBillByEmail(String email) {
		return repository.ViewBillByEmail(email);
	}
	
	public List<Bill> ViewBillByConsumerNumber(Long consumerNumber) {
		return repository.ViewBillByConsumerNumber(consumerNumber);
	}
	
	
	public List<Bill> ViewBillByMobileNumber(String mobileNumber) {
		return repository.ViewBillByMobileNumber(mobileNumber);
	}

}
