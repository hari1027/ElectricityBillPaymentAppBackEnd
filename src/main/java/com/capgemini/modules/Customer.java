package com.capgemini.modules;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;




@Entity



public class Customer extends Users {
    @Id
	public long customerId;
    public long aadharNumber;
    @NotNull(message="This field should not be empty")
	@Pattern(regexp="[A-Z]{1}[a-z]*",message="Invalid firstName, First letter should be caps ,Only Alphabets are allowed")
    public	String firstName;
    @NotNull(message="This field should not be empty")
	@Pattern(regexp="[A-Z]{1}[a-z]*",message="Invalid middleName, First letter should be caps ,Only Alphabets are allowed")
	public String middleName;
    @NotNull(message="This field should not be empty")
	@Pattern(regexp="[A-Z]{1}[a-z]*",message="Invalid lastName, First letter should be caps ,Only Alphabets are allowed")
	public String lastName;
	@Email
	@NotNull(message="This field should not be empty ,Follow the Email pattern")
	public  String email;
    @NotNull(message="This field should not be empty ,It should be 10 digits")
	public String mobileNumber;
    @NotNull(message="This field should not be empty")
    public String gender;
    
  
    
   // public long LongEmail=Long.parseLong(email);
	
	
	public Customer() {
	}


	public Customer(long customerId, long aadharNumber, String firstName, String middleName, String lastName,
			String email, String mobileNumber, String gender) {
		
		this.customerId = customerId;
		this.aadharNumber = aadharNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public long getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber (String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", aadharNumber=" + aadharNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", gender=" + gender + "]";
	}


	
  
	
	


	



	
}