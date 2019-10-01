
package com.zensar.entities;

import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author: Himasnhu Maurya
 * @crestion_date: 27 sep 2019 3:24PM
 * @modification_date: 27 sep 2019 3:24PM;
 */

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name = "cid")
	private int customerId;
	private Name customerName;
	private int age;
	private String gender;
	@Column(nullable = false)
	private String address;
	private LocalDate birthDate;
	private Blob profilePhoto;
	private Clob description;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Name getCustomerName() {
		return customerName;
	}
	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Blob getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(Blob profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public Clob getDescription() {
		return description;
	}
	public void setDescription(Clob description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", age=" + age + ", gender="
				+ gender + ", address=" + address + ", birthDate=" + birthDate + ", profilePhoto=" + profilePhoto
				+ ", description=" + description + "]";
	}
	
	}
	
	
	
	
	


