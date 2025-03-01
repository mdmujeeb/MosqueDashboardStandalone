package com.mujeeb.mosquedashboard.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.api.client.util.IOUtils;

public class IOUtil {

	@SuppressWarnings("deprecation")
	public static byte[] readInputStream(InputStream inStream) {
		ByteArrayOutputStream oStream = new ByteArrayOutputStream();
		
		try {
			IOUtils.copy(inStream, oStream);
			oStream.close();
			return oStream.toByteArray();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
