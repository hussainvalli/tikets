package com.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ticket.model.TicketCreation;
import com.ticket.utility.DbConnection;

public class TicketDaoImp {

		public int addTicket(TicketCreation tc) {
			int record=0;
			Connection con=DbConnection.getConnection();
			try {
				
				String addQuery = "insert into Ticket(tctype,tcdept,tcdesc,isActive,cname,cemail,cmobile,createdBy,createdDate,updatedBy,updatedDate,Assign) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(addQuery);
				pst.setString(1,tc.getTctype());
				pst.setString(2, tc.getTcdept());
				pst.setString(3, tc.getTcdesc());
				pst.setBoolean(4, tc.isActive());
				pst.setString(5, tc.getCname());
				pst.setString(6,tc.getCemail());
				pst.setLong(7, tc.getCmobile());
				pst.setString(8, tc.getCreatedBy());
				pst.setString(9, tc.getCreatedDate());
				pst.setString(10,tc.getUpdatedBy());
				pst.setString(11,tc.getUpdatedDate());
				pst.setString(12, tc.getAssign());
				record = pst.executeUpdate();
				if (record != 0)
					System.out.println("Record successfully inserted");
				else
					System.out.println("Record not inserted check it once");
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return record;
		
		}
		public TicketCreation updateTicket(TicketCreation tc) {
			Connection con = DbConnection.getConnection();
			try {
				String updateQuery = "update Ticket set Assign=? where cemail=?";
				PreparedStatement pst = con.prepareStatement(updateQuery);
				pst.setString(1, tc.getAssign());
				/*pst.setString(1,tc.getTcdept());
				pst.setString(2,tc.getTcdesc());
				pst.setLong(3,tc.getCmobile());*/
				pst.setString(2, tc.getCemail());
				int update = pst.executeUpdate();
				if (update != 0)
					System.out.println("Record successfully updated");
				else
					System.out.println("Record not updated check it once");
				try {
					con.close();
				} catch (SQLException s) {
					System.out.println("Connection closed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tc;
			
		}
		public TicketCreation getTicket(int tid) {
			TicketCreation tc=new TicketCreation();
			Connection con = DbConnection.getConnection();
			try {
				String listQuery = "select * from Ticket where tid=?";
				PreparedStatement pst = con.prepareStatement(listQuery);
				pst.setInt(1,tid);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					tc.setTctype(rs.getString(1));
					tc.setTcdept(rs.getString(2));
					tc.setTcdesc(rs.getString(3));
					tc.setActive(rs.getBoolean(4));
					tc.setCname(rs.getString(5));
					tc.setCemail(rs.getString(6));
					tc.setCmobile(rs.getLong(7));
					tc.setCreatedBy(rs.getString(8));
					tc.setCreatedDate(rs.getString(9));
					tc.setUpdatedBy(rs.getString(10));
					tc.setUpdatedDate(rs.getString(11));
					tc.setAssign(rs.getString(13));
					/*pst.setString(1,tc.getTctype());
					pst.setString(2, tc.getTcdept());
					pst.setString(3, tc.getTcdesc());
					pst.setBoolean(4, tc.isActive());
					pst.setString(5, tc.getCname());
					pst.setString(6,tc.getCemail());
					pst.setLong(7, tc.getCmobile());
					pst.setString(8, tc.getCreatedBy());
					pst.setString(9, tc.getCreatedDate());
					pst.setString(10,tc.getUpdatedBy());
					pst.setString(11,tc.getUpdatedDate());*/
	//System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5) +"\t"+rs.getDate(6)+"\t"+rs.getString(7)+"\t"+rs.getDate(8)+"\t"+rs.getBoolean(9)+"\t"+rs.getString(10)+"\t"+rs.getDate(11));

				}
				System.out.println("we fetched for a particular record");

				try {
					con.close();
				} catch (SQLException s) {
					System.out.println("Connection closed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return tc;
		
			
		}
		public int delTicket(int tid) {
			Connection con = DbConnection.getConnection();
			int del=0;
			try {
				String deleteQuery = "delete from Ticket where tid=?";
				PreparedStatement pst = con.prepareStatement(deleteQuery);
				pst.setInt(1,tid);
				del = pst.executeUpdate();
				if (del != 0)
					System.out.println("Record successfully deleted");
				else
					System.out.println("Record not deleted check it once");
				try {
					con.close();
				} catch (SQLException s) {
					System.out.println("Connection closed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return del;
			
		}
	/*	public int delAllTickets()
		{
			Connection con=DbConnection.getConnection();
			int delall=0;
			try {
				String delAll="delete from Ticket where tid between 1 and 100";
				PreparedStatement pst=con.prepareStatement(delAll);
				delall=pst.executeUpdate();
				if(delall!=0)
					System.out.println("all records are deleted");
				else
					System.out.println("not all records deleted");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return delall;
			
		}
	*/
		public int delAllTickets(List<Integer> l)
		{
			int delall=0;
			for (int i=0;i<l.size();i++)
			{
				int del=l.get(i);
			 delall=delTicket(del);
			}
			return delall;
			
		}
		public List<TicketCreation> retriveTickets()
		{
			Connection con=DbConnection.getConnection();
			List<TicketCreation> l=new ArrayList<TicketCreation>();
			try {
				String retriveall="select * from Ticket";
				PreparedStatement pst=con.prepareStatement(retriveall);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					TicketCreation tc=new TicketCreation();
					tc.setTctype(rs.getString(1));
					tc.setTcdept(rs.getString(2));
					tc.setTcdesc(rs.getString(3));
					tc.setActive(rs.getBoolean(4));
					tc.setCname(rs.getString(5));
					tc.setCemail(rs.getString(6));
					tc.setCmobile(rs.getLong(7));
					tc.setCreatedBy(rs.getString(8));
					tc.setCreatedDate(rs.getString(9));
					tc.setUpdatedBy(rs.getString(10));
					tc.setUpdatedDate(rs.getString(11));
					tc.setAssign(rs.getString(13));
					l.add(tc);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return l;
			
		}
}
