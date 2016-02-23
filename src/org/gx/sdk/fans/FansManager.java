package org.gx.sdk.fans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxBaseURLs;
import org.gx.common.util.HttpsRequest;

import com.alibaba.fastjson.JSONObject;

public class FansManager{
	
	private static Logger logger = Logger.getLogger(FansManager.class);
	
	/**
	 * 获取粉丝列表
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param nextOpenId
	 * @return
	 */
	public static Map<String, Object> getFansList(String accessToken, String nextOpenId){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_FANSLIST.replace("[ACCESS_TOKEN]", accessToken) + nextOpenId);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			
			if(result.indexOf("errcode") == -1){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取粉丝列表时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过openId获取粉丝详细信息
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public static Map<String, Object> getFansInfo(String accessToken, String openId){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_FANSINFO.replace("[ACCESS_TOKEN]", accessToken) + openId);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if(result.indexOf("errcode") == -1){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取粉丝详细信息时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 批量获取粉丝详细信息
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> batchGetFansInfo(String accessToken,Map<String, Object> params){
		try {
			String postParam = com.alibaba.fastjson.JSONObject.toJSONString(params);
			System.out.println(postParam);
			String result = HttpsRequest.sendPost(WxBaseURLs.BATCHGET_FANSINFO.replace("[ACCESS_TOKEN]", accessToken), postParam);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if(result.indexOf("errcode") == -1){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("批量获取粉丝详细信息时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 设置粉丝备注
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> setRemark(String accessToken,Map<String, Object> params){
		try {
			String postParam = com.alibaba.fastjson.JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxBaseURLs.SET_REMARK + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if("0".equals(resultMap.get("errcode"))){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("设置粉丝备注名时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
