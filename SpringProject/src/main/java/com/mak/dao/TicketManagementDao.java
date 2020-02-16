package com.mak.dao;

import java.util.List;

import com.mak.model.Ticket;
import com.mak.model.User;
import com.mak.service.TicketService;

public interface TicketManagementDao {

	List<TicketService> getAllTickets();

	Ticket getTicket(int ticketId);

	void updateStatus(Ticket tickets);

	Object getUserRole(String loggedInUserName);

	void addTicket(Ticket ticket);

	List<TicketService> getAssigneeDetails(String assigneeId);

}
