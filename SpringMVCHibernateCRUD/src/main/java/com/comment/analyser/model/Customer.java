package com.comment.analyser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMER_TABLE")
public class Customer implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7297380414746476838L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	@Size(min = 4,message = "minimum size is 4")
	@NotNull(message = "Cannot be left empty")
	private String firstName;
	
	@Column
	private String lastName;

	@Column
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email must be in the format 'some.one@somewhere.com'")
	@Min(value = 6,message = "Mininum length must be 6")
	@Max(value = 25,message = "Maximum length must be 25")
	@NotNull(message = "Cannot be left empty")
	private String email;

	@Column
	@Pattern(regexp = "^[A-Za-z0-9 _]$", message = "can contai only A-Z a-z 0-9 _")
	@NotNull(message = "Cannot be left empty")
	private String address;

	@Column
	@Pattern(regexp = "^[0-9]",message = "enter only integer value")
	@Min(value = 8,message = "Mininum length must be 6")
	@Min(value = 10,message = "Maximum length must be 10")
	@NotNull(message = "Cannot be left empty")
	private long telephone;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}