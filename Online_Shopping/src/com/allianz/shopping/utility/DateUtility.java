package com.allianz.shopping.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
public static Date converStringToDate( String date) throws ParseException {
	 
	 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		return date1;
	    
	
	
}
public static String converDateToString( Date date) throws ParseException {
	 
	 String date1=new SimpleDateFormat("dd/MM/yyyy").format(date);
		return date1;
	    
	
	
	
}
public static java.sql.Date convertUtilToSql(java.util.Date udate)
{
	java.sql.Date sdate=new java.sql.Date(udate.getTime());
	return sdate;
}
}
