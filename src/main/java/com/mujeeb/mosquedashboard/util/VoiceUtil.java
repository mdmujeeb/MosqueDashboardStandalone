package com.mujeeb.mosquedashboard.util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

public class VoiceUtil {
	public static void playFile(final String song) {
		new Thread() {
			@Override
			public void run() {
				try {
					FileInputStream fis     = new FileInputStream(song);
			        BufferedInputStream bis = new BufferedInputStream(fis);
			        Player player = new Player(bis);
			        player.play();
			        player.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}.start();
	}
	
	public static void playStream(final InputStream songStream) {
		new Thread() {
			@Override
			public void run() {
				try {
			        BufferedInputStream bis = new BufferedInputStream(songStream);
			        Player player = new Player(bis);
			        player.play();
			        player.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}.start();
	}
}
