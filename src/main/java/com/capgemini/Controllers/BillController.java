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
import com.capgemini.modules.Bill;
import com.capgemini.services.BillService;

@RestController
@RequestMapping("/bc")
public class BillController {
	
	@Autowired(required=true)
	BillService service;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/bill",method=RequestMethod.GET)
	public List<Bill> getAllBill()
	{
		return  service.getAllBill();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/addbill",method=RequestMethod.POST)
	public void addBill( @RequestBody  Bill e) throws Exception
	{
		service.addBill(e);
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/update/{billId}",method=RequestMethod.PUT)
	public void updateBill(@PathVariable Long billId,@RequestBody Bill e)
	{
		 service.updateBill(billId,e);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/delete/{billId}",method=RequestMethod.DELETE)
	public void  deleteBill(@PathVariable Long billId)
	{
		service.deleteBill(billId);
	}
////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/billid/{billId}",method=RequestMethod.GET)
	public ResponseEntity <Bill> getBillById(@PathVariable Long billId) throws NotFoundException
	{
		return service.getBillById(billId);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/email/{email}",method=RequestMethod.GET)
	public List<Bill> ViewBillByEmail(@PathVariable String email)
	{
		return service.ViewBillByEmail(email);
	}
	
	@RequestMapping(value="/consumerNumber/{consumerNumber}",method=RequestMethod.GET)
	public List<Bill> ViewBillByConsumerNumber(@PathVariable Long consumerNumber)
	{
		return service.ViewBillByConsumerNumber(consumerNumber);
	}
	
	@RequestMapping(value="/mobileNumber/{mobileNumber}",method=RequestMethod.GET)
	public List<Bill> ViewBillByMobileNumber(@PathVariable String mobileNumber)
	{
		return service.ViewBillByMobileNumber(mobileNumber);
	}

}
