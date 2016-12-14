package com.dao;

public class Passage {
	// JavaBean 
    // 用于储存用户信息
	private static final long serialVersionUID = 1L;
	 
	private String name;
	private String sex;
	 
	private String idCard;
	 
	 private String Id;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	 
	 
	 
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	 
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}

 
}


