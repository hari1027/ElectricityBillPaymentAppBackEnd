package com.capgemini.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.NotFoundException;
import com.capgemini.modules.Payment;
import com.capgemini.services.PaymentService;


@RestController
@RequestMapping("/pc")
public class PaymentController {
	@Autowired(required=true)
		PaymentService service;
		@RequestMapping(value="/payment",method=RequestMethod.GET)
		public List<Payment> getAllPayment()
		{
			return  service.getAllPayment();
		}
		
		@RequestMapping(value="/addpayment",method=RequestMethod.POST)
		public void addPayment( @RequestBody  Payment p) throws Exception
		{
			 service.addPayment(p);
			
		}

		@RequestMapping(value="/update/{paymentId}",method=RequestMethod.PUT)
		public void updatePayment(@PathVariable Long paymentId,@RequestBody Payment p)
		{
			 service.updatePayment(paymentId,p);
		}
		
		@RequestMapping(value="/delete/{paymentId}",method=RequestMethod.DELETE)
		public void  deletePayment(@PathVariable Long paymentId)
		{
			service.deletePayment(paymentId);
		}
		
		////////////////////////////////////////////////////////////////////////////////////
		
		@RequestMapping(value="/paymentid/{paymentId}",method=RequestMethod.GET)
		public ResponseEntity <Payment> getPaymentById(@PathVariable Long paymentId)throws NotFoundException
		{
			return service.getPaymentById(paymentId);
		}
}
