package org.gx.sdk.base;

import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxBaseURLs;
import org.gx.common.util.HttpsRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: WxBase
 * @Description: 微信的基础接口
 * 包括：获取ACCESSTOKEN、获取微信服务器IP
 * @author PSY
 * @date 2015-3-5 下午03:28:15
 */
public class WxBase{

	private final static Logger logger = Logger.getLogger(HttpsRequest.class.getName());
	
	/**
	 * 获取ACCESSTOKEN
	 * @CreateTime 2016-1-4
	 * @Author PSY
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static Map<String, Object> getAccessToken(String appId, String appSecret){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_ACCESS_TOKEN.replace("[APPID]&secret=[APPSECRET]", appId + "&secret=" + appSecret));
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if(resultMap.get("errcode") != null){
				logger.error("获取ACCESSTOKEN时出错！错误消息如下："+resultMap.get("errmsg"));
			}else{
				resultMap.put("expires_in", System.currentTimeMillis() + Integer.parseInt(resultMap.get("expires_in").toString()) * 1000);
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取ACCESSTOKEN时：" + e.getMessage());
			e.printStackTrace();
			return null;	
		}
	}
	
	/**
	 * 获取微信服务器IP(GET)
	 * @author PSY
	 * @createTime 2015-3-5 下午04:20:31
	 */
	public static Map<String, Object> getWxServerIP(String accessToken){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_WXSERVERIP + accessToken);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(resultMap.get("errcode") != null){
				logger.error("获取微信服务器IP列表出错！错误消息如下：" + resultMap.get("errmsg"));
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取微信服务器IP时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取二次授权的accesstoken
	 * @author PSY
	 * @createTime 2015-3-17 下午05:33:25
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getOAuthAccessToken(String appId, String appSecret, String code){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.getOAuthAccessToken(appId, appSecret, code));
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			return resultMap;
		} catch (Exception e) {
			logger.error("获取二次授权的accesstoken时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
