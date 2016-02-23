package org.gx.common.url;

import java.text.MessageFormat;

/**
 * @ClassName: WxBaseURLs
 * @Description: 微信常用接口URL地址
 */
public class WxBaseURLs {

	/**
	 * 基础接口
	 */
	// 获取Access_token的URL(GET请求)
	public static String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=[APPID]&secret=[APPSECRET]";
	
	// 获取微信服务器IP地址
	public static String GET_WXSERVERIP = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";

	/**
	 * 群发接口
	 */
	// 分组群发消息URL
	public static String MESSMSG_GROUPSEND = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";
			
	// 根据openId列表群发URL
	public static String MESSMSG_OPENIDSEND = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";
			
	// 删除群发消息URL
	public static String MESSMSG_DELETE = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=";
			
	// 预览群发消息URL
	public static String MESSMSG_PREVIEW = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=";
			
	// 查询群发消息状态URL
	public static String MESSMSG_STATUS = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=";
			

	/**
	 * 自定义菜单接口
	 */
	// 创建自定义菜单url
	public static String MENUS_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
			
	// 获取自定义菜单信息 url（仅对API设置的菜单有效）
	public static String MENUS_GETINFO = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
			
	// 删除自定义菜单
	public static String MENUS_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
			
	// 获取自定义菜单的配置
	public static String MENUS_GETCONFIG = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=";
			

	/**
	 * 用户管理接口
	 */
	// 获取用户基本信息
	public static String GET_FANSINFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=[ACCESS_TOKEN]&lang=zh_CN&openid=";
	// 批量获取用户信息
	public static String BATCHGET_FANSINFO = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=[ACCESS_TOKEN]";
	// 获取用户列表
	public static String GET_FANSLIST = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=[ACCESS_TOKEN]&next_openid=";
	// 设置备注名
	public static String SET_REMARK = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=";
			

	/**
	 * 分组管理接口
	 */
	// 创建分组
	public static String GROUP_CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
			
	// 查询所有分组
	public static String GROUP_SEARCHALL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
			
	// 根据用户openId查询所在分组
	public static String GROUP_SEARCHBYOPENID = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=";
			
	// 修改分组名
	public static String GROUP_SETNAME = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
			
	// 移动用户分组
	public static String GROUP_MOVEFANS = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";
			
	// 批量移动用户分组
	public static String GROUP_BATCHMOVEFANS = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=";
			
	// 删除分组
	public static String GROUP_DELETE = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=";
			

	/**
	 * 多客服接口
	 */
	// 获取客服基本信息
	public static String DKF_GET_LIST = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=";
			
	// 获取在线客服基本信息
	public static String DKF_GET_OLLIST = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=";
			
	// 添加客服帐号
	public static String DKF_ADD = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=";
			
	// 设置客服信息
	public static String DKF_UPDATE = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=";
			
	// 删除客服信息
	public static String DKF_DELETE = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=[ACCESS_TOKEN]&kf_account=";;
	// 创建会话--绑定粉丝和客服
	public static String DKF_CREATESESSION = "https://api.weixin.qq.com/customservice/kfsession/create?access_token=";
			
	// 关闭会话--解除绑定
	public static String DKF_CLOSESESSION = "https://api.weixin.qq.com/customservice/kfsession/close?access_token=";
			
	// 获取客户的会话状态
	public static String DKF_SESSTION_STATUS = "https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=[ACCESS_TOKEN]&openid=";;
	// 获取客服的会话列表
	public static String DKF_SESSION_LIST = "https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token=[ACCESS_TOKEN]&kf_account=";;
	// 获取暂未接入的会话列表
	public static String DKF_WAIT_LIST = "https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=";
			
	// 获取客服聊天记录
	public static String DKF_CHAT_HISTORY = "https://api.weixin.qq.com/cgi-bin/customservice/getrecord?access_token=";
			

	/**
	 * 模版消息接口
	 */
	// 设置模版的行业（每月只能修改一次）
	public static String TPLT_SETINDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
			
	// 获得模版ID
	public static String TPLT_GET_LONGID = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
			
	// 发送模版消息
	public static String TPLT_SENDMSG = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
			

	/**
	 * 客服管理接口
	 */
	// 添加客服
	public static String KF_KF_ADD = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=";
			
	// 发送客服消息 post
	public static String KF_SEND_MSG = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
			

	/**
	 * 帐号管理接口
	 */
	// 长链接转短链接
	public static String LONG_TO_SHORT = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=";
			
	// 生成临时带参二维码
	public static String QR_CREATE_TEMP = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
			
	// 生成永久带参二维码
	public static String QR_CREATE_LIMIT = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
			

	/**
	 * Auth2.0授权
	 */
	// 获取OAuth2.0网页授权登录 接口凭证
	public static String GET_AUTH_ACCESSCODE = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code";

	public static String getOAuthAccessToken(String appId, String appSecret, String code) {
		return MessageFormat.format(GET_AUTH_ACCESSCODE, appId, appSecret, code);
	}

	// 刷新OAuth2.0网页授权登录 接口凭证
	public static String GET_AUTH_REFRESHACCESSCODE = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=[APPID]&grant_type=refresh_token&refresh_token={0}";

	public static String getAuthRefreshCode(String refreshCode) {
		/** 格式化正确url **/
		return MessageFormat.format(GET_AUTH_ACCESSCODE, refreshCode);
	}

	// OAuth2.0拉取用户信息
	public static String GET_AUTH_SNSAPI_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN";

	public static String getAuthUserInfo(String accesstoken, String openid) {
		/** 格式化正确url **/
		return MessageFormat.format(GET_AUTH_SNSAPI_USERINFO, accesstoken,
				openid);
	}

	/**
	 * JS-SDK接口
	 */
	// 获取api_ticket,用于调用微信 JS API 的临时票据
	public static String GET_APITICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=[ACCESS_TOKEN]&type=jsapi";
	// 获取jssdk中调用添加卡券接口的时候使用的ticket
	public static String GET_WXCARD_APITICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=[ACCESS_TOKEN]&type=wx_card";

	/**
	 * 素材管理接口
	 */
	// 上传图文素材URL
	public static String UPLOAD_NEWS = "http://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=";
			
	// 下载多媒体文件
	public static String DOWNLOAD_MEDIA = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=[ACCESS_TOKEN]&media_id=";;
	// 新增临时素材
	public static String MATERIAL_TEMP_UPLOAD = "http://api.weixin.qq.com/cgi-bin/media/upload?access_token=[ACCESS_TOKEN]&type=";;
	// 获取临时素材
	public static String MATERIAL_TEMP_GET = "http://api.weixin.qq.com/cgi-bin/media/get?access_token=[ACCESS_TOKEN]&media_id=";;
	// 新增永久图文素材
	public static String MATERIAL_PERMNEWS_UPLOAD = "http://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";
			
	// 新增永久其它类型素材
	public static String MATERIAL_PERM_UPLOAD = "http://file.api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
			
	// 获取永久素材
	public static String MATERIAL_PERM_GET = "http://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
			
	// 删除永久素材
	public static String MATERIAL_PERM_DEL = "http://api.weixin.qq.com/cgi-bin/material/del_material?access_token=";
			
	// 修改永久素材
	public static String MATERIAL_PERM_UPDATE = "http://api.weixin.qq.com/cgi-bin/material/update_news?access_token=";
			
	// 获取素材总数
	public static String MATERIAL_COUNT = "http://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=";
			
	// 获取素材列表
	public static String MATERIAL_LIST = "http://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
			
}
