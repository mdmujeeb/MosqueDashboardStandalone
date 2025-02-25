package com.mujeeb.mosquedashboard.main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.panels.GregorianPanel;
import com.mujeeb.mosquedashboard.panels.HijriPanel;
import com.mujeeb.mosquedashboard.panels.NamazTimePanel;
import com.mujeeb.mosquedashboard.panels.TimePanel;

public class Main {
	
	public static int windowHeight = 0;
	public static int windowWidth = 0;
	
	protected static TimePanel timePanel = new TimePanel();

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new CardLayout());
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("res/background.png"));
//		panel.add(background);
		
		JPanel mainPanel = new JPanel();
		
		windowWidth = frame.getSize().width;
		windowHeight = frame.getSize().height;
		
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(new GregorianPanel(), gbc);
		
		gbc.gridx = 1;
		mainPanel.add(new TimePanel(), gbc);
		
		gbc.gridx = 2;
		mainPanel.add(new HijriPanel(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		mainPanel.add(new NamazTimePanel("Asr", "Asr", "5:15"), gbc);
		
		gbc.gridx = 1;
		mainPanel.add(new NamazTimePanel("Zohor", "Zohor", "1:30"), gbc);
		
		gbc.gridx = 2;
		mainPanel.add(new NamazTimePanel("Fajr", "Fajr", "6:10"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		mainPanel.add(new NamazTimePanel("Juma", "Juma", "1:00"), gbc);
		
		gbc.gridx = 1;
		mainPanel.add(new NamazTimePanel("Isha", "Isha", "8:30"), gbc);
		
		gbc.gridx = 2;
		mainPanel.add(new NamazTimePanel("Maghrib", "Maghrib", "6:32"), gbc);
		
		mainPanel.setOpaque(false);
		panel.add(mainPanel);
		frame.setVisible(true);
		frame.repaint();
	}

}
