package com.liuyao.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageEntity  extends TextEntity {

	
	private ImageUrlList largeList;
	private ImageUrlList middlelList;

	public ImageEntity()  {
		// TODO Auto-generated constructor stub
		
	}
	
	public void parsejson(JSONObject item) throws JSONException{
		super.parsejson(item);
		
		//type = item.getInt("type");
		JSONObject group = item.getJSONObject("group");
		
	//	comment_count = group.getInt("comment_count");
		
		JSONObject largeImage=group.optJSONObject("large_image");
		
		JSONObject middleImage=group.optJSONObject("middle_image");
		
		//groupId = group.getLong("group_id");
		
		//content = group.getString("content");
		largeList = new ImageUrlList();
		if (largeImage!=null) {
			largeList.parsejson(largeImage);
		}	
		middlelList = new ImageUrlList();
		if (middleImage!=null) {
			middlelList.parsejson(middleImage);
		}	
	}

	public ImageUrlList getLargeList() {
		return largeList;
	}

	public ImageUrlList getMiddlelList() {
		return middlelList;
	}
}
