package org.gx.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;

/**
 * 微信接口需要用到的一些工具方法
 * @author PSY
 * @createTime 2016-1-9
 */
public class WxUtilities {
	private static String randomBase = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
	
	/**
	 * 通过一些参数获取签名
	 * @CreateTime 2016-1-9
	 * @Author PSY
	 * @param strings
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String createSign(String[] strings) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		int i = 0;
		Arrays.sort(strings);
		StringBuffer sb = new StringBuffer();
		for (String str : strings) {
			if(i == 0){
				sb.append(str);
				i = i+1;
			}else{
				sb.append("&"+str);
			}
		}
		// SHA1加密
		System.out.println(sb.toString());
		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	    crypt.reset();
	    crypt.update(sb.toString().getBytes("UTF-8"));
	    String sign = byteToHex(crypt.digest());
	    return sign;
	}
	
	/**
	 * 将byte的签名转换成String
	 * @CreateTime 2016-1-9
	 * @Author PSY
	 * @param hash
	 * @return
	 */
	private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
	
	/**
	 * 获取动态位数的随机字符串
	 * @CreateTime 2016-1-9
	 * @Author PSY
	 * @param length
	 * @return
	 */
	public static String createNonceStr(int length) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(randomBase.length());
			sb.append(randomBase.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * 根据不同的格式指定
	 * @CreateTime 2016-1-12
	 * @Author PSY
	 * @param type 1-毫秒数;2-秒数;
	 * @return
	 */
	public static String getNowTimeString(short type){
		long now = System.currentTimeMillis();
		String ntStr = "";
		switch (type) {
		case 1:
			//毫秒数
			ntStr = String.valueOf(now);
			break;

		case 2:
			//秒数
			ntStr = String.valueOf((long)now/1000);
			break;

		default:
			ntStr = "";
			break;
		}
		return ntStr;
	}
	
	public static void main(String[] args) {
		System.out.println(getNowTimeString((short)2));
	}
}
