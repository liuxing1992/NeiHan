package com.liuyao.nanhan.text;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.liuyao.bean.ImageEntity;
import com.liuyao.bean.ImageUrlList;
import com.liuyao.client.ClientApi;
import com.liuyao.neihan.R;
import com.liuyao.neihan.R.layout;
import com.liuyao.neihan.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class TextActivity extends Activity  implements Response.Listener<String> {
	
	public static final int CATEGORY_TEXT=1;  //文本
	public static final int CATEGORY_PHOTO=2;//图片
	
	int itemCount=30;
	private RequestQueue queue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text);
		
		queue = Volley.newRequestQueue(this);
		ClientApi.getList(queue,itemCount, CATEGORY_PHOTO,this);	 
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text, menu);
		return true;
	}

	@Override
	public void onResponse(String arg0) {
		// TODO Auto-generated method stub
		try {
			JSONObject jsonObject=new JSONObject(arg0);
			arg0=jsonObject.toString(4);
			System.out.println("TextActivity"+arg0);
			
			JSONObject obj=jsonObject.getJSONObject("data");
			
			JSONArray array=obj.getJSONArray("data");
			
			int len=array.length();
			if (len>0) {
				//遍历数组的每一条
				for(int i=0;i<len;i++){
					JSONObject item=array.getJSONObject(i);					
					ImageEntity imageEntity=new ImageEntity();
					imageEntity.parsejson(item);
				}
			}
			//Log.i("TextActivity", "----->"+jsonObject.toString(4));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<String> parseImageUrlList(JSONObject largeImage) throws JSONException {
		
		List< String >  largeImageUrls=new ArrayList<String>();
		JSONArray urlArray=largeImage.getJSONArray("url_list");
		
		for(int j=0;j<urlArray.length();j++){
			JSONObject uObject=urlArray.getJSONObject(j);
			String url=	uObject.getString("url");		
			
			largeImageUrls.add(url);
		}
		return largeImageUrls;
	}
}
