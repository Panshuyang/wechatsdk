package org.gx.sdk.template;

import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxBaseURLs;
import org.gx.common.util.HttpsRequest;

import com.alibaba.fastjson.JSONObject;

public class TemplateManager{
	private static Logger logger = Logger.getLogger(TemplateManager.class);
	
	/**
	 * 修改模版的行业设置--一个月修改一次~慎用！
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> setIndustries(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxBaseURLs.TPLT_SETINDUSTRY + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			return resultMap;
		} catch (Exception e) {
			logger.error("设置模版行业信息时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 模版ID--短的换长的
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public Map<String, Object> gettemplateId(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxBaseURLs.TPLT_GET_LONGID + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if("0".equals(resultMap.get("errcode"))){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取长模版ID时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 发送模版消息
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public Map<String, Object> sendTemplateMsg(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxBaseURLs.TPLT_SENDMSG + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if("0".equals(resultMap.get("errcode"))){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("发送模版消息时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
