package org.gx.common.url;

import java.text.MessageFormat;

/**
 * 微信小店相关接口的URL地址
 */
public class WxShopURLs {

	// 增加商品
	public static String GOODS_CREATE = "https://api.weixin.qq.com/merchant/create?access_token=";
			

	// 删除商品
	public static String GOODS_DELETE = "https://api.weixin.qq.com/merchant/del?access_token=";
			

	// 修改商品
	public static String GOODS_UPDATE = "https://api.weixin.qq.com/merchant/update?access_token=";
			

	// 查询商品
	public static String GOODS_GETINFO = "https://api.weixin.qq.com/merchant/get?access_token=";
			

	// 获取制定状态的所有商品 商品状态(0-全部, 1-上架, 2-下架)
	public static String GOODS_GETBYSTAT = "https://api.weixin.qq.com/merchant/getbystatus?access_token=";
			

	// 商品上下架
	public static String GOODS_UPDATESTAT = "https://api.weixin.qq.com/merchant/modproductstatus?access_token=";
			

	// 获取制定分类的所有子类
	public static String GETSUBSTATUS = "https://api.weixin.qq.com/merchant/category/getsub?access_token=";
			

	// 获得所有指定子分类的SKU
	public static String GETSUBSKU = "https://api.weixin.qq.com/merchant/category/getsku?access_token=";
			

	// 获得指定分类的所有属性
	public static String GETPROPERTY = "https://api.weixin.qq.com/merchant/category/getproperty?access_token=";
			

	// 增加库存
	public static String STOCK_ADD = "https://api.weixin.qq.com/merchant/stock/add?access_token=";
			

	// 减少库存
	public static String STOCK_MINUS = "https://api.weixin.qq.com/merchant/stock/reduce?access_token=";
			

	// 增加邮费模版
	public static String EXPRESS_ADD = "https://api.weixin.qq.com/merchant/express/add?access_token=";
			

	// 删除邮费模版
	public static String EXPRESS_DEL = "https://api.weixin.qq.com/merchant/express/del?access_token=";
			

	// 修改邮费模版
	public static String EXPRESS_UPDATE = "https://api.weixin.qq.com/merchant/express/update?access_token=";
			

	// 获取指定ID的邮费模版
	public static String EXPRESS_GETBYID = "https://api.weixin.qq.com/merchant/express/getbyid?access_token=";
			

	// 获取所有邮费模版
	public static String EXPRESS_GETALL = "https://api.weixin.qq.com/merchant/express/getall?access_token=";
			

	// 增加分组
	public static String GROUP_ADD = "https://api.weixin.qq.com/merchant/group/add?access_token=";
			

	// 删除分组
	public static String GROUP_DEL = "https://api.weixin.qq.com/merchant/group/del?access_token=";
			

	// 修改分组属性
	public static String GROUP_PROPERTYMOD = "https://api.weixin.qq.com/merchant/group/propertymod?access_token=";
			

	// 修改分组商品
	public static String GROUP_PRODUCTMOD = "https://api.weixin.qq.com/merchant/group/productmod?access_token=";
			

	// 获取所有分组
	public static String GROUP_GETALL = "https://api.weixin.qq.com/merchant/group/getall?access_token=";
			

	// 根据分组ID获得分组信息
	public static String GROUP_GETBYID = "https://api.weixin.qq.com/merchant/group/getbyid?access_token=";
			

	// 增加货架
	public static String SHELF_ADD = "https://api.weixin.qq.com/merchant/shelf/add?access_token=";
			

	// 删除货架
	public static String SHELF_DEL = "https://api.weixin.qq.com/merchant/shelf/del?access_token=";
			

	// 修改货架
	public static String SHELF_UPDATE = "https://api.weixin.qq.com/merchant/shelf/mod?access_token=";
			

	// 获取所有货架
	public static String SHELF_GETALL = "https://api.weixin.qq.com/merchant/shelf/getall?access_token=";
			

	// 根据货架ID获取货架信息
	public static String SHELF_GETBYID = "https://api.weixin.qq.com/merchant/shelf/getbyid?access_token=";
			

	// 根据订单ID获取订单详情
	public static String ORDER_GETBYID = "https://api.weixin.qq.com/merchant/order/getbyid?access_token=";
			

	// 根据订单状态、创建时间获取订单详情
	public static String ORDER_GETBYFILTER = "https://api.weixin.qq.com/merchant/order/getbyfilter?access_token=";
			

	// 设置订单发货信息
	public static String ORDER_SETDELIVERY = "https://api.weixin.qq.com/merchant/order/setdelivery?access_token=";
			

	// 关闭订单
	public static String ORDER_CLOSE = "https://api.weixin.qq.com/merchant/order/close?access_token=";
			
	
	//上传图片
	public static String UPLOADIMG = "https://api.weixin.qq.com/merchant/common/upload_img?access_token={0}&filename={1}";
	public static String uploadImg(String accesstoken, String fileName){
		return MessageFormat.format(UPLOADIMG, accesstoken,
				fileName);
	}
}
