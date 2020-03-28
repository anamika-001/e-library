package model;

import java.time.LocalDate;

public class Students {
 private int userId;
 private String name;
 private String address;
 private int mobile ;
 private LocalDate joinDate;
public Students(int userId, String name, String address, int mobile, LocalDate joinDate) {
	super();
	this.userId = userId;
	this.name = name;
	this.address = address;
	this.mobile = mobile;
	this.joinDate = joinDate;
}
public Students() {
	// TODO Auto-generated constructor stub
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getMobile() {
	return mobile;
}
public void setMobile(int mobile) {
	this.mobile = mobile;
}
public LocalDate getJoinDate() {
	return joinDate;
}
public void setJoinDate(LocalDate joinDate) {
	this.joinDate = joinDate;
}
 
 
}
