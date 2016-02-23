package org.gx.common.url;

/**
 * @ClassName: WxCardURLs
 * @Description: 微信卡券URL常量类
 */
public class WxCardURLs {

	// 上传LOGO接口
	public static String UPLOAD_LOGO = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
			
	// 导入门店信息
	public static String IMPORT_BRANCH = "https://api.weixin.qq.com/card/location/batchadd?access_token=";
			
	// 拉取门店列表
	public static String GET_BRANCHLIST = "https://api.weixin.qq.com/card/location/batchget?access_token=";
			
	// 获取颜色列表
	public static String GET_COLORLIST = "https://api.weixin.qq.com/card/getcolors?access_token=";
			
	// 创建卡券
	public static String CARD_CREATE = "https://api.weixin.qq.com/card/create?access_token=";
			
	// 生成二维码
	public static String CARD_QRCODE = "https://api.weixin.qq.com/card/qrcode/create?access_token=";
			
	// 获取API_TICKET
	public static String CARD_APITICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=[ACCESS_TOKEN]&type=wx_card";
	// 消耗CODE
	public static String CODE_CONSUME = "https://api.weixin.qq.com/card/code/consume?access_token=";
			
	// CODE解码
	public static String CODE_DECODE = "https://api.weixin.qq.com/card/code/decrypt?access_token=";
			
	// 删除卡券
	public static String CARD_DELETE = "https://api.weixin.qq.com/card/delete?access_token=";
			
	// 查询CODE
	public static String CODE_SEARCH = "https://api.weixin.qq.com/card/code/get?access_token=";
			
	// 批量查询卡列表
	public static String CARD_BATCHGET = "https://api.weixin.qq.com/card/batchget?access_token=";
			
	// 查询卡券详情
	public static String CARD_GETINFO = "https://api.weixin.qq.com/card/get?access_token=";
			
	// 更改CODE
	public static String CODE_CHANGE = "https://api.weixin.qq.com/card/code/update?access_token=";
			
	// 设置卡券失效
	public static String CARD_SETINVALID = "https://api.weixin.qq.com/card/code/unavailable?access_token=";
			
	// 更改卡券信息
	public static String CARD_CHANGEINFO = "https://api.weixin.qq.com/card/update?access_token=";
			
	

}
