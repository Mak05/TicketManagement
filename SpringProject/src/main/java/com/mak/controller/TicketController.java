package com.mak.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mak.model.Ticket;
import com.mak.model.User;
import com.mak.service.TicketService;

@Controller
public class TicketController {
	private static Logger log=Logger.getLogger(TicketController.class);
	private TicketService ticketService;
	
	@Autowired(required=true)
	@Qualifier(value="ticketService")
	public void setCustomerService(TicketService ticketService) {
		this.ticketService = ticketService;
	}	
	
	@RequestMapping("/admin")
	public void admin(ModelAndView model, Principal principal, HttpServletResponse res) {
		try{
			String loggedInUserName = principal.getName();
			System.out.println(loggedInUserName);
			Object loggedUser =  (Object) ticketService.getUserRole(loggedInUserName);
			if((boolean)loggedUser.equals("ROLE_ADMIN")){
				//model.setViewName("ticketDetails");
				res.sendRedirect("/SpringProject/getAllTickets");
			}
			else if((boolean)loggedUser.equals("ROLE_TEAM")){
				//model.setViewName("assignedList");
				res.sendRedirect("/SpringProject/getAssignedTickets?id="+loggedInUserName);
			}
			else if((boolean)loggedUser.equals("ROLE_USER")){
				//model.setViewName("success");
				res.sendRedirect("/SpringProject/createTicket");
			}
			System.out.println(loggedUser.toString());
			//return model;
		}
		catch(Exception e){
			System.out.println(e);
		}
		//return model;
	}
	
	 @RequestMapping(value = "/createTicket", method = RequestMethod.GET)
	 public String ticket( Ticket ticket, Model model) {
		  System.out.println("Ticket Page Requested");
		  model.addAttribute("ticketDescription", ticket.getTicketDesc());
		  return "createTicket";
	 }
	
	@RequestMapping(value= "/addTicket", method = RequestMethod.POST)
	 public ModelAndView addTicket(@ModelAttribute("ticket")@Validated Ticket ticket, Model model){	 
		  ticket.setTicketStatus("open");
		  ticketService.addTicket(ticket);
		  System.out.println("Ticket Page added"+ ticket.toString());
		  return new ModelAndView("ticketAdded","command", new Ticket());
	 } 

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		System.out.println("Entered");
		model.addAttribute("message",
				"You have successfully logged off from application !");
		return "login";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";

	}
	
	@RequestMapping(value="/getAllTickets")
	public ModelAndView listTickets(ModelAndView model) throws IOException {
		List<TicketService> listTickets = ticketService.getAllTickets();
		log.info("Inside list tickets");
		model.addObject("listTickets", listTickets);
		model.setViewName("ticketDetails");
		return model;
	}
	
	@RequestMapping(value = "/getTicket", method = RequestMethod.GET)
	public ModelAndView getTicket(HttpServletRequest request) {
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		Ticket tickets = ticketService.getTicket(ticketId);	
		ModelAndView model = new ModelAndView("ticket");
		model.addObject("tickets", tickets);
		return model;
	}	
	
	@RequestMapping(value = "/getTicketToAssign", method = RequestMethod.GET)
	public ModelAndView getTicketToAssign(HttpServletRequest request) {
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		Ticket tickets = ticketService.getTicket(ticketId);	
		ModelAndView model = new ModelAndView("assigneeUpdate");
		model.addObject("tickets", tickets);
		return model;
	}	
	
	@RequestMapping(value="/getAssignedTickets")
	public ModelAndView getAssigneeDetails(HttpServletRequest request) {
		String assigneeId = request.getParameter("id");
		List<TicketService> assignedList = ticketService.getAssigneeDetails(assigneeId);	
		ModelAndView model = new ModelAndView("assignedList");
		model.addObject("assignedList", assignedList);
		return model;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateStatus(HttpServletRequest request) {
		String ticketStatus = request.getParameter("category");
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		Ticket tickets = ticketService.getTicket(ticketId);	
		tickets.setTicketStatus(ticketStatus);
		ticketService.updateStatus(tickets);	
		ModelAndView model = new ModelAndView("success");
		model.addObject("tickets", tickets);
		return model;
	}
	
	@RequestMapping(value = "/updateAssignee", method = RequestMethod.GET)
	public String updateAssignee(HttpServletRequest request) {
		String assigneeId = request.getParameter("assigneeId");
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		Ticket tickets = ticketService.getTicket(ticketId);	
		tickets.setAssigneeId(assigneeId);
		ticketService.updateStatus(tickets);	
		return "assigneeSuccess";
	}	
	
}
