package com.liuyao.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageEntity {

	private int type;
	private int comment_count;
	private String content;
	private long groupId;
	private ImageUrlList largeList;
	private ImageUrlList middlelList;

	public ImageEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public void parsejson(JSONObject item) throws JSONException{
		
		type = item.getInt("type");
		JSONObject group = item.getJSONObject("group");
		
		comment_count = group.getInt("comment_count");
		
		JSONObject largeImage=group.getJSONObject("large_image");
		
		JSONObject middleImage=group.getJSONObject("middle_image");
		
		groupId = group.getLong("group_id");
		
		content = group.getString("content");
		largeList = new ImageUrlList();
		largeList.parsejson(largeImage);
		middlelList = new ImageUrlList();
		middlelList.parsejson(middleImage);
		
	}
}
