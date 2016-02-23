package org.gx.sdk.jssdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxBaseURLs;
import org.gx.common.util.HttpsRequest;
import org.gx.common.util.WxUtilities;

import com.alibaba.fastjson.JSONObject;

public class JsSdkManager{
	
	private static Logger logger = Logger.getLogger(JsSdkManager.class);
	
	/**
	 * 获取JSAPI的ticket
	 * @author PSY
	 * @createTime 2015-3-18 下午12:08:53
	 */
	public static Map<String, Object> getJsAPITicket(String accessToken){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_APITICKET.replace("[ACCESS_TOKEN]", accessToken));
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(!"0".equals(resultMap.get("errcode"))){
				logger.warn("获取JSAPI的ticket时：" + resultMap.get("errmsg"));
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取JSAPI的ticket时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取微信添加卡券JSAPI的ticket
	 * @createTime 2015-7-9 上午10:49:52
	 * @author PSY
	 * @return
	 */
	public static Map<String, Object> getWxCardAPITicket(String accessToken){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_WXCARD_APITICKET.replace("[ACCESS_TOKEN]", accessToken));
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(!"0".equals(resultMap.get("errcode"))){
				logger.warn("获取微信添加卡券JSAPI的ticket时：" + resultMap.get("errmsg"));
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取微信添加卡券JSAPI的ticket时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取JSSDK的签名
	 * @CreateTime 2016-1-9
	 * @Author PSY
	 * @param accessToken
	 * @param url
	 * @param ticket: 两种ticket共用这一个加密算法
	 * @return
	 */
	public static Map<String, Object> getJsSDKSign(String accessToken, String url, String ticket){
		try {
			String noncestr = WxUtilities.createNonceStr(32);
			String timestamp = WxUtilities.getNowTimeString((short)2);
			String[] strings = new String[] { "jsapi_ticket="+ticket,"noncestr="+noncestr,"timestamp="+timestamp,"url="+url};
			String sign = WxUtilities.createSign(strings);
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("noncestr", noncestr);
            resultMap.put("timestamp", timestamp);
            resultMap.put("signature", sign);
            return resultMap;
		} catch (Exception e) {
			logger.warn("获取JSSDK的签名时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
}
