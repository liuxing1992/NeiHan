package com.liuyao.client;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.liuyao.nanhan.text.TextActivity;

/**
 * 所有和服务器接口对接的方法，全部在这个类里面
 * @author liuxing
 *
 */
public class ClientApi {

	public ClientApi() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取内涵段子列表内容
	 * @param queue  volley请求的对列
	 * @param responselistener  用于获取段子列表的回调接口，任何调用getlist方法时，此参数用于更新段子列表
	 * @param itemCount  一次加载多少个内容数目
	 * @param category_type  要获取的参数类型
	 * @see TextActivity#CATEGORY_PHOTO
	 * @see TextActivity#CATEGORY_TEXT
	 * @author  liuxing
	 */
	public static void getList(RequestQueue queue, int itemCount,int category_type,Response.Listener<String> responselistener){
		
		//RequestQueue queue=Volley.newRequestQueue(this);
		
		String CATEGORY_LIST_API="http://ic.snssdk.com/2/essay/zone/category/data/";
		//分类参数  根据类型获取不同的参数
		String categoryParams="category_id="+category_type;
		
		String countParame="count="+itemCount;
		
		String openUDID="openudid=b90ca6a3a19a78d6";
		
		String deviceType="device_type=KFTT";
		
		String url=CATEGORY_LIST_API+"?"+categoryParams+"&"+countParame+"&"+deviceType+"&"+openUDID+"&level=6&iid=2337593504&device_id=2757969807&ac=wifi&channel=wandoujia&aid=7&app_name=joke_essay&version_code=302&device_platform=android&os_api=15&os_version=4.0.3";
	
			queue.add(new StringRequest(Request.Method.GET, 
			url, 
			responselistener
			, new Response.ErrorListener() {
	
					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
					
					}
				}));		
	}
	
	
}
