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
import com.capgemini.modules.Connection;
import com.capgemini.services.ConnectionService;




@RestController
@RequestMapping("/coc")
public class ConnectionController {
	
	@Autowired(required=true)
	ConnectionService service;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/connection",method=RequestMethod.GET)
	public List<Connection> getAllConnection()
	{
		return  service.getAllConnection();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/addconnection",method=RequestMethod.POST)
	public void addConnection( @RequestBody  Connection e) throws Exception
	{
		service.addConnection(e);
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/update/{connectionId}",method=RequestMethod.PUT)
	public void updateConnection(@PathVariable Long connectionId,@RequestBody Connection e)
	{
		 service.updateConnection(connectionId,e);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/delete/{connectionId}",method=RequestMethod.DELETE)
	public void  deleteConnection(@PathVariable Long connectionId)
	{
		service.deleteConnection(connectionId);
	}
////////////////////////////////////////////////////////////////////////////////////////////////
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/connectionid/{connectionId}",method=RequestMethod.GET)
	public ResponseEntity <Connection> getConnectionById(@PathVariable Long connectionId)throws NotFoundException
	{
		return service.getConnectionById(connectionId);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/taluka/{taluka}",method=RequestMethod.GET)
	public List<Connection> readActiveConnectionsByTaluka(@PathVariable String taluka)
	{
		return service.readActiveConnectionsByTaluka(taluka);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/village/{village}",method=RequestMethod.GET)
	public List<Connection> readActiveConnectionsByVillage(@PathVariable String village)
	{
		return service.readActiveConnectionsByVillage(village);
	}	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/district/{district}",method=RequestMethod.GET)
	public List<Connection> readActiveConnectionsByDistrict(@PathVariable String district)
	{
		return service.readActiveConnectionsByDistrict(district);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/pincode/{pincode}",method=RequestMethod.GET)
	public List<Connection> readActiveConnectionsByPincode(@PathVariable String pincode)
	{
		return service.readActiveConnectionsByPincode(pincode);
	}
	
	
	

}


