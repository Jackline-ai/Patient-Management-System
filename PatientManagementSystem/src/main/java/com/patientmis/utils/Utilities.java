package com.patientmis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	public static String getCurrentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy_mm_dd");
		Date currentDate = new Date();
		return "PatientRegistration"+ dateFormat.format(currentDate)+".pdf";
		
	}

}
