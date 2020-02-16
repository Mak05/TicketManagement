package com.mak.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mak.model.Ticket;
import com.mak.model.User;
import com.mak.service.TicketService;

@Repository
public class TicketDaoImplementation implements TicketManagementDao{
	private static Logger log=Logger.getLogger(TicketDaoImplementation.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<TicketService> getAllTickets() {
		// TODO Auto-generated method stub
		log.info("Inside dao's");
		return sessionFactory.getCurrentSession().createQuery("from Ticket")
				.list();
	}
	//@Override
	public Ticket getTicket(int ticketId) {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Ticket c where c.ticketId=:ticketId");
		q.setParameter("ticketId", ticketId);
		Ticket c=(Ticket)q.uniqueResult();
		return c;
	}
	//@Override
	@SuppressWarnings("unchecked")
	public List<TicketService> getAssigneeDetails(String assigneeId) {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Ticket c where c.assigneeId=:assigneeId");
		q.setParameter("assigneeId", assigneeId);
		return q.list();
	}
	//@Override
	public void updateStatus(Ticket tickets) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(tickets);
		log.info("Inside status");
		
	}
	@Override
	public Object getUserRole(String userName) {
		// TODO Auto-generated method stub
		SQLQuery q= sessionFactory.getCurrentSession().createSQLQuery("select authority from authorities where userName=:userName");
		q.setParameter("userName", userName);
		return q.uniqueResult();
	}
	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(ticket);
		
	}

}
