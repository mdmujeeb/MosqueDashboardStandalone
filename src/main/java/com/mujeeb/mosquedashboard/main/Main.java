package com.mujeeb.mosquedashboard.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.grpc.server.MosqueDashboardServer;
import com.mujeeb.mosquedashboard.panels.AdvertisementPanel;
import com.mujeeb.mosquedashboard.panels.GregorianPanel;
import com.mujeeb.mosquedashboard.panels.HijriPanel;
import com.mujeeb.mosquedashboard.panels.NamazTimePanel;
import com.mujeeb.mosquedashboard.panels.TimePanel;
import com.mujeeb.mosquedashboard.util.Constants;
import com.mujeeb.mosquedashboard.util.DataUtil;
import com.mujeeb.mosquedashboard.util.IslamicUtil;
import com.mujeeb.mosquedashboard.util.JPanelWithBackgroundImage;
import com.mujeeb.mosquedashboard.util.VoiceUtil;

public class Main {
	
	public static int windowHeight = 0;
	public static int windowWidth = 0;
	
	protected static Map<String,Object> data;
	
	protected static String AUDIO_FILE_PATH = "resources/Allahu.mp3";
	
	protected static GregorianPanel gregorianPanel;
	protected static TimePanel timePanel;
	protected static HijriPanel hijriPanel;
	protected static Map<String,NamazTimePanel> namazTimePanels = new HashMap<String,NamazTimePanel>();
	
	// Timers for Blinking
	protected static BlinkData blinkData = new BlinkData();
	protected static NamazTimes namazTimes = new NamazTimes();

	public static void main(String[] args) {
		
		data = DataUtil.readDataFile();				// Get the stored Data
		IslamicUtil.getPrayerTimes(data);			// Calculate Maghrib and other dynamic times
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setAlwaysOnTop(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		Image backgroundImage = new ImageIcon("resources/background.png").getImage();
		JPanel mainPanel = new JPanelWithBackgroundImage(backgroundImage);
		mainPanel.setBackground(Color.BLACK);
		
		windowWidth = frame.getSize().width;
		windowHeight = frame.getSize().height;
		
		// Create all the Panels
		gregorianPanel = new GregorianPanel();
		timePanel = new TimePanel();
		hijriPanel = new HijriPanel();
		namazTimePanels.put(Constants.KEY_NAMAZ_TIME_FAJR, new NamazTimePanel(Constants.KEY_NAMAZ_TIME_FAJR));
		namazTimePanels.put(Constants.KEY_NAMAZ_TIME_ZUHR, new NamazTimePanel(Constants.KEY_NAMAZ_TIME_ZUHR));
		namazTimePanels.put(Constants.KEY_NAMAZ_TIME_ASR, new NamazTimePanel(Constants.KEY_NAMAZ_TIME_ASR));
		namazTimePanels.put(Constants.KEY_NAMAZ_TIME_MAGHRIB, new NamazTimePanel(Constants.KEY_NAMAZ_TIME_MAGHRIB));
		namazTimePanels.put(Constants.KEY_NAMAZ_TIME_ISHA, new NamazTimePanel(Constants.KEY_NAMAZ_TIME_ISHA));
		namazTimePanels.put(Constants.KEY_NAMAZ_TIME_JUMUA, new NamazTimePanel(Constants.KEY_NAMAZ_TIME_JUMUA));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerPanel.add(gregorianPanel, gbc);
		
		gbc.gridx = 1;
		centerPanel.add(timePanel, gbc);
		
		gbc.gridx = 2;
		centerPanel.add(hijriPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		centerPanel.add(namazTimePanels.get(Constants.KEY_NAMAZ_TIME_ASR), gbc);
		
		gbc.gridx = 1;
		centerPanel.add(namazTimePanels.get(Constants.KEY_NAMAZ_TIME_ZUHR), gbc);
		
		gbc.gridx = 2;
		centerPanel.add(namazTimePanels.get(Constants.KEY_NAMAZ_TIME_FAJR), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		centerPanel.add(namazTimePanels.get(Constants.KEY_NAMAZ_TIME_JUMUA), gbc);
		
		gbc.gridx = 1;
		centerPanel.add(namazTimePanels.get(Constants.KEY_NAMAZ_TIME_ISHA), gbc);
		
		gbc.gridx = 2;
		centerPanel.add(namazTimePanels.get(Constants.KEY_NAMAZ_TIME_MAGHRIB), gbc);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(new AdvertisementPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(mainPanel);
		
		// Refresh Data for All Panels
		gregorianPanel.refreshData();
		timePanel.refreshData();
		hijriPanel.refreshData();
		namazTimePanels.values().stream().forEach(panel -> panel.refreshData());
		
		updateNamazTimeData();
		checkForNextNamazTime();
		
		frame.setVisible(true);
		frame.repaint();
		
		final Calendar previousDate = new GregorianCalendar();
		
		// Start a timer to update things every second.
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Calendar currentDate = new GregorianCalendar();

				if(previousDate.get(Calendar.HOUR_OF_DAY) != currentDate.get(Calendar.HOUR_OF_DAY)		// If Time has Changed, refresh Time panel
						|| previousDate.get(Calendar.MINUTE) != currentDate.get(Calendar.MINUTE)) {

					timePanel.refreshData();
					
					updateNamazTimeData();
					checkForNextNamazTime();
					checkIsNowNamazTime();
					
					previousDate.set(Calendar.HOUR_OF_DAY, currentDate.get(Calendar.HOUR_OF_DAY));
					previousDate.set(Calendar.MINUTE, currentDate.get(Calendar.MINUTE));
				}
				
				if(previousDate.get(Calendar.DATE) != currentDate.get(Calendar.DATE)					// If Date has Changed, refresh other panels
						|| previousDate.get(Calendar.MONTH) != currentDate.get(Calendar.MONTH)
						|| previousDate.get(Calendar.YEAR) != currentDate.get(Calendar.YEAR)) {
					
					IslamicUtil.getPrayerTimes(data);			// Calculate Maghrib and other dynamic times

					gregorianPanel.refreshData();
					hijriPanel.refreshData();
					namazTimePanels.values().stream().forEach(panel -> panel.refreshData());
					previousDate.set(Calendar.DATE, currentDate.get(Calendar.DATE));
					previousDate.set(Calendar.MONTH, currentDate.get(Calendar.MONTH));
					previousDate.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));
				}
			}
		}, 0, 1000);
		
		
		try {
			new MosqueDashboardServer(8090).start();
			
//			new Timer().schedule(new TimerTask() {
//				
//				@Override
//				public void run() {
//					try {
//						new MosqueDashboardClient("localhost", 8090);
//						MosqueDashboardClient.sendRequestToServer();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}, 2000);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkForNextNamazTime() {
		
		 String nextNamazTime = Constants.KEY_NAMAZ_TIME_FAJR;
		
		 if(namazTimes.getCurrentHour() > namazTimes.getNamazTimeIsha()[0] 
				 || (namazTimes.getCurrentHour() == namazTimes.getNamazTimeIsha()[0] && namazTimes.getCurrentMinute() > namazTimes.getNamazTimeIsha()[1])) {
			 nextNamazTime = Constants.KEY_NAMAZ_TIME_FAJR;

	     }else if(namazTimes.getCurrentHour() > namazTimes.getNamazTimeMaghrib()[0] 
	    		 || (namazTimes.getCurrentHour() == namazTimes.getNamazTimeMaghrib()[0] && namazTimes.getCurrentMinute() > namazTimes.getNamazTimeMaghrib()[1])) {
	    	 nextNamazTime = Constants.KEY_NAMAZ_TIME_ISHA;

	     }else if(namazTimes.getCurrentHour() > namazTimes.getNamazTimeAsr()[0] 
	    		 || (namazTimes.getCurrentHour() == namazTimes.getNamazTimeAsr()[0] && namazTimes.getCurrentMinute() > namazTimes.getNamazTimeAsr()[1])) {
	    	 nextNamazTime = Constants.KEY_NAMAZ_TIME_MAGHRIB;

	     }else if(namazTimes.getCurrentHour() > namazTimes.getNamazTimeNoon()[0]
	    		 || (namazTimes.getCurrentHour() == namazTimes.getNamazTimeNoon()[0] && namazTimes.getCurrentMinute() >namazTimes.getNamazTimeNoon()[1])) {
	    	 nextNamazTime = Constants.KEY_NAMAZ_TIME_ASR;

	     }else if(namazTimes.getCurrentHour() > namazTimes.getNamazTimeFajr()[0] 
	    		 || (namazTimes.getCurrentHour() == namazTimes.getNamazTimeFajr()[0] && namazTimes.getCurrentMinute() > namazTimes.getNamazTimeFajr()[1])) {
	    	 nextNamazTime = namazTimes.isTodayFriday() ? Constants.KEY_NAMAZ_TIME_JUMUA : Constants.KEY_NAMAZ_TIME_ZUHR;

	     } else {
	    	 nextNamazTime = Constants.KEY_NAMAZ_TIME_FAJR;
	     }

	     // Set all Namaz Time namme colors to Grean
		 namazTimePanels.values().stream().forEach(panel -> panel.nextNamazTime(false));

		 // Set Next namaz time to Cyan
		 namazTimePanels.get(nextNamazTime).nextNamazTime(true);
	}
	
	public static void checkIsNowNamazTime() {
		
		  String overlapNamazTime = null;
	
		  if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeIsha()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeIsha()[1]) {
		    overlapNamazTime = Constants.KEY_NAMAZ_TIME_ISHA;
	
		  }else if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeMaghrib()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeMaghrib()[1]) {
		    overlapNamazTime = Constants.KEY_NAMAZ_TIME_MAGHRIB;
	
		  }else if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeAsr()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeAsr()[1]) {
		    overlapNamazTime = Constants.KEY_NAMAZ_TIME_ASR;
	
		  }else if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeNoon()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeNoon()[1]) {
		    overlapNamazTime = namazTimes.isTodayFriday() ? Constants.KEY_NAMAZ_TIME_JUMUA : Constants.KEY_NAMAZ_TIME_ZUHR;
	
		  }else if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeFajr()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeFajr()[1]) {
		    overlapNamazTime = Constants.KEY_NAMAZ_TIME_FAJR;
	
		  }else if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeIshraq()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeIshraq()[1]) {
		    overlapNamazTime = Constants.KEY_NAMAZ_TIME_ISHRAQ;
	
		  }else if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeDuha()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeDuha()[1]) {
			    overlapNamazTime = Constants.KEY_NAMAZ_TIME_DUHA;
				
		  } else if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeSuhur()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeSuhur()[1]) {
		    overlapNamazTime = Constants.KEY_NAMAZ_TIME_SUHUR;
	
		  }else if(namazTimes.getCurrentHour() == namazTimes.getNamazTimeIftar()[0] && namazTimes.getCurrentMinute() == namazTimes.getNamazTimeIftar()[1]) {
		    overlapNamazTime = Constants.KEY_NAMAZ_TIME_IFTAR;
	
		  }
	
		  // Check if Screen Saver needs to be turned On or Off
		  if(namazTimes.getCurrentHour() == namazTimes.getScreenOnTime()[0] && namazTimes.getCurrentMinute() == namazTimes.getScreenOnTime()[1]) {
//		    if(digitalRead(RELAY_PIN) == HIGH) {
//		      digitalWrite (RELAY_PIN, LOW);
//		    }
		  }
		  if(namazTimes.getCurrentHour() == namazTimes.getScreenOffTime()[0] && namazTimes.getCurrentMinute() == namazTimes.getScreenOffTime()[1]) {
//		    if(digitalRead(RELAY_PIN) == LOW) {
//		      digitalWrite (RELAY_PIN, HIGH);
//		    }
		  }
	
		  if(overlapNamazTime != null) {
			  
			  // Start the blinking
			  startBlinking(overlapNamazTime);
			  
			  // Play Audio for All namaz times, except Iftar
			  if(!overlapNamazTime.equals(Constants.KEY_NAMAZ_TIME_IFTAR)) {
				  VoiceUtil.play(AUDIO_FILE_PATH);
			  }
		  }
	}
	
	public static void startBlinking(String namazTime) {
		blinkData.setOn(true);
		blinkData.setBlinkNamazTime(namazTime);
		
		final Timer blinkTimer = new Timer();
		blinkTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				NamazTimePanel panel = namazTimePanels.get(blinkData.getBlinkNamazTime());
				if(panel != null) {
					panel.setBlink(blinkData.isOn());
				}
				gregorianPanel.setBlink(blinkData.getBlinkNamazTime(), blinkData.isOn());
				blinkData.setOn(!blinkData.isOn());
			}
		}, 0, 1000);
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				blinkTimer.cancel();
				NamazTimePanel panel = namazTimePanels.get(blinkData.getBlinkNamazTime());
				if(panel != null) {
					panel.nextNamazTime(true);
				}
				gregorianPanel.stopBlink(blinkData.getBlinkNamazTime());
			}
		}, 20000);
	}
	
	public static void updateNamazTimeData() {
		
		Calendar currentDate = new GregorianCalendar();
		// Format Data for Easy Usage
		namazTimes.setCurrentHour(currentDate.get(Calendar.HOUR_OF_DAY));
		namazTimes.setCurrentMinute(currentDate.get(Calendar.MINUTE));
		namazTimes.setTodayFriday(currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY);
		namazTimes.setNamazTimeFajr((int[])data.get(Constants.KEY_NAMAZ_TIME_FAJR));
		namazTimes.setNamazTimeZuhr((int[])data.get(Constants.KEY_NAMAZ_TIME_ZUHR));
		namazTimes.setNamazTimeAsr((int[])data.get(Constants.KEY_NAMAZ_TIME_ASR));
		namazTimes.setNamazTimeMaghrib((int[])data.get(Constants.KEY_NAMAZ_TIME_MAGHRIB));
		namazTimes.setNamazTimeIsha((int[])data.get(Constants.KEY_NAMAZ_TIME_ISHA));
		namazTimes.setNamazTimeJumua((int[])data.get(Constants.KEY_NAMAZ_TIME_JUMUA));
		namazTimes.setNamazTimeNoon(namazTimes.isTodayFriday() ? namazTimes.getNamazTimeJumua() : namazTimes.getNamazTimeZuhr());
		namazTimes.setNamazTimeIshraq((int[])data.get(Constants.KEY_NAMAZ_TIME_ISHRAQ));
		namazTimes.setNamazTimeDuha((int[])data.get(Constants.KEY_NAMAZ_TIME_DUHA));
		namazTimes.setNamazTimeSuhur((int[])data.get(Constants.KEY_NAMAZ_TIME_SUHUR));
		namazTimes.setNamazTimeIftar((int[])data.get(Constants.KEY_NAMAZ_TIME_IFTAR));
		namazTimes.setScreenOffTime((int[])data.get(Constants.KEY_SCREENSAVER_ON));
		namazTimes.setScreenOnTime((int[])data.get(Constants.KEY_SCREENSAVER_OFF));
	}

	public static Map<String,Object> getData() {
		return data;
	}
	
	// For Data Saving operations
	
	public static void refreshNamazTime(String namazTimeName) {
		NamazTimePanel panel = namazTimePanels.get(namazTimeName);
		if(panel != null) {
			panel.refreshData();
		}
	}
	
	public static void refreshHijriDateComponents() {
		refreshNamazTime(Constants.KEY_NAMAZ_TIME_MAGHRIB);
		gregorianPanel.refreshData();
		hijriPanel.refreshData();
	}
	
	public static void testAudio() {
		VoiceUtil.play(AUDIO_FILE_PATH);
	}
	
	public static void changeScreenSaverState(boolean isOn) {
		// GPIO Code
	}
	
	public static void restartSystem() {
		try {
			Runtime.getRuntime().exec(new String[]{"reboot"});
			
		} catch (IOException e) {
			/* Do Nothing */
		}
	}
}

//Class for Blink Data
class BlinkData {
	protected boolean isOn;
	protected String blinkNamazTime;
	
	public boolean isOn() {
		return isOn;
	}
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	public String getBlinkNamazTime() {
		return blinkNamazTime;
	}
	public void setBlinkNamazTime(String blinkNamazTime) {
		this.blinkNamazTime = blinkNamazTime;
	}
}

class NamazTimes {
	
	int currentHour;
	int currentMinute;
    boolean isTodayFriday = false;
    int[] namazTimeFajr;
    int[] namazTimeZuhr;
    int[] namazTimeAsr;
    int[] namazTimeMaghrib;
    int[] namazTimeIsha;
    int[] namazTimeJumua;
    int[] namazTimeNoon;
    int[] namazTimeIshraq;
    int[] namazTimeDuha;
    int[] namazTimeSuhur;
    int[] namazTimeIftar;
    int[] screenOnTime;
    int[] screenOffTime;
	 
	public boolean isTodayFriday() {
		return isTodayFriday;
	}
	public void setTodayFriday(boolean isTodayFriday) {
		this.isTodayFriday = isTodayFriday;
	}
	public int[] getNamazTimeFajr() {
		return namazTimeFajr;
	}
	public void setNamazTimeFajr(int[] namazTimeFajr) {
		this.namazTimeFajr = namazTimeFajr;
	}
	public int[] getNamazTimeZuhr() {
		return namazTimeZuhr;
	}
	public void setNamazTimeZuhr(int[] namazTimeZuhr) {
		this.namazTimeZuhr = namazTimeZuhr;
	}
	public int[] getNamazTimeAsr() {
		return namazTimeAsr;
	}
	public void setNamazTimeAsr(int[] namazTimeAsr) {
		this.namazTimeAsr = namazTimeAsr;
	}
	public int[] getNamazTimeMaghrib() {
		return namazTimeMaghrib;
	}
	public void setNamazTimeMaghrib(int[] namazTimeMaghrib) {
		this.namazTimeMaghrib = namazTimeMaghrib;
	}
	public int[] getNamazTimeIsha() {
		return namazTimeIsha;
	}
	public void setNamazTimeIsha(int[] namazTimeIsha) {
		this.namazTimeIsha = namazTimeIsha;
	}
	public int[] getNamazTimeJumua() {
		return namazTimeJumua;
	}
	public void setNamazTimeJumua(int[] namazTimeJumua) {
		this.namazTimeJumua = namazTimeJumua;
	}
	public int[] getNamazTimeNoon() {
		return namazTimeNoon;
	}
	public void setNamazTimeNoon(int[] namazTimeNoon) {
		this.namazTimeNoon = namazTimeNoon;
	}
	public int getCurrentHour() {
		return currentHour;
	}
	public void setCurrentHour(int currentHour) {
		this.currentHour = currentHour;
	}
	public int getCurrentMinute() {
		return currentMinute;
	}
	public void setCurrentMinute(int currentMinute) {
		this.currentMinute = currentMinute;
	}
	public int[] getNamazTimeIshraq() {
		return namazTimeIshraq;
	}
	public void setNamazTimeIshraq(int[] namazTimeIshraq) {
		this.namazTimeIshraq = namazTimeIshraq;
	}
	public int[] getNamazTimeDuha() {
		return namazTimeDuha;
	}
	public void setNamazTimeDuha(int[] namazTimeDuha) {
		this.namazTimeDuha = namazTimeDuha;
	}
	public int[] getNamazTimeSuhur() {
		return namazTimeSuhur;
	}
	public void setNamazTimeSuhur(int[] namazTimeSuhur) {
		this.namazTimeSuhur = namazTimeSuhur;
	}
	public int[] getNamazTimeIftar() {
		return namazTimeIftar;
	}
	public void setNamazTimeIftar(int[] namazTimeIftar) {
		this.namazTimeIftar = namazTimeIftar;
	}
	public int[] getScreenOnTime() {
		return screenOnTime;
	}
	public void setScreenOnTime(int[] screenOnTime) {
		this.screenOnTime = screenOnTime;
	}
	public int[] getScreenOffTime() {
		return screenOffTime;
	}
	public void setScreenOffTime(int[] screenOffTime) {
		this.screenOffTime = screenOffTime;
	}
}
