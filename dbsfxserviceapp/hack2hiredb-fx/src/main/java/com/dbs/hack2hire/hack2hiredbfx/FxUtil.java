package com.dbs.hack2hire.hack2hiredbfx;

import java.text.DateFormat;
import java.text.SimpleDateFormat;import java.util.Date;

public class FxUtil {
	private static final String DATE_FORMAT="MM/dd/yyyy";

	public static String  fromDatetoString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String strDate = dateFormat.format(date);
		return strDate;
		
	}
}
