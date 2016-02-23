package org.gx.sdk.data;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxStatisticsURLs;
import org.gx.common.util.HttpsRequest;

import com.alibaba.fastjson.JSONObject;

public class DataStatistics{
	
	private static Logger logger = Logger.getLogger(DataStatistics.class);
	
	/**
	 * 获取用户增减数据（时间跨度最多7天）
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUserSummary(String accessToken, Map<String, Object> params){
		try{
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_USERSUMMARY + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取用户增减数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取累计用户数据（时间跨度7天）
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUserCumulate(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_USERCUMULATE + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取累计用户数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 获取图文群发每日数据（时间跨度1天）
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getArticleSummary(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_ARTICLESUMMARY + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取图文群发每日数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取图文群发总数据（时间跨度1天）
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getArticleTotal(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_ARTICLETOTAL + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取图文群发总数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取图文统计数据（时间跨度3天）
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUserRead(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_USERREAD + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取图文统计数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取图文统计分时数据（时间跨度1天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUserReadHour(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_USERREADHOUR + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取图文统计分时数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取图文分享转发数据（时间跨度7天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUserShare(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_USERSHARE + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取图文分享转发数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取图文分享转发分时数据（时间跨度1天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUserShareHour(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_USERSHAREHOUR + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取图文分享转发分时数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取消息发送概况数据（时间跨度7天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUpstreamMsg(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_UPSTREAMMSG + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取消息发送概况数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取消息分送分时数据（时间跨度1天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUpstreamMsgHour(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_UPSTREAMMSGHOUR + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取消息分送分时数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取消息发送周数据（时间跨度30天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUpstreamMsgWeek(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_UPSTREAMMSGWEEK + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取消息发送周数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取消息发送月数据（时间跨度30天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUpstreamMsgMonth(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_UPSTREAMMSGMONTH + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取消息发送月数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取消息发送分布数据（时间跨度15天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUpstreamMsgDist(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_UPSTREAMMSGDIST + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取消息发送分布数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取消息发送分布周数据（时间跨度30天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUpstreamMsgDistweek(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_UPSTREAMMSGDISTWEEK + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取消息发送分布周数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取消息发送分布月数据（时间跨度30天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getUpstreamMsgDistMonth(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_UPSTREAMMSGDISTMONTH + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取消息发送分布月数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取接口分析数据（时间跨度30天）
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getInterfaceSummary(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_INTERFACESUMMARY + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取接口分析数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取接口分析分时数据（时间跨度1天）
	 * @author PSY
	 * @createTime 2015-3-18 下午02:06:25
	 * @param vo
	 */
	public static Map<String, Object> getInterfaceSummaryHour(String accessToken, Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxStatisticsURLs.GET_INTERFACESUMMARYHOUR + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") >= 0){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取接口分析分时数据时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}