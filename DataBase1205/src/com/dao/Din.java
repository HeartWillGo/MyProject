package com.dao;

import java.io.Serializable;

public class Din implements Serializable{
	// JavaBean
    // 用于已订票信息
	private static final long serialVersionUID = 1L;
	private String hao;
	private String rqi;
	private String qifei;
	private String mudi;
	private int jiage;
 
	private String idCard;
	private String sit;
	private String name;
	private int piaosu;

	public void setPiaosu(int piaosu)
	{
		this.piaosu=piaosu;
	}
	public int getPiaosu()
	{
		return piaosu;
	}

	public void setHao(String hao)
	{
		this.hao=hao;
	}
	public String getHao()
	{
		return hao;
	}
	public void setRqi(String i)
	{
		this.rqi=i;
	}
	public String getRqi()
	{
		return rqi;
	}
	public void setQifei(String qifei)
	{
		this.qifei=qifei;
	}
	public String getQifei()
	{
		return qifei;
	}
	public void setMudi(String mudi)
	{
		this.mudi=mudi;
	}
	public String getMudi()
	{
		return mudi;
	}
	public void setJiage(int jiage)
	{
		this.jiage=jiage;
	}
	public int getJiage()
	{
		return jiage;
	}
	 
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getSit() {
		return sit;
	}
	public void setSit(String sit) {
		this.sit = sit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

   

    
    
}
