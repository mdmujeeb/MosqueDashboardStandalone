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
import com.mujeeb.mosquedashboard.util.DateTimeUtil;

public class TimePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected Date currentTime = new Date();
	protected JLabel timeLabel = new JLabel();
	protected JLabel secondsLabel = new JLabel();

	public TimePanel() {
		
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.red));
		setPreferredSize(new Dimension((int)(Main.windowWidth/3), (int)(Main.windowHeight/3)));
		
		setLayout(new GridLayout(2, 1));
		
		timeLabel.setText(DateTimeUtil.formatDate("hh:MM", currentTime));
		timeLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/9));
		timeLabel.setForeground(Color.RED);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		secondsLabel.setText("59");
		secondsLabel.setFont(new Font("Calibri", Font.BOLD, Main.windowWidth/12));
		secondsLabel.setForeground(Color.RED);
		secondsLabel.setHorizontalAlignment(JLabel.CENTER);
		
		add(timeLabel);
		add(secondsLabel);
	}
}
