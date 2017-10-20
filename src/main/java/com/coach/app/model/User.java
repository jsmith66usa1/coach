package com.coach.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.springframework.data.annotation.Transient;
import org.hibernate.annotations.LazyCollection;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;



@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String firstname = null;
	private String lastname = null;
	private String address = null;
	private String phonenumber = null;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "user_coach", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "coach_id", referencedColumnName = "id"))
	private Set<Coach> coaches= new HashSet<Coach>();
	
	
	

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
	
	public Set<Coach> getCoaches() {
		return coaches;
	}
	
	public void setCoaches(Set<Coach> coaches) {
		this.coaches = coaches;
	}

	public User() {
		
	}

	public User(int id, String firstname, String lastname, String address, String phonenumber, Set<Coach> coaches) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.coaches = coaches;
	}

	public User(Object[] objArray) {
		this.id = (int) objArray[0];
		this.firstname =  (String) objArray[1];
		this.lastname = (String) objArray[2];
		this.address = (String) objArray[3];
		this.phonenumber = (String) objArray[4];
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", coaches=" + coaches + "]";
	}

	
	
}
