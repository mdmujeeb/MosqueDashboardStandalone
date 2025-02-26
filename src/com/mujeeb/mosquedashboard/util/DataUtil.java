package com.mujeeb.mosquedashboard.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class DataUtil {

	public static final String DATA_FILE = "data.txt";
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> readDataFile() {
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE));
			Map<String,Object> data = (Map<String,Object>) in.readObject();
			in.close();
			return data;
			
		} catch (Exception e) {
//			e.printStackTrace();
			
			Map<String,Object> data = new HashMap<String,Object>();
			data.put(Constants.KEY_NAMAZ_TIME_FAJR, new int[]{6,10});
			data.put(Constants.KEY_NAMAZ_TIME_ZUHR, new int[]{13,30});
			data.put(Constants.KEY_NAMAZ_TIME_ASR, new int[]{17,15});
			data.put(Constants.KEY_NAMAZ_TIME_ISHA, new int[]{20,30});
			data.put(Constants.KEY_NAMAZ_TIME_JUMUA, new int[]{13,0});
			data.put(Constants.KEY_HIJRI_ADJUSTMENT, 0);
			data.put(Constants.KEY_SCREENSAVER_ON, new int[]{23,0});
			data.put(Constants.KEY_SCREENSAVER_OFF, new int[]{4,0});
			
			writeDataFile(data);
			
			return data;
		}
	}
	
	public static boolean writeDataFile(Map<String,Object> data) {
		
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
