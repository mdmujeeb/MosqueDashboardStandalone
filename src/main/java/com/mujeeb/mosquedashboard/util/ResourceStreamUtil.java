package com.mujeeb.mosquedashboard.util;

import java.awt.Image;
import java.io.InputStream;

import javax.swing.ImageIcon;

public class ResourceStreamUtil {

	public InputStream getResourceStream(String resourcePath) {
		return getClass().getClassLoader().getResourceAsStream(resourcePath);
	}
	
	public byte[] getResourceData(String resourcePath) {
		return IOUtil.readInputStream(getResourceStream(resourcePath));
	}
	
	public Image getResourceImage(String resourcePath) {
		return new ImageIcon(getResourceData(resourcePath)).getImage();
	}
	
	public ImageIcon getResourceImageIcon(String resourcePath) {
		return new ImageIcon(getResourceData(resourcePath));
	}
}
