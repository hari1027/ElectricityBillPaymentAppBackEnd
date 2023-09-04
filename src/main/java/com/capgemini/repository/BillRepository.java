package com.capgemini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capgemini.modules.Bill;
import com.capgemini.modules.Reading;

@Repository

public interface BillRepository extends JpaRepository<Bill  , Long> {
	
	   @Query(value="select e from Bill e where e.billId=?1") 
       public List<Bill> searchBillById(@Param("billId")Long billId);
	   
	   @Query(value="select bill from Bill bill where bill.billForReading.readingForConnection.consumerNumber=:consumerNumber")
	   public List<Bill> ViewBillByConsumerNumber(@Param("consumerNumber")Long consumerNumber);

	
	   @Query(value="select bill from Bill bill where bill.billForReading.readingForConnection.customerConnection.email=:email")
	   public List<Bill> ViewBillByEmail(@Param("email")String email);
	
	   @Query(value="select bill from Bill bill where bill.billForReading.readingForConnection.customerConnection.mobileNumber=:mobileNumber")
	   public List<Bill> ViewBillByMobileNumber(@Param("mobileNumber")String mobileNumber);

	   @Query(value="select e from Bill e where e.billForReading=?1")
	   public Optional<Bill> findByreading(Reading billForReading);

	  
     }

