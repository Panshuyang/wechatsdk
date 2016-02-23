package org.gx.sdk.fans;

import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxBaseURLs;
import org.gx.common.util.HttpsRequest;

import com.alibaba.fastjson.JSONObject;

public class GroupManager{
	
	private static Logger logger = Logger.getLogger(GroupManager.class);
	
	/**
	 * 获取分组信息
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @return
	 */
	public static Map<String, Object> getAllGroups(String accessToken){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GROUP_SEARCHALL + accessToken);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if(result.indexOf("errcode") == -1){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("查询所有分组时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 创建分组
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> createGroup(String accessToken,Map<String, Object> params){
		try {
			String postParam = "{\"group\":"+JSONObject.toJSONString(params)+"}";
			String result = HttpsRequest.sendPost(WxBaseURLs.GROUP_CREATE + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if(result.indexOf("errcode") == -1){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("创建新分组时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查找某个用户所在组的ID
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getGroupByOpenId(String accessToken,Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxBaseURLs.GROUP_SEARCHBYOPENID + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if(resultMap.get("errcode") == null){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("查找某个用户所在组的ID时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 修改分组名
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> modifyGroupName(String accessToken,Map<String, Object> params){
		try {
			String postParam = "{\"group\":" + JSONObject.toJSONString(params) + "}";
			String result = HttpsRequest.sendPost(WxBaseURLs.GROUP_SETNAME + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if("0".equals(resultMap.get("errcode"))){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("修改分组名时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 移动用户分组
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> moveFansToGroup(String accessToken,Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxBaseURLs.GROUP_MOVEFANS + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if("0".equals(resultMap.get("errcode"))){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("移动用户分组时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 批量移动用户分组
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> batchMoveFans(String accessToken,Map<String, Object> params){
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpsRequest.sendPost(WxBaseURLs.GROUP_BATCHMOVEFANS + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if("0".equals(resultMap.get("errcode"))){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("批量移动用户分组时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 删除分组
	 * @CreateTime 2016-1-6
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> deleteGroup(String accessToken,Map<String, Object> params){
		try {
			String postParam = "{\"group\":" + JSONObject.toJSONString(params) + "}";
			String result = HttpsRequest.sendPost(WxBaseURLs.GROUP_DELETE, postParam);
			Map<String, Object> resultMap = (Map<String, Object>)JSONObject.parse(result);
			if("0".equals(resultMap.get("errcode"))){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("删除分组时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
