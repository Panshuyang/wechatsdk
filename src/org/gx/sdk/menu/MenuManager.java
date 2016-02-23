package org.gx.sdk.menu;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxBaseURLs;
import org.gx.common.util.HttpsRequest;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.recompile;


public class MenuManager{
	private Logger logger = Logger.getLogger(MenuManager.class);
	
	/**
	 * 获取所有自定义菜单的详细信息 只能获取到API配置的
	 * @CreateTime 2016-1-8
	 * @Author PSY
	 * @param accessToken
	 * @return
	 */
	public Map<String, Object> getMenusInfo(String accessToken){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.MENUS_GETINFO + accessToken);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") == -1){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取所有自定义菜单的详细信息时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 创建菜单
	 * @CreateTime 2016-1-8
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public Map<String, Object> createMenus(String accessToken, Map<String, Object> params){
		try {
			String postParam = "{\"button\":" + JSONObject.toJSONString(params.get("list")) + "}";
			String result = HttpsRequest.sendPost(WxBaseURLs.MENUS_CREATE + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			
			if("0".equals(resultMap.get("errcode"))){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("创建菜单时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 删除现有的所有菜单
	 * @CreateTime 2016-1-8
	 * @Author PSY
	 * @param accessToken
	 * @return
	 */
	public Map<String, Object> deleteMenus(String accessToken){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.MENUS_DELETE + accessToken);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(resultMap.get("errcode").equals("0")){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("删除现有的所有菜单时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取当前菜单的配置，包含API的和后台的
	 * @createTime 2015-4-23 下午01:52:52
	 * @author PSY
	 */
	public Map<String, Object> getMenuConfig(String accessToken){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.MENUS_GETCONFIG + accessToken);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if(result.indexOf("errcode") == -1){
			}else{
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取当前菜单的配置时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
