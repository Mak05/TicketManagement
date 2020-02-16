package com.mak.service;

import java.util.List;

import com.mak.model.Ticket;
import com.mak.model.User;

public interface TicketService {
	List<TicketService> getAllTickets();
	Ticket getTicket(int ticketId);
	List<TicketService> getAssigneeDetails(String assigneeId);
	void updateStatus(Ticket tickets);
	Object getUserRole(String loggedInUserName);
	void addTicket(Ticket ticket);
}
