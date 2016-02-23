package org.gx.common.url;

/**
 * @ClassName: WxStatisticsURLs
 * @Description: 数据统计接口URL
 */
public class WxStatisticsURLs {
	/**
	 * 用户统计接口
	 */
	// 获取用户增减数据
	public static String GET_USERSUMMARY = "https://api.weixin.qq.com/datacube/getusersummary?access_token=";
			
	// 获取累计用户数据
	public static String GET_USERCUMULATE = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=";
			

	/**
	 * 图文统计接口
	 */
	// 获取图文群发每日数据
	public static String GET_ARTICLESUMMARY = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=";
			
	// 获取图文群发总数据
	public static String GET_ARTICLETOTAL = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=";
			
	// 获取图文统计数据
	public static String GET_USERREAD = "https://api.weixin.qq.com/datacube/getuserread?access_token=";
			
	// 获取图文统计分时数据
	public static String GET_USERREADHOUR = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=";
			
	// 获取图文分享转发数据
	public static String GET_USERSHARE = "https://api.weixin.qq.com/datacube/getusershare?access_token=";
			
	// 获取图文分享转发分时数据
	public static String GET_USERSHAREHOUR = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=";
			

	/**
	 * 消息统计接口
	 */
	// 获取消息发送概况数据
	public static String GET_UPSTREAMMSG = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=";
			
	// 获取消息分送分时数据
	public static String GET_UPSTREAMMSGHOUR = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=";
			
	// 获取消息发送周数据
	public static String GET_UPSTREAMMSGWEEK = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=";
			
	// 获取消息发送月数据
	public static String GET_UPSTREAMMSGMONTH = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=";
			
	// 获取消息发送分布数据
	public static String GET_UPSTREAMMSGDIST = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=";
			
	// 获取消息发送分布周数据
	public static String GET_UPSTREAMMSGDISTWEEK = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=";
			
	// 获取消息发送分布月数据
	public static String GET_UPSTREAMMSGDISTMONTH = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=";
			

	/**
	 * 接口使用统计接口
	 */
	//获取接口分析数据
	public static String GET_INTERFACESUMMARY = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=";
			
	//获取接口分析分时数据
	public static String GET_INTERFACESUMMARYHOUR = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=";
			

}