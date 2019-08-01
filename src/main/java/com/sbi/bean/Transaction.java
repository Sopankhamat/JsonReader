package com.sbi.bean;

import java.util.Date;

public class Transaction {

	private String type=null;
	private Date date=null;
	public Transaction(String type, Date date) {
		super();
		this.type = type;
		this.date = date;
	}
	private String getType() {
		return type;
	}
	private void setType(String type) {
		this.type = type;
	}
	private Date getDate() {
		return date;
	}
	private void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [type=" + type + ", date=" + date + "]";
	}
	
}

