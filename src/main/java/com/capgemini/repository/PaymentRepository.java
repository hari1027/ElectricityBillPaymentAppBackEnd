package com.capgemini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.modules.Bill;
import com.capgemini.modules.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment , Long> {

	 @Query(value="select e from Payment e where e.paymentId=?1") 
     public List<Payment> searchPaymentById(@Param("paymentId")Long paymentId);

	 @Query(value="select e from Payment e where e.bill=?1")
	public Optional<Payment> findBybill(Bill bill);
	 
}
