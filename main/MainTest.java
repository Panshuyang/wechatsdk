import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gx.sdk.base.WxBase;
import org.gx.sdk.data.DataStatistics;
import org.gx.sdk.fans.FansManager;
import org.gx.sdk.fans.GroupManager;
import org.gx.sdk.material.MaterialManager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author PSY
 * @createTime 2016-1-8 下午05:22:21
 */
public class MainTest {
	public static void main(String[] args) {
		String accessToken = WxBase.getAccessToken("wxef9adf297544b9fa","73923e8dedbe0e76a48fb5718e995525").get("access_token").toString();
		System.out.println(accessToken);
		fansTest(accessToken);
	}
	
	public static void datastatistics(String accessToken){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("begin_date", "2016-01-26");
		params.put("end_date", "2016-01-26");
		System.out.println(DataStatistics.getArticleSummary(accessToken, params));
	}
	
	public static void fansTest(String accessToken){
		List<String> openIdList = new ArrayList<String>(); 
		JSONObject jsonResult = JSONObject.parseObject(JSONObject.toJSONString(FansManager.getFansList(accessToken, "")));
		JSONArray openIds = jsonResult.getJSONObject("data").getJSONArray("openid");
		for(int i=0; i< openIds.size(); i++){
			openIdList.add(openIds.getString(i));
		}
		JSONArray openIdArray = new JSONArray();
		for(int j=0; j<openIdList.size(); j++){
			JSONObject obj = new JSONObject();
			obj.put("openid", openIdList.get(j));
			openIdArray.add(obj);
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user_list", openIdArray);
		System.out.println(param);
		System.out.println(FansManager.batchGetFansInfo(accessToken, param));
	}
	
	public static void groupTest(){
		System.out.println(GroupManager.getAllGroups("aMoQJ6l1D5o6K0IKqS_nleUsCqS0p1F3DF5PpH1WfLApmvUDUFcEmq0ov7fL01E3_YZd7yP8y1sr_Lu6Bacj1iLpaXt2LYCKbMr10NK6Jl8NPOdAEADFE"));
	}
	
	public static void materialTest(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", "news");
		params.put("offset", 0);
		params.put("count", 20);
		System.out.println(MaterialManager.getMaterialList("tK5GIaAcDgUjqkntrRVXw6UMD4lHoZ127WOcTCUR7GgxH8OcETWKs4dYEVSNKn5haGHRi6ek7hY4dx1xAW1UU72MqZMQ0BbKLrsmsqtZVSEIEZiADANJE", params));
	}
}
