package com.coach.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.HashSet;

@Entity
public class Coach {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

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
		this.firstname =  (String) objArray[1];
		this.lastname = (String) objArray[2];
		this.address = (String) objArray[3];
		this.phonenumber = (String) objArray[4];
	}

}
