package com.comment.analyser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Token_Words")
public class TokenWords implements Serializable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String token;
	
	@Column
	private int weightage;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getToken() 
	{
		return token;
	}
	public void setToken(String token) 
	{
		token = token;
	}
	public int getWeightage()
	{
		return weightage;
	}
	public void setWeightage(int weightage) 
	{
		this.weightage = weightage;
	}	
}
