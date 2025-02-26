package com.mujeeb.mosquedashboard.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class DataUtil {

	public static final String DATA_FILE = "data.txt";
	
	public static final String KEY_NAMAZ_TIME_FAJR = "FAJR";
	public static final String KEY_NAMAZ_TIME_ZOHOR = "ZOHOR";
	public static final String KEY_NAMAZ_TIME_ASR = "ASR";
	public static final String KEY_NAMAZ_TIME_ISHA = "ISHA";
	public static final String KEY_NAMAZ_TIME_JUMA = "JUMA";
	public static final String KEY_HIJRI_ADJUSTMENT = "HIJRI_ADJUSTMENT";
	public static final String KEY_SCREENSAVER_SCHEDULE = "SCREEN_SAVER_SCHEDULE";
	
	public static Map<String,String> readDataFile() {
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE));
			Map<String,String> data = (Map<String,String>) in.readObject();
			in.close();
			return data;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			Map<String,String> data = new HashMap<String,String>();
			data.put(KEY_NAMAZ_TIME_FAJR, "6:10");
			data.put(KEY_NAMAZ_TIME_ZOHOR, "1:30");
			data.put(KEY_NAMAZ_TIME_ASR, "5:15");
			data.put(KEY_NAMAZ_TIME_ISHA, "8:30");
			data.put(KEY_NAMAZ_TIME_JUMA, "1:00");
			data.put(KEY_HIJRI_ADJUSTMENT, "0");
			data.put(KEY_SCREENSAVER_SCHEDULE, "23:00,4:00");
			
			writeDataFile(data);
			
			return data;
		}
	}
	
	public static boolean writeDataFile(Map<String,String> data) {
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
			out.writeObject(data);
			out.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
