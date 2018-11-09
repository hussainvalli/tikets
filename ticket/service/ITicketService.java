package com.ticket.service;

import java.util.List;

import com.ticket.model.TicketCreation;

public interface ITicketService {
	public int addTicket(TicketCreation tc);
	public TicketCreation updateTicket(TicketCreation tc);
	public TicketCreation getTicket(int tid);
	public int delTicket(int tid);
	public int delAllTickets(List<Integer> l) ;
	public List<TicketCreation> retriveTickets();
}
