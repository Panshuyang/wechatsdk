/**
 * @Title: MeterialAction.java
 * @Package com.psy.module.meterial.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author PSY
 * @date 2015-3-18 下午05:00:18
 * @version V1.0
 */
package org.gx.sdk.material;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxBaseURLs;
import org.gx.common.util.HttpRequest;
import org.gx.common.util.HttpsRequest;

import com.alibaba.fastjson.JSONObject;

public class MaterialManager{
	private static Logger logger = Logger.getLogger(MaterialManager.class);

	/**
	 * 上传临时素材
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accteeToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> uploadTempMeterial(String accteeToken, Map<String, Object> params) {
		try {
			String result = HttpsRequest.uploadPost(WxBaseURLs.MATERIAL_TEMP_UPLOAD.replace("[ACCESS_TOKEN]", accteeToken)
					+ params.get("type"), (File)params.get("media"));
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if (result.indexOf("errcode") >= 0) {
			} else {
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("上传临时素材时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取临时素材
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 */
	public static void getMeterialByMidiaId(String accessToken, Map<String, Object> params) {
		HttpsRequest.downGet(WxBaseURLs.MATERIAL_TEMP_GET.replace(
				"[ACCESS_TOKEN]", accessToken)
				+ params.get("media_id"), params.get("destPath").toString(),
				params.get("fileName").toString());
	}

	/**
	 * 上传永久图文素材
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> uploadPermNews(String accessToken, Map<String, Object> params) {
		try {
			String postParam = "{\"articles\":" + JSONObject.parse(params.get("artical").toString()) + "}";
			System.out.println(postParam);
			String result = HttpsRequest.sendPost(WxBaseURLs.MATERIAL_PERMNEWS_UPLOAD + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			return resultMap;
		} catch (Exception e) {
			logger.error("上传永久图文素材时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * 上传永久其他素材
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> uploadPermMaterial(String accessToken, Map<String, Object> params) {
		try {
			String result = HttpsRequest.uploadPost(WxBaseURLs.MATERIAL_PERM_UPLOAD + accessToken, (File)params.get("media"));
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if (result.indexOf("errcode") >= 0) {
			} else {
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("上传永久其他素材时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取永久素材
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 */
	public static void getPermMaterial(String accessToken, Map<String, Object> params) {
		String postParam = "{\"media_id\":\"" + params.get("media_id") + "\"}";
		HttpRequest.downPost(WxBaseURLs.MATERIAL_PERM_GET + accessToken, postParam, params.get("destPath").toString(), params.get("filaName").toString());
	}

	/**
	 * 获取各种素材的个数
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @return
	 */
	public static Map<String, Object> getMaterialCount(String accessToken) {
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.MATERIAL_COUNT + accessToken);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			return resultMap;
		} catch (Exception e) {
			logger.error("获取各种素材的个数时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取素材列表
	 * @CreateTime 2016-1-7
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getMaterialList(String accessToken, Map<String, Object> params) {
		try {
			String postParam = JSONObject.toJSONString(params);
			String result = HttpRequest.sendPost(WxBaseURLs.MATERIAL_LIST + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
			if (result.indexOf("errcode") >= 0) {
			} else {
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("获取素材列表时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
