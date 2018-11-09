package com.ticket.service;

import java.util.List;

import com.ticket.dao.TicketDaoImp;
import com.ticket.model.TicketCreation;

public class TicketServiceImp {
	
	
		public int addTicket(TicketCreation tc) {
			TicketDaoImp itd=new TicketDaoImp();
			return itd.addTicket(tc);
		
		}
		public TicketCreation updateTicket(TicketCreation tc) {
			TicketDaoImp td=new TicketDaoImp();
			
			return td.updateTicket(tc);
			
		}
		public TicketCreation getTicket(int tid) {
			TicketDaoImp td=new TicketDaoImp();
			
			return td.getTicket(tid);
			
		}
		public int delTicket(int tid) {
			TicketDaoImp td=new TicketDaoImp();
			
			return td.delTicket(tid);
			
		}
		public int delAllTickets(List<Integer> l) {
			TicketDaoImp td=new TicketDaoImp();
			return td.delAllTickets(l);
		}
		public List<TicketCreation> retriveTickets(){
			TicketDaoImp d=new TicketDaoImp();
			return d.retriveTickets();
			
			
		}
}
