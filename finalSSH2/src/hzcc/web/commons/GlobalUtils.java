package hzcc.web.commons;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GlobalUtils {
	/**
	 * 字符加密为md5
	 * @param originString
	 * @return
	 */
	public static String md5Encode(String originString) {
		byte digest[] = (byte[]) null;
		try {
			MessageDigest alg = MessageDigest.getInstance("MD5");
			alg.update(originString.getBytes());
			digest = alg.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		return byteArrayToHex(digest);
	}
	/**
	 * byte数组变为16进制字符串
	 * @param array
	 * @return
	 */
	public static String byteArrayToHex(byte[] array){
		String hex = "";
		if(array != null && array.length>0){
			for(byte b: array){
				hex += byteToHex(b);
			}
		}
		return hex;
	}
	/**
	 * byte转为16进制字符
	 * @param b
	 * @return
	 */
	public static String byteToHex(byte b){
		String str = Long.toHexString(b);
		if (str.length() < 2)
			str = "0" + str;
		if (str.length() > 2)
			str = str.substring(str.length() - 2, str.length());
		return str;
	}
}
