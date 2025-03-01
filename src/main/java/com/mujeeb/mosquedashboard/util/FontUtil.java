package com.mujeeb.mosquedashboard.util;

import java.awt.Font;

public class FontUtil {
	
	public static final String CALIBRI_FONT_PATH = "resources/Calibri.ttf";
	public static final String ARABIC_FONT_PATH = "resources/KFGQPC Uthmanic Script HAFS Regular.otf";
	
	protected Font calibriFont;
	protected Font arabicFont;
	
	protected ResourceStreamUtil resourceUtil = new ResourceStreamUtil();

	public FontUtil() {
	
		try {
			calibriFont = Font.createFonts(resourceUtil.getResourceStream(CALIBRI_FONT_PATH))[0];
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			arabicFont = Font.createFonts(resourceUtil.getResourceStream(ARABIC_FONT_PATH))[0];
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public Font getCalibriFont() {
		return calibriFont;
	}

	public Font getArabicFont() {
		return arabicFont;
	}	
}
