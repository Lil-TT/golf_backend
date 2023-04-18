package com.qinhu.demo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Tool {
	public static boolean isEmpty(String s) {
		return (s == null) || ("".equals(s)) || (s.equals("null"));
	}

	public static boolean notEmpty(String s) {
		return (s != null) && (!"".equals(s)) && (!"null".equals(s));
	}

	public static Field getFieldByFieldName(Object obj, String fieldName) {
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException localNoSuchFieldException) {
			}
		}
		return null;
	}

	public static Object getValueByFieldName(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field field = getFieldByFieldName(obj, fieldName);
		Object value = null;
		if (field != null) {
			if (field.isAccessible()) {
				value = field.get(obj);
			} else {
				field.setAccessible(true);
				value = field.get(obj);
				field.setAccessible(false);
			}
		}
		return value;
	}

	public static void setValueByFieldName(Object obj, String fieldName, Object value)
			throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field field = obj.getClass().getDeclaredField(fieldName);
		if (field.isAccessible()) {
			field.set(obj, value);
		} else {
			field.setAccessible(true);
			field.set(obj, value);
			field.setAccessible(false);
		}
	}

	public static String[] strToArray(String result, String splitString) {
		return result.split(splitString);
	}

	public static String getIp(HttpServletRequest request) {
		String gmtIp = "";
		if (request.getHeader("x-forwarded-for") == null) {
			gmtIp = request.getRemoteAddr();
		} else {
			gmtIp = request.getHeader("x-forwarded-for");
		}
		return gmtIp;
	}

	public static String subLastString(String name) {
		if ((name == null) || ("".equals(name))) {
			return "";
		}
		name = name.substring(0, name.length() - 1);
		return name;
	}

	@SuppressWarnings("resource")
	public static String readTxtFile(String fileP) {
		try {
			String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../";
			filePath = filePath.replaceAll("file:/", "");
			filePath = filePath.replaceAll("%20", " ");
			filePath = filePath.trim() + fileP.trim();
			if (filePath.indexOf(":") != 1) {
				filePath = File.separator + filePath;
			}
			String encoding = "utf-8";
			File file = new File(filePath);
			if ((file.isFile()) && (file.exists())) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);

				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				if ((lineTxt = bufferedReader.readLine()) != null) {
					return lineTxt;
				}
				bufferedReader.close();
				read.close();
			} else {
				System.out.println("文件不存在无法读取:" + filePath);
			}
		} catch (Exception e) {
			System.out.println("读取文件异常:" + e);
		}
		return "";
	}

	public static String readFile(String path) throws IOException {
		StringBuilder builder = new StringBuilder();
		String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../";
		filePath = filePath.replaceAll("file:/", "");
		filePath = filePath.replaceAll("%20", " ");
		filePath = filePath.trim() + path.trim();
		if (filePath.indexOf(":") != 1) {
			filePath = File.separator + filePath;
		}
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
			BufferedReader bfReader = new BufferedReader(reader);

			String tmpContent = null;
			while ((tmpContent = bfReader.readLine()) != null) {
				builder.append(tmpContent);
			}
			bfReader.close();
		} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
		}
		return builder.toString().replaceAll("/\\*[\\s\\S]*?\\*/", "");
	}

	public static String getClasspath() {
		String path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../")
				.replaceAll("file:/", "").replaceAll("%20", " ").trim();
		if (path.indexOf(":") != 1) {
			path = File.separator + path;
		}
		return path;
	}

	public static String getClassResources() {
		String path = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))
				.replaceAll("file:/", "").replaceAll("%20", " ").trim();
		if (path.indexOf(":") != 1) {
			path = File.separator + path;
		}
		return path;
	}

	public static String subStringLastChar(String string) {
		if ((string != null) && (!string.equals(""))) {
			string = string.substring(0, string.length() - 1);
			return string;
		}
		return null;
	}

	public static String getCode(int N) {
		String code = "";
		for (int i = 0; i < N; i++) {
			code = code + randomChar();
		}
		return code;
	}

	public static char randomChar() {
		Random r = new Random();
		String s = "0123456789";
		return s.charAt(r.nextInt(s.length()));
	}
}
