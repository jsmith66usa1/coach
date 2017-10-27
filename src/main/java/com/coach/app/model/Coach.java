package com.coach.app.model;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.coach.app.validators.Username;

import java.util.HashSet;

@Entity
public class Coach {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Username(message = "User name has a invalid character (?).")
	@NotNull(message = "User name can not be null.")
	@Column(unique=true)
	private String username = null;
	
	
	private String firstname = null;
	private String lastname = null;
	private String address = null;
	private String phonenumber = null;
	@ManyToMany(mappedBy = "coaches", fetch = FetchType.LAZY)
	private Set<User> users;
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Coach() {

	}

	public Coach(Object[] objArray) {
		this.id = (int) objArray[0];
		this.username =  (String) objArray[1];
		this.firstname =  (String) objArray[2];
		this.lastname = (String) objArray[3];
		this.address = (String) objArray[4];
		this.phonenumber = (String) objArray[5];
	}

	@Override
	public String toString() {
		return "Coach [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", phonenumber=" + phonenumber + ", users=" + users + "]";
	}

}
