package com.mujeeb.mosquedashboard.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	
	public static String formatDate(String expression, Date date) {
		return new SimpleDateFormat(expression).format(date);
	}
}
