package com.mak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mak.dao.TicketManagementDao;
import com.mak.model.Ticket;
import com.mak.model.User;

@Service
public class TicketServiceImplementation implements TicketService {
	private static Logger log=Logger.getLogger(TicketServiceImplementation.class);
	private TicketManagementDao ticketDao;
	
	public void setTicketDao(TicketManagementDao ticketDao) {
		this.ticketDao = ticketDao;
	}


	@Transactional
	public List<TicketService> getAllTickets() {
		// TODO Auto-generated method stub
		log.info("Inside service's");
		return ticketDao.getAllTickets();
	}


	@Transactional
	public Ticket getTicket(int ticketId) {
		// TODO Auto-generated method stub
		log.info("Inside service's");
		return ticketDao.getTicket(ticketId);
	}


	@Transactional
	public List<TicketService> getAssigneeDetails(String assigneeId) {
		// TODO Auto-generated method stub
		log.info("Inside service's");
		return ticketDao.getAssigneeDetails(assigneeId);
	}


	@Transactional
	public void updateStatus(Ticket tickets) {
		// TODO Auto-generated method stub
		log.info("Inside service's");
		ticketDao.updateStatus(tickets);
	}


	@Override
	@Transactional
	public Object getUserRole(String loggedInUserName) {
		// TODO Auto-generated method stub
		return ticketDao.getUserRole(loggedInUserName);
	}


	@Override
	@Transactional
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketDao.addTicket(ticket);
		
	}


}
