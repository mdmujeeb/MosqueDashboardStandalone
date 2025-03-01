package com.mujeeb.mosquedashboard.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.Constants;
import com.mujeeb.mosquedashboard.util.DateUtil;
import com.mujeeb.mosquedashboard.util.JPanelWithRoundedBorder;

public class NamazTimePanel extends JPanelWithRoundedBorder {

	private static final long serialVersionUID = 1L;
	
	protected String namazTimeName;
	
	protected JLabel englishNameLabel = new JLabel();
	protected JLabel arabicNameLabel = new JLabel();
	protected JLabel timeLabel = new JLabel();
	
	protected String englishName;
	protected String arabicName;
	protected String time;
	
	protected boolean isMaghrib = false;

	public NamazTimePanel(String namazTimeName) {
		
		this.namazTimeName = namazTimeName;
		this.time = "00:00";
		
		switch(namazTimeName) {
			case Constants.KEY_NAMAZ_TIME_FAJR:
				this.isMaghrib = false;
				this.englishName = "Fajr";
				this.arabicName = "الفجر";
				break;
			case Constants.KEY_NAMAZ_TIME_ZUHR:
				this.isMaghrib = false;
				this.englishName = "Zuhr";
				this.arabicName = "ظهر";
				break;
			case Constants.KEY_NAMAZ_TIME_ASR:
				this.isMaghrib = false;
				this.englishName = "Asr";
				this.arabicName = "العصر";
				break;
			case Constants.KEY_NAMAZ_TIME_MAGHRIB:
				this.isMaghrib = true;
				this.englishName = "Maghrib";
				this.arabicName = "المغرب";
				break;
			case Constants.KEY_NAMAZ_TIME_ISHA:
				this.isMaghrib = false;
				this.englishName = "Isha";
				this.arabicName = "عشا";
				break;
			case Constants.KEY_NAMAZ_TIME_JUMUA:
				this.isMaghrib = false;
				this.englishName = "Jumua";
				this.arabicName = "جمعة";
				break;
		}
		
		setOpaque(false);
		setPreferredSize(new Dimension((int)(Main.windowWidth/4), (int)(Main.windowHeight/3.2)));
		
		englishNameLabel.setText(englishName);
		englishNameLabel.setFont(Main.getFontUtil().getCalibriFont().deriveFont(Font.PLAIN, Main.windowWidth/22));
		englishNameLabel.setForeground(Color.WHITE);
		englishNameLabel.setHorizontalAlignment(JLabel.LEFT);
		englishNameLabel.setBorder(BorderFactory.createEmptyBorder(0, isMaghrib ? Main.windowHeight/78 : Main.windowHeight/15, 0, 0));
		englishNameLabel.setOpaque(false);
		
		arabicNameLabel.setText(arabicName);
		arabicNameLabel.setFont(Main.getFontUtil().getArabicFont().deriveFont(Font.PLAIN, Main.windowWidth/30));
		arabicNameLabel.setForeground(Color.WHITE);
		arabicNameLabel.setHorizontalAlignment(JLabel.RIGHT);
		arabicNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, isMaghrib ? Main.windowHeight/78 : Main.windowHeight/15));
		arabicNameLabel.setOpaque(false);
		
		timeLabel.setText(time);
		timeLabel.setFont(Main.getFontUtil().getCalibriFont().deriveFont(Font.BOLD, Main.windowWidth/9));
		timeLabel.setForeground(Color.GREEN);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setOpaque(false);
		timeLabel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/30, 0, 0, 0));
		
		JPanel namesPanel = new JPanel();
		namesPanel.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/30, 0, 0, 0));
		namesPanel.setOpaque(false);
		namesPanel.setLayout(new GridLayout(1, 2));
		namesPanel.add(englishNameLabel);
		namesPanel.add(arabicNameLabel);
		add(namesPanel);
		
		setLayout(new BorderLayout());
		add(namesPanel, BorderLayout.NORTH);
		add(timeLabel, BorderLayout.CENTER);
	}
	
	public void refreshData() {
		
		Map<String,Object> data = Main.getData();
		
		switch(this.namazTimeName) {
			case Constants.KEY_NAMAZ_TIME_FAJR:
				this.time = DateUtil.getFormatted12HourTime((int[])data.get(Constants.KEY_NAMAZ_TIME_FAJR));
				break;
			case Constants.KEY_NAMAZ_TIME_ZUHR:
				this.time = DateUtil.getFormatted12HourTime((int[])data.get(Constants.KEY_NAMAZ_TIME_ZUHR));
				break;
			case Constants.KEY_NAMAZ_TIME_ASR:
				this.time = DateUtil.getFormatted12HourTime((int[])data.get(Constants.KEY_NAMAZ_TIME_ASR));
				break;
			case Constants.KEY_NAMAZ_TIME_MAGHRIB:
				this.time = DateUtil.getFormatted12HourTime((int[])data.get(Constants.KEY_NAMAZ_TIME_MAGHRIB));
				break;
			case Constants.KEY_NAMAZ_TIME_ISHA:
				this.time = DateUtil.getFormatted12HourTime((int[])data.get(Constants.KEY_NAMAZ_TIME_ISHA));
				break;
			case Constants.KEY_NAMAZ_TIME_JUMUA:
				this.time = DateUtil.getFormatted12HourTime((int[])data.get(Constants.KEY_NAMAZ_TIME_JUMUA));
				break;
		}
		
		timeLabel.setText(this.time);
	}
	
	public void nextNamazTime(boolean isTrue) {
		
		timeLabel.setForeground(isTrue ? Color.CYAN : Color.GREEN);
	}
	
	public void setBlink(boolean isOn) {
		
		timeLabel.setForeground(isOn ? Color.RED : Color.GREEN);
	}
}
