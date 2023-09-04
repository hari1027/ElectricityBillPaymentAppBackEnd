package com.capgemini.modules;

import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.InheritanceType;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Users {
    public long userId;
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]*", message = "Invalid userName ,First Letter should be caps")
	private String userName;
	@NotNull
	@Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[$@#*\\/&!�?�+%()=-])(.{8,})", message = "Invalid password ,Use Password Pattern")
	private String password;

	public Users() {
	}

	public Users(long userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

}
