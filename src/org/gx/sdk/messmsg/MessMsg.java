/**
 * 
 */
package org.gx.sdk.messmsg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.gx.common.url.WxBaseURLs;
import org.gx.common.util.HttpsRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author PSY
 * @createTime 2016-1-12 下午04:52:12
 */
public class MessMsg {
	
	private static Logger logger = Logger.getLogger(MessMsg.class);
	
	/**
	 * 群发消息
	 * @CreateTime 2016-1-12
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> sendMessMsg(String accessToken, Map<String, Object> params){
		try {
			StringBuilder sb = new StringBuilder();
			String sendType = params.get("send_type").toString(); 
			Map<String, Object> resultMap = new HashMap<String, Object>();
			String postParam = "";
			String result = "";
			if(sendType.equals("all")){
				//发送到所有
				sb.append("{\"filter\":{\"is_to_all\":true},");
				postParam = dealMsgType(sb, params.get("msg_type").toString(), params.get("msg").toString());
				result = sendMessToAll(accessToken, postParam);
			}else if(sendType.equals("group")){
				//分组发送
				String groupId = params.get("group_id").toString();
				if(groupId == null || groupId.equals("")){
					resultMap.put("errcode", 101);
					resultMap.put("errmsg", "parameter 'group_id' is missing");
				}else{
					sb.append("{\"filter\":{\"is_to_all\":false,\"group_id\":\"" + groupId + "\"},");
					postParam = dealMsgType(sb, params.get("msg_type").toString(), params.get("msg").toString());
					result = sendMessByGroup(accessToken, postParam);
				}
			}else if(sendType.equals("openid")){
				//openid发送
				List<String> openidList = (List<String>) params.get("openid_list");
				if(openidList == null || openidList.size() > 0){
					resultMap.put("errcode", 101);
					resultMap.put("errmsg", "parameter 'openid_list' is missing");
				}else{
					sb.append("{\"touser\":" + JSONArray.toJSONString(openidList) + ",");
					postParam = dealMsgType(sb, params.get("msg_type").toString(), params.get("msg").toString());
					result = sendMessByOpenId(accessToken, postParam);
				}
			}
			if(resultMap.size() == 0){
				resultMap = (Map<String, Object>) JSONObject.toJSON(result);
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("群发消息时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 群发给所有人
	 * @CreateTime 2016-1-12
	 * @Author PSY
	 * @param accessToken
	 * @param postParam
	 * @return
	 */
	public static String sendMessToAll(String accessToken, String postParam){
		return HttpsRequest.sendPost(WxBaseURLs.MESSMSG_GROUPSEND + accessToken, postParam);
	}

	/**
	 * 根据分组群发
	 * @CreateTime 2016-1-12
	 * @Author PSY
	 * @param accessToken
	 * @param postParam
	 * @return
	 */
	public static String sendMessByGroup(String accessToken, String postParam){
		return HttpsRequest.sendPost(WxBaseURLs.MESSMSG_GROUPSEND + accessToken, postParam);
	}
	
	/**
	 * 根据openId列表群发
	 * @CreateTime 2016-1-12
	 * @Author PSY
	 * @param accessToken
	 * @param postParam
	 * @return
	 */
	public static String sendMessByOpenId(String accessToken, String postParam){
		return HttpsRequest.sendPost(WxBaseURLs.MESSMSG_OPENIDSEND + accessToken, postParam);
	}
	
	/**
	 * 根据不同类型的消息类型构建POST参数
	 * @CreateTime 2016-1-12
	 * @Author PSY
	 * @param sb
	 * @param msgType
	 * @param msg
	 * @return
	 */
	public static String dealMsgType(StringBuilder sb, String msgType, String msg) {
		if(msgType.equals("mpnews")){
			sb.append("\"mpnews\":{\"media_id\":\"" + msg + "\"},\"msgtype\":\"mpnews\"");
		}else if(msgType.equals("text")){
			sb.append("\"text\":{\"content\":\"" + msg + "\"},\"msgtype\":\"text\"}");
		}else if(msgType.equals("voice")){
			sb.append("\"voice\":{\"media_id\":\"" + msg + "\"},\"msgtype\":\"voice\"}");
		}else if(msgType.equals("image")){
			sb.append("\"image\":{\"media_id\":\"" + msg + "\"},\"msgtype\":\"image\"}");
		}else if(msgType.equals("mpvideo")){
			sb.append("\"mpvideo\":{\"media_id\":\"" + msg + "\",},\"msgtype\":\"mpvideo\"}");
		}
		return sb.toString();
	}
	
	/**
	 * 删除群发
	 * @CreateTime 2016-1-12
	 * @Author PSY
	 * @param accessToken
	 * @param msgid
	 * @return
	 */
	public static Map<String, Object> deleteSentMessMsg(String accessToken, String msgid){
		try {
			String postParam = "{\"msg_id\":" + msgid + "}";
			String result = HttpsRequest.sendPost(WxBaseURLs.MESSMSG_DELETE + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.toJSON(result);
			return resultMap;
		} catch (Exception e) {
			logger.error("删除群发时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 预览群发消息
	 * @CreateTime 2016-1-12
	 * @Author PSY
	 * @param accessToken
	 * @param params
	 * @return
	 */
	public static Map<String, Object> previewMessMsg(String accessToken, Map<String, Object> params){
		try {
			StringBuilder sb = new StringBuilder();
			String previewer = params.get("openid").toString();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if(previewer == null || previewer.equals("")){
				resultMap.put("errcode", 101);
				resultMap.put("errmsg", "parameter openid is missing");
			}else{
				sb.append("{\"touser\":" + previewer + ",");
				String postParam = dealMsgType(sb, params.get("msg_type").toString(), params.get("msg").toString());;
				String result = HttpsRequest.sendPost(WxBaseURLs.MESSMSG_PREVIEW + accessToken, postParam);
				resultMap = (Map<String, Object>) JSONObject.toJSON(result);
			}
			return resultMap;
		} catch (Exception e) {
			logger.error("" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询群发信息发送状态
	 * @CreateTime 2016-1-13
	 * @Author PSY
	 * @param accessToken
	 * @param msgid
	 * @return
	 */
	public static Map<String, Object> checkSendState(String accessToken, String msgid){
		try {
			String postParam = "{\"msg_id\":" + msgid + "}";
			String result = HttpsRequest.sendPost(WxBaseURLs.MESSMSG_STATUS + accessToken, postParam);
			Map<String, Object> resultMap = (Map<String, Object>) JSONObject.toJSON(result);
			return resultMap;
		} catch (Exception e) {
			logger.error("查询群发信息发送状态时：" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
