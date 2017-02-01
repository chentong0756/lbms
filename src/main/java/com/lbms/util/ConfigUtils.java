package com.lbms.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	private static String filePath = ConfigUtils.class.getResource("/").getPath() + "default.properties";

	public ConfigUtils() {

	}
	private static Properties props = new Properties();

	static {
		try {
			System.out.println(filePath);
			props.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		System.out.println(key);
		return props.getProperty(key);

	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}

}