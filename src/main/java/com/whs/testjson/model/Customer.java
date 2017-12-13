package com.whs.testjson.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {

	private Integer code;
	private String name;
	private String document;
	private Boolean active;
	private Date createDate;
	private List<Address> listAddress;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<Address> getListAddress() {
		return listAddress;
	}
	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}
	public void addAddress(Address address) {
		if( this.listAddress == null )
			this.listAddress = new ArrayList<Address>();
		this.listAddress.add(address);
	}
	
}
