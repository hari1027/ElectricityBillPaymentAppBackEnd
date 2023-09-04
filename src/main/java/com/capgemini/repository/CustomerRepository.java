package com.capgemini.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.capgemini.modules.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
	
	
	@Query(value="select e from Customer e where e.customerId=?1") //(Declears finder queries directly on repository methods)
    public List<Customer> searchCustomerById(@Param("customerId")Long customerId);
  
   
   @Query(value="select e from Customer e where e.mobileNumber=?1")
   public List<Customer> searchCustomerByMobile(@Param("mobileNumber")String mobileNumber);
  
    @Query(value="select e from Customer e where e.email=?1")
   public List<Customer> searchCustomerByEmail(@Param("email")String email) ;
   
    @Query(value="select e from Customer e where e.aadharNumber=?1")
   public List<Customer> SearchCustomerByAadhar(@Param("aadharNumber")Long aadharNumber);
   
   @Query(value="select e from Customer e where e.firstName=?1")
   public List<Customer> SearchCustomerByName(@Param("firstName")String firstName);
  
   @Query(value="select e from Customer e where e.userName=?1")
   public List<Customer> searchUserByUserName(@Param("userName")String userName);
   
   @Query(value="select e from Customer e where e.userId=?1")
   public List<Customer> searchUserByUserId(@Param("userId")Long userId);

public Optional<Customer> findByemail(String email);

public Optional<Customer> findBymobileNumber(String mobileNumber);

public Optional<Customer> findByaadharNumber(Long aadharNumber);

public Optional<Customer> findByuserId(Long userId);

public Optional<Customer> findByfirstName(String firstName);

public Optional<Customer> findByuserName(String userName);






	





























}
   
	
  


