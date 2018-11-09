package com.ticket.dao;

import java.util.List;

import com.ticket.model.TicketCreation;

public interface ITicketDao {

	
	public int addTicket(TicketCreation tc);
	public TicketCreation updateTicket(TicketCreation tc);
	public TicketCreation getTicket(int tid);
	public int delTicket(int tid);
	public int delAllTickets(int tid);
	public List<TicketCreation> retriveTickets();
}
