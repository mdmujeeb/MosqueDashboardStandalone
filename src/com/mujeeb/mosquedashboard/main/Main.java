package com.mujeeb.mosquedashboard.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.panels.AdvertisementPanel;
import com.mujeeb.mosquedashboard.panels.GregorianPanel;
import com.mujeeb.mosquedashboard.panels.HijriPanel;
import com.mujeeb.mosquedashboard.panels.NamazTimePanel;
import com.mujeeb.mosquedashboard.panels.TimePanel;
import com.mujeeb.mosquedashboard.util.Constants;
import com.mujeeb.mosquedashboard.util.DataUtil;
import com.mujeeb.mosquedashboard.util.IslamicUtil;
import com.mujeeb.mosquedashboard.util.JPanelWithBackgroundImage;

public class Main {
	
	public static int windowHeight = 0;
	public static int windowWidth = 0;
	
	protected static Map<String,Object> data;
	
	protected static GregorianPanel gregorianPanel;
	protected static TimePanel timePanel;
	protected static HijriPanel hijriPanel;
	protected static Map<String,NamazTimePanel> namazTimePanels = new HashMap<String,NamazTimePanel>();

	public static void main(String[] args) {
		
		// VoiceUtil.play("resources/Allahu.mp3");
		
		data = DataUtil.readDataFile();				// Get the stored Data
		IslamicUtil.getPrayerTimes(data);			// Calculate Maghrib and other dynamic times
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setAlwaysOnTop(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		
//		frame.setBackground(Color.BLACK);
//		frame.getContentPane().setBackground(Color.BLACK);
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
		
		frame.setVisible(true);
		frame.repaint();
		
		Calendar previousDate = new GregorianCalendar();
		
		// Start a timer to update things every second.
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Calendar currentDate = new GregorianCalendar();

				if(previousDate.get(Calendar.HOUR_OF_DAY) != currentDate.get(Calendar.HOUR_OF_DAY)		// If Time has Changed, refresh Time panel
						|| previousDate.get(Calendar.MINUTE) != currentDate.get(Calendar.MINUTE)) {

					timePanel.refreshData();
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
	}

	public static Map<String,Object> getData() {
		return data;
	}
}
