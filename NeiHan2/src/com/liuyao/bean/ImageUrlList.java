package com.liuyao.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageUrlList {

	private List<String> largeImageUrls;
	private String uri;
	private int width;
	private int height;

	public ImageUrlList() {
		// TODO Auto-generated constructor stub
	}
	
	public void parsejson(JSONObject json) throws JSONException{
		largeImageUrls = parseImageUrlList(json);				
		uri = json.getString("uri");
		width = json.getInt("width");
		height = json.getInt("height");
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

	public List<String> getLargeImageUrls() {
		return largeImageUrls;
	}

	public String getUri() {
		return uri;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
