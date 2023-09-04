
package com.capgemini.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.capgemini.exception.IdAlreadyExistsException;
import com.capgemini.exception.NotFoundException;
import com.capgemini.modules.Payment;
import com.capgemini.repository.PaymentRepository;


@Service
public class PaymentService {
	@Autowired(required=true)
PaymentRepository repository;
	
	public List<Payment> getAllPayment(){
		return repository.findAll();
	}
	
	
	public void addPayment( Payment p) throws Exception {
		
	
		
		p.totalPaid=p.latePaymentCharges+p.bill.billAmount;
		
		if(!(p.paymentId >= 1000 && p.paymentId <= 9999))
		{
			throw new Exception("Invalid paymentId, paymentId should be 4 digit");
		}
		
		if(!(p.totalPaid >= 0))
		{
			throw new Exception("Invalid totalPaid,some Amount should be paid definitely");
		}
		
		Optional<Payment> exisitingPayment=repository.findById(p.getPaymentId());
		if(exisitingPayment.isPresent()) 
		{
			throw new IdAlreadyExistsException("Payment already exist with this Id!!");
		}
		
		Optional<Payment> exisitingBill=repository.findBybill(p.getBill());
		if(exisitingBill.isPresent()) 
		{
			throw new IdAlreadyExistsException("Payment already exist with this billId!!");
		}
		 repository.save(p);
		
	}

	public void updatePayment(Long paymentId,Payment p)
	{
		try {
		Payment p1 = repository.findById(paymentId).get();
		if(p1 !=null)
		{
		  repository.delete(p);
		  
		  Optional<Payment> exisitingPayment=repository.findById(p.getPaymentId());
			if(exisitingPayment.isPresent()) 
			{
				throw new IdAlreadyExistsException("Payment already exist with this Id!!");
			}
			
			Optional<Payment> exisitingBill=repository.findBybill(p.getBill());
			if(exisitingBill.isPresent()) 
			{
				throw new IdAlreadyExistsException("Payment already exist with this billId!!");
			}
			
		 repository.save(p1);
	}
	
}
		 catch (NoSuchElementException e1)
		  {
			 throw new NotFoundException ("The paymentId you entered is not there in table .So updation is not possible");
				
		  }	
	}
	public void deletePayment(Long paymentId)
	{
		try {
	Payment p1 = repository.findById(paymentId).get();
	
	if(p1 !=null)
	{
		repository.delete(p1);
	    System.out.println("deletion sucessfull");
	}
		}
		 catch (NoSuchElementException e1)
		  {
			 throw new NotFoundException ("The paymentId you entered is not there in table .So deletion is not possible");
				
		  }	
		
	
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public ResponseEntity<Payment> getPaymentById(Long paymentId)throws NotFoundException{
		
		Payment p= repository.findById(paymentId)
				.orElseThrow(()->new NotFoundException("payment id does not exists:"+paymentId));
		return ResponseEntity.ok().body(p);
	}



}
	
	
	