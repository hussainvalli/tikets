package com.ticket.model;

public class Customer {

	private String cname;
	private String cemail;
	private long cmobile;
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public long getCmobile() {
		return cmobile;
	}

	public void setCmobile(long l) {
		this.cmobile = l;
	}

	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", cemail=" + cemail + ", cmobile=" + cmobile + "]";
	}
	
}
