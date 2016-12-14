package com.dao;

import java.io.Serializable;

public class Conduct  implements Serializable
{
    // JavaBean 
    // 用于储存管理员信息
	private static final long serialVersionUID = 1L;
	private String conductName;
	private  String conductPass;
	 
	 
	public String getPassword()
	{
		return conductPass;
	}
	public void setPassword(String password)
	{
		this.conductPass = password;
	}
	 
	public String getUsername()
	{
		return conductName;
	}
	public void setUsername(String username)
	{
		this.conductName = username;
	}

 
}
