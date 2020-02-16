package com.mak.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ticket",schema="DB")
public class Ticket {
	@Id
	private int ticketId;
	private String ticketDesc;
	private String ticketStatus;
	private String assigneeId;
	
	public Ticket(){}
	public Ticket(int ticketId, String ticketDesc, String ticketStatus, String assigneeId) {
		super();
		this.ticketId = ticketId;
		this.ticketDesc = ticketDesc;
		this.ticketStatus = ticketStatus;
		this.assigneeId = assigneeId;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketDesc() {
		return ticketDesc;
	}
	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(String assigneeId) {
		this.assigneeId = assigneeId;
	}
}
