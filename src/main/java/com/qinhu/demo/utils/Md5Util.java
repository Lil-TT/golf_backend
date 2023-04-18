package com.qinhu.demo.utils;

import java.security.MessageDigest;

/**
 * 生成MD5加密字符串
 * 
 * @author hekai2020年6月1日
 *
 */
public class Md5Util {
	public static String getMD5(String str) {
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");

			byte[] array = instance.digest(str.getBytes("UTF-8"));

			StringBuilder sb = new StringBuilder();
			byte[] arrayOfByte1;
			int j = (arrayOfByte1 = array).length;
			for (int i = 0; i < j; i++) {
				byte item = arrayOfByte1[i];

				sb.append(Integer.toHexString(item & 0xFF | 0x100).substring(1, 3));
			}
			return sb.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
