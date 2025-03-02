package com.mujeeb.mosquedashboard.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.JPanelWithRoundedBorder;
import com.mujeeb.mosquedashboard.util.ResourceStreamUtil;

public class AdvertisementPanel extends JPanelWithRoundedBorder {

	private static final long serialVersionUID = 1L;
	
    public AdvertisementPanel() {
		
		setOpaque(false);
		setPreferredSize(new Dimension((int)(Main.windowWidth), (int)(Main.windowHeight/24)));
		
		setLayout(new GridLayout(1,3));
		add(getTextPanel("resources/phone-icon.png", "9880506766"));
		add(getTextPanel("resources/developer-icon.png", "Mujeeb Mohammad"));
		add(getTextPanel("resources/email-icon.png", "mohammad.mujeeb@gmail.com"));
	}
	
	protected JPanel getTextPanel(String iconImagePath, String text) {
		Color textColor = Color.WHITE;

		JLabel image = new JLabel();
		image.setIcon(new ResourceStreamUtil().getResourceImageIcon(iconImagePath));
		image.setSize(28, 28);
		image.setHorizontalAlignment(JLabel.CENTER);
		image.setBorder(BorderFactory.createEmptyBorder(0, 0, Main.windowHeight/120, 0));
		JLabel label = new JLabel();
		label.setText(text);
		label.setFont(Main.getFontUtil().getCalibriFont().deriveFont(Font.BOLD, Main.windowWidth/60));
		label.setForeground(textColor);
		label.setSize(Main.windowWidth/3, 30);
		label.setHorizontalAlignment(JLabel.CENTER);
//		label.setBorder(BorderFactory.createEmptyBorder(Main.windowHeight/120, 0, 0, 0));
		JPanel containerPanel = new JPanel();
		containerPanel.setOpaque(false);
		containerPanel.setLayout(new FlowLayout());
		containerPanel.add(image);
		containerPanel.add(label);
		return containerPanel;
	}
}
