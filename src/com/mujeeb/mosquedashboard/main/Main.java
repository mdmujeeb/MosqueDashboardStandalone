package com.mujeeb.mosquedashboard.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.panels.AdvertisementPanel;
import com.mujeeb.mosquedashboard.panels.GregorianPanel;
import com.mujeeb.mosquedashboard.panels.HijriPanel;
import com.mujeeb.mosquedashboard.panels.NamazTimePanel;
import com.mujeeb.mosquedashboard.panels.TimePanel;
import com.mujeeb.mosquedashboard.util.JPanelWithBackgroundImage;
import com.mujeeb.mosquedashboard.util.VoiceUtil;

public class Main {
	
	public static int windowHeight = 0;
	public static int windowWidth = 0;
	
	protected static TimePanel timePanel = new TimePanel();

	public static void main(String[] args) {
		
		VoiceUtil.play("resources/Allahu.mp3");
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
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
		
		JPanel centerPanel = new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerPanel.add(new GregorianPanel(), gbc);
		
		gbc.gridx = 1;
		centerPanel.add(new TimePanel(), gbc);
		
		gbc.gridx = 2;
		centerPanel.add(new HijriPanel(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		centerPanel.add(new NamazTimePanel(false, "Asr", "العصر", "5:15"), gbc);
		
		gbc.gridx = 1;
		centerPanel.add(new NamazTimePanel(false, "Zuhr", "ظهر", "1:30"), gbc);
		
		gbc.gridx = 2;
		centerPanel.add(new NamazTimePanel(false, "Fajr", "الفجر", "6:10"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		centerPanel.add(new NamazTimePanel(false, "Jumua", "جمعة", "1:00"), gbc);
		
		gbc.gridx = 1;
		centerPanel.add(new NamazTimePanel(false, "Isha", "عشا", "8:30"), gbc);
		
		gbc.gridx = 2;
		centerPanel.add(new NamazTimePanel(true, "Maghrib", "المغرب", "6:32"), gbc);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(new AdvertisementPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		frame.repaint();
	}

}
