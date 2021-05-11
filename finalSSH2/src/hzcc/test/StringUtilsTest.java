package hzcc.test;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils是apache提供的一个工具类，
 * 在commons-lang3的jar包中
 * 该类是apache提供的一个对String操作的工具类
 * @author likai
 *
 */
public class StringUtilsTest {
	public static void main(String[] args) {
		String str1=null;
		String str2="";
		String str3="  ";
		System.out.println(StringUtils.isEmpty(str1));//true
		System.out.println(StringUtils.isEmpty(str2));//true
		System.out.println(StringUtils.isEmpty(str3));//false
		System.out.println("-------");
		System.out.println(StringUtils.isBlank(str1));//true
		System.out.println(StringUtils.isBlank(str1));//true
		System.out.println(StringUtils.isBlank(str1));//true
		StringUtils.isNotBlank(str1);
		StringUtils.isNotBlank(str1);
	}
}
