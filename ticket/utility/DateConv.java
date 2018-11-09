package com.ticket.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConv {

	public static String toDate(String dt)throws ParseException
	{
		
			SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
			return (date.format(new Date(System.currentTimeMillis())));
	}
	public static String toDateTime(String dateString) throws ParseException 
	{

		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return (dt.format(new Date(System.currentTimeMillis())));
	
	}
}
