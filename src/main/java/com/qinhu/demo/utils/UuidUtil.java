package com.qinhu.demo.utils;

import java.util.UUID;

public class UuidUtil {
	public static String get32UUID() {
		String result = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return result;
	}

	public static void main(String[] args) {
		System.out.println(get32UUID());
	}
}
