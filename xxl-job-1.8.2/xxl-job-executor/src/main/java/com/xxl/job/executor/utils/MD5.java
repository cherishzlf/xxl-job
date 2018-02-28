package com.xxl.job.executor.utils;

import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * MD5 算法 用于用户密码的生成与验证
 */
@SuppressWarnings("restriction")
public class MD5 {
	private static final Logger logger = Logger.getLogger(MD5.class);

	public static final String getMD5Code(String str) {
		String md5str = null;

		try {

			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			// 加密后的字符串
			md5str = base64en.encode(md5.digest(str.getBytes("utf-8")));

		} catch (Exception e) {
			logger.info("MD5.class-生成MD5数据异常！！！");
		}

		return md5str;
	}

}
