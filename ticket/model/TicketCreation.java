package com.ticket.model;

public class TicketCreation extends Customer {
	private String tctype;
	private String tcdept;
	private String tcdesc;
	private boolean isActive;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String Assign;
	public String getAssign() {
		return Assign;
	}
	public void setAssign(String assign) {
		Assign = assign;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getTctype() {
		return tctype;
	}
	public void setTctype(String tctype) {
		this.tctype = tctype;
	}
	public String getTcdept() {
		return tcdept;
	}
	public void setTcdept(String tcdept) {
		this.tcdept = tcdept;
	}
	public String getTcdesc() {
		return tcdesc;
	}
	public void setTcdesc(String tcdesc) {
		this.tcdesc = tcdesc;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "TicketCreation [tctype=" + tctype + ", tcdept=" + tcdept + ", tcdesc=" + tcdesc + ", isActive="
				+ isActive + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", Assign=" + Assign + "]";
	}
	
	
	
}
