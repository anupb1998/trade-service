package com.db.trade.utility;

import java.util.Date;

public class TimeUtil {
	
	public static boolean isDateInPast(Date date) {
		if(date.before(new Date())) {
			return true;
		}
		return false;
	}

}
