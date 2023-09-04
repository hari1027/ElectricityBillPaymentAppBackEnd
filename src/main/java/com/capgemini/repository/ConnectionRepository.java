 package com.capgemini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.modules.Address;
import com.capgemini.modules.Connection;
import com.capgemini.modules.Customer;


@Repository

public interface ConnectionRepository extends JpaRepository<Connection , Long>{
	@Query(value="select e from Connection e where e.connectionId=?1") 
    public List<Connection> searchConnectionById(@Param("connectionId")Long connectionId);
	@Query("select connection from Connection connection where connection.connectionAddress.taluka=:taluka and connection.connectionStatus=true")
	public List<Connection> readActiveConnectionsByTaluka(@Param("taluka") String taluka);
	@Query("select connection from Connection connection where connection.connectionAddress.village=:villageName and connection.connectionStatus=true")
	public List<Connection> readActiveConnectionsByVillage(@Param("villageName") String villageName);
	@Query("select connection from Connection connection where connection.connectionAddress.district=:districtName and connection.connectionStatus=true")
	public List<Connection> readActiveConnectionsByDistrict(@Param("districtName") String districtName);
	@Query("select connection from Connection connection where connection.connectionAddress.pincode=:pincode and connection.connectionStatus=true")
	public List<Connection> readActiveConnectionsByPincode(@Param("pincode") String pincode);
	
	
	@Query(value="select e from Connection e where e.consumerNumber=?1")
	public Optional<Connection> findByconsumer(long consumerNumber);
	
	@Query("select connection from Connection connection where connection.connectionAddress.taluka=:taluka")
	public Optional<Connection> findBytaluka(String taluka);
	
	@Query(value="select e from Connection e where e.customerConnection=?1")
	public Optional<Connection> findBycustomer(Customer customerConnection);
	
	@Query(value="select e from Connection e where e.connectionAddress=?1")
	public Optional<Connection> findByaddress(Address connectionAddress);

   

}


	
	

