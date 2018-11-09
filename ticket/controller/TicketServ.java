package com.ticket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.model.TicketCreation;
import com.ticket.service.TicketServiceImp;
import com.ticket.utility.DateConv;

@WebServlet("/servlet")
public class TicketServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletDemo.doGet()");
		response.getWriter().append("Server at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		System.out.println("Now i'm in ServletDemo.doPost()");
		String type=request.getParameter("actionType");
		TicketServiceImp ts=new TicketServiceImp();
		ObjectMapper mapper=new ObjectMapper();
		if(type.equals("insert"))
		{
			System.out.println("i'm going to insert");
			try {
				TicketCreation tc=new TicketCreation();//i am creating object for TicketCreation class
				tc.setTctype(request.getParameter("tctype"));
				tc.setTcdept(request.getParameter("tcdept"));
				tc.setTcdesc(request.getParameter("tcdesc"));
				tc.setActive(true);
				tc.setCname(request.getParameter("cname"));
				tc.setCemail(request.getParameter("cemail"));
				tc.setCmobile(Long.parseLong(request.getParameter("cmobile")));
				tc.setCreatedBy(request.getParameter("createdBy"));
				tc.setCreatedDate(DateConv.toDate(request.getParameter("createdDate")));
				tc.setUpdatedBy(request.getParameter("updatedBy"));
				tc.setUpdatedDate(DateConv.toDateTime(request.getParameter("updatedDate")));
				tc.setAssign(request.getParameter("Assign"));
			    ts.addTicket(tc);//its calling addTicket() method
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(type.equals("update"))
		{
			System.out.println("now i'm going to update a particular record");
			TicketCreation tc=new TicketCreation();
			tc.setAssign(request.getParameter("Assign"));
			tc.setCemail(request.getParameter("cemail"));
			ts.updateTicket(tc);
			
			
		}
		else if(type.equals("retriveAll"))
		{
			System.out.println("now i am going to retrive all the records from Ticket table");
			List<TicketCreation> l=ts.retriveTickets();
			for(int i=0;i<l.size();i++) {
			// Convert object to JSON string and save into a file directly
			mapper.writeValueAsString(l.get(i));
			// Convert object to JSON string
			String jsonInString1 = mapper.writeValueAsString(l.get(i));
			System.out.println(jsonInString1);

			// Convert object to JSON string and pretty print
			jsonInString1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(l.get(i));
			System.out.println(jsonInString1);
			}
			
		}
		else if(type.equals("fetchById"))
		{
			System.out.println("now i'm going to retrive a particular record");
			int tid=Integer.parseInt(request.getParameter("tid"));
			TicketCreation tc=ts.getTicket(tid);
			if(tc.getCemail()==null)
				System.out.println("we cant ftech");
			else
				try {
				
						// Convert object to JSON string and save into a file directly
						mapper.writeValueAsString(tc);
						// Convert object to JSON string
						String jsonInString1 = mapper.writeValueAsString(tc);
						System.out.println(jsonInString1);

						// Convert object to JSON string and pretty print
						jsonInString1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tc);
						System.out.println(jsonInString1);

					} catch (JsonGenerationException e) {
						e.printStackTrace();
					
						}
			
		}
		else if(type.equals("delete"))
		{
			System.out.println("now i am going to delete a record");
			int del=Integer.parseInt(request.getParameter("tid"));
			ts.delTicket(del);
		}
		else if(type.equals("delAll"));
		{
			System.out.println("now i'm gng to delete all record in Ticket table");
			List<Integer> l=new ArrayList<Integer>();
			l.add(10);//where 10 is tid value eg: tid=10 
			l.add(11);
			int delall=	ts.delAllTickets(l);
			if(delall!=0)
			System.out.println("del all");
			else
			System.out.println("not all deleted");
		}
		
		
	}

}
