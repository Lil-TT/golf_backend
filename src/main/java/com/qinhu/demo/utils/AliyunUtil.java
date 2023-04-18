package com.qinhu.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.qinhu.demo.common.Const;

public class AliyunUtil {
	public static OSSClient getOSSClient() {
		String endpoint = Const.ALIYUN_ENDPOINT;
		String accessKeyId = Const.ALIYUN_KEY;
		String accessKeySecret = Const.ALIYUN_AKS;
		return new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	public static void setObjectAcl(String bucketName, String ObjectName) {
		OSSClient client = getOSSClient();

		client.setObjectAcl(bucketName, ObjectName, CannedAccessControlList.PublicRead);

		client.shutdown();
	}

	public static String getOssObjectUrl(String bucketName, String ObjectName) {
		return "http://" + bucketName + "." + "oss-cn-shenzhen.aliyuncs.com" + "/" + ObjectName;
	}

	public static String getOssObjectUrls(String bucketName, String ObjectName) {
		return "https://" + bucketName + "." + "oss-cn-shenzhen.aliyuncs.com" + "/" + ObjectName;
	}

	public static String getOssObjectName(String OssUrl) {
		String name = OssUrl.substring(OssUrl.lastIndexOf(Const.ALIYUN_ENDPOINT) + 29, OssUrl.length());
		return name;
	}

	public static void deleteObject(String bucketName, String ObjectName) {
		OSSClient client = getOSSClient();
		client.deleteObject(bucketName, ObjectName);
		client.shutdown();
	}

	public static String uploadFile(String path) throws FileNotFoundException {
		OSSClient client = getOSSClient();
		File file = new File(path);
		InputStream inputStream = new FileInputStream(file);
		String key = DateUtil.getTime() + "/" + file.getName();
		client.putObject(Const.ALIYUN_ASSOCIATION_ALBUM, key, inputStream);
		client.setObjectAcl(Const.ALIYUN_ASSOCIATION_ALBUM, key, CannedAccessControlList.PublicRead);
		String url = AliyunUtil.getOssObjectUrls(Const.ALIYUN_ASSOCIATION_ALBUM, key);
		client.shutdown();
		return url;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String path = "C:/Users/hekai/Desktop/DS-DIGII-3.ttf";
		System.out.println(AliyunUtil.uploadFile(path));
	}
}
