package com.mujeeb.mosquedashboard.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.main.Main;

public class HijriPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected Date currentTime = new Date();
	protected JLabel dateLabel = new JLabel();
	protected JLabel moonImageLabel = new JLabel();

	public HijriPanel() {
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.red));
		setPreferredSize(new Dimension((int)(Main.windowWidth/3), (int)(Main.windowHeight/3)));
		
		setLayout(new GridLayout(2, 1));
		
		dateLabel.setText("8 Jumada II 1443");
		dateLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		dateLabel.setForeground(Color.GRAY);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		
		moonImageLabel.setText("Moon");
		moonImageLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/22));
		moonImageLabel.setForeground(Color.GRAY);
		moonImageLabel.setHorizontalAlignment(JLabel.CENTER);
		
		add(dateLabel);
		add(moonImageLabel);
	}
}
