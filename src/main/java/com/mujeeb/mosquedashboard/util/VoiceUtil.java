package com.mujeeb.mosquedashboard.util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class VoiceUtil {
	public static void play(final String song) {
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
}
