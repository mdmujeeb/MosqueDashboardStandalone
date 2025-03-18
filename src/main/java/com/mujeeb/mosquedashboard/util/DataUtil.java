package com.mujeeb.mosquedashboard.util;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.mujeeb.mosquedashboard.main.Main;

public class DataUtil {

	public static final String DATA_FILE = "settings.dat";

	public static Map<String,Object> readDataFile() {
		
		try {
			Properties dataFile = new Properties();
			dataFile.load(new FileInputStream(DATA_FILE));
			
			Map<String,Object> data = new TreeMap<String,Object>();
			
			data.put(Constants.KEY_RUNNING_ON_PI, Boolean.parseBoolean(dataFile.getOrDefault(Constants.KEY_RUNNING_ON_PI, "true").toString()));
			data.put(Constants.KEY_LATITUDE, Double.parseDouble(dataFile.getOrDefault(Constants.KEY_LATITUDE, "13.1309241").toString()));
			data.put(Constants.KEY_LONGITUDE, Double.parseDouble(dataFile.getOrDefault(Constants.KEY_LONGITUDE, "77.6351945").toString()));
			data.put(Constants.KEY_GMT_DIFFERENCE, Double.parseDouble(dataFile.getOrDefault(Constants.KEY_GMT_DIFFERENCE, "5.5").toString()));
			data.put(Constants.KEY_USER_ID, dataFile.getOrDefault(Constants.KEY_USER_ID, "1"));
			data.put(Constants.KEY_PASSWORD, dataFile.getOrDefault(Constants.KEY_PASSWORD, "Allah"));
			data.put(Constants.KEY_NAMAZ_TIME_FAJR, parseTime(dataFile.getOrDefault(Constants.KEY_NAMAZ_TIME_FAJR, "6:10").toString()));
			data.put(Constants.KEY_NAMAZ_TIME_ZUHR, parseTime(dataFile.getOrDefault(Constants.KEY_NAMAZ_TIME_ZUHR, "13:30").toString()));
			data.put(Constants.KEY_NAMAZ_TIME_ASR, parseTime(dataFile.getOrDefault(Constants.KEY_NAMAZ_TIME_ASR, "17:15").toString()));
			data.put(Constants.KEY_NAMAZ_TIME_ISHA, parseTime(dataFile.getOrDefault(Constants.KEY_NAMAZ_TIME_ISHA, "20:30").toString()));
			data.put(Constants.KEY_NAMAZ_TIME_JUMUA, parseTime(dataFile.getOrDefault(Constants.KEY_NAMAZ_TIME_JUMUA, "13:00").toString()));
			data.put(Constants.KEY_SCREENSAVER_ON, parseTime(dataFile.getOrDefault(Constants.KEY_SCREENSAVER_ON, "23:00").toString()));
			data.put(Constants.KEY_SCREENSAVER_OFF, parseTime(dataFile.getOrDefault(Constants.KEY_SCREENSAVER_OFF, "4:00").toString()));
			data.put(Constants.KEY_HIJRI_ADJUSTMENT, Integer.parseInt(dataFile.getOrDefault(Constants.KEY_HIJRI_ADJUSTMENT, "-1").toString()));
			
			return data;
			
		} catch (Exception e) {
//			e.printStackTrace();
			
			Map<String, Object> data = new TreeMap<String,Object>();
			
			data.put(Constants.KEY_RUNNING_ON_PI, true);
			data.put(Constants.KEY_LATITUDE, 13.1309241);
			data.put(Constants.KEY_LONGITUDE, 77.6351945);
			data.put(Constants.KEY_GMT_DIFFERENCE, 5.5);
			data.put(Constants.KEY_USER_ID, "1");
			data.put(Constants.KEY_PASSWORD, "Allah");
			data.put(Constants.KEY_NAMAZ_TIME_FAJR, new int[] {6,10});
			data.put(Constants.KEY_NAMAZ_TIME_ZUHR, new int[] {13,30});
			data.put(Constants.KEY_NAMAZ_TIME_ASR, new int[] {17,15});
			data.put(Constants.KEY_NAMAZ_TIME_ISHA, new int[] {20,30});
			data.put(Constants.KEY_NAMAZ_TIME_JUMUA, new int[] {13,0});
			data.put(Constants.KEY_SCREENSAVER_ON, new int[] {23,0});
			data.put(Constants.KEY_SCREENSAVER_OFF, new int[] {4,0});
			data.put(Constants.KEY_HIJRI_ADJUSTMENT, -1);
			
			writeDataFile(data);
			return data;
		}
	}
	
	public static boolean writeDataFile(Map<String,Object> data) {
		
		PrintWriter writer;
		
		try {
			writer = new PrintWriter(DATA_FILE);
		}catch(Exception ex) {
			return false;
		}
		
		writer.println("# Data File for Mosque Dashboard System.\n");
		
		writer.println(Constants.KEY_RUNNING_ON_PI + "=" + data.get(Constants.KEY_RUNNING_ON_PI));
		writer.println(Constants.KEY_LATITUDE + "=" + data.get(Constants.KEY_LATITUDE));
		writer.println(Constants.KEY_LONGITUDE + "=" + data.get(Constants.KEY_LONGITUDE));
		writer.println(Constants.KEY_GMT_DIFFERENCE + "=" + data.get(Constants.KEY_GMT_DIFFERENCE));
		writer.println(Constants.KEY_USER_ID + "=" + data.get(Constants.KEY_USER_ID));
		writer.println(Constants.KEY_PASSWORD + "=" + data.get(Constants.KEY_PASSWORD));
		writer.println(Constants.KEY_NAMAZ_TIME_FAJR + "=" + formatTime(data.get(Constants.KEY_NAMAZ_TIME_FAJR)));
		writer.println(Constants.KEY_NAMAZ_TIME_ZUHR + "=" + formatTime(data.get(Constants.KEY_NAMAZ_TIME_ZUHR)));
		writer.println(Constants.KEY_NAMAZ_TIME_ASR + "=" + formatTime(data.get(Constants.KEY_NAMAZ_TIME_ASR)));
		writer.println(Constants.KEY_NAMAZ_TIME_ISHA + "=" + formatTime(data.get(Constants.KEY_NAMAZ_TIME_ISHA)));
		writer.println(Constants.KEY_NAMAZ_TIME_JUMUA + "=" + formatTime(data.get(Constants.KEY_NAMAZ_TIME_JUMUA)));
		writer.println(Constants.KEY_SCREENSAVER_ON + "=" + formatTime(data.get(Constants.KEY_SCREENSAVER_ON)));
		writer.println(Constants.KEY_SCREENSAVER_OFF + "=" + formatTime(data.get(Constants.KEY_SCREENSAVER_OFF)));
		writer.println(Constants.KEY_HIJRI_ADJUSTMENT + "=" + data.get(Constants.KEY_HIJRI_ADJUSTMENT));
		
		writer.close();
		return true;
	}
	
	protected static int[] parseTime(String time) {
		String[] times = time.split(":");
		return new int[] {Integer.parseInt(times[0]), Integer.parseInt(times[1])};
	}
	
	protected static String formatTime(Object objTime) {
		int[] time = (int[]) objTime;
		return time[0] + ":" + time[1];
	}
	
	// API Methods
	public static void changeNamazTIme(String namazTimeName, int hour, int minute) {
		
		if(namazTimeName.equals("ALLAHU")) {
			VoiceUtil.playStream(new ResourceStreamUtil().getResourceStream("resources/zikr/Allahu.mp3"));
			
//		} else if(namazTimeName.startsWith("ZIKR")) {
//			VoiceUtil.playStream(new ResourceStreamUtil().getResourceStream("resources/zikr/" + namazTimeName + ".mp3"));
//			
		} else {
			Map<String,Object> data = Main.getData();
			data.put(namazTimeName, new int[] {hour, minute});
			writeDataFile(data);
			Main.refreshNamazTime(namazTimeName);
		}
	}
	
	public static void changeHijriAdjustment(int hijriAdjustment) {
		
		Map<String,Object> data = Main.getData();
		data.put(Constants.KEY_HIJRI_ADJUSTMENT, hijriAdjustment);
		writeDataFile(data);
		IslamicUtil.getPrayerTimes(data);			// Calculate Maghrib and other dynamic times
		Main.refreshHijriDateComponents();
	}
}
