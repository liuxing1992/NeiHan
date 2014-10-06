package com.liuyao.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class Comment {

	private long uid;
	private String text;
	private int bury_count;
	private int user_digg;
	private long id;
	private long user_id;
	private long create_time;
	private int user_bury;
	private boolean user_verified;
	private String user_profile_url;
	private String description;
	private int digg_count;
	private String platform;
	private String user_name;
	private String user_profile_image_url;

	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *   "uid": 0, 
        "text": "你也想吃老孙一棒？ // @黄山小妖: 那是没路过黄山...", 
        "create_time": 1412087769, 
        "user_digg": 0, 
        "id": 3569939230, 
        "user_bury": 0, 
        "user_profile_url": "", 
        "user_id": 3328594365, 
        "bury_count": 0, 
        "description": "这个人到底有多懒……", 
        "digg_count": 1, 
        "user_verified": false, 
        "platform": "feifei", 
        "user_name": "别人骑马我骑驴丶后面还有要饭滴", 
        "user_profile_image_url": "http://p1.pstatp.com/thumb/1030/5256143796"
	 */
		public void parsejson(JSONObject json) throws JSONException{
			
			if (json!=null) {
				
				uid = json.getLong("uid");
				text = json.getString("text");
				bury_count = json.getInt("bury_count");
				user_digg = json.getInt("user_digg");
				id = json.getLong("id");
				user_id = json.getLong("user_id");
				create_time = json.getLong("create_time");
				user_bury = json.getInt("user_bury");
				user_verified = json.getBoolean("user_verified");
				user_profile_url = json.getString("user_profile_url");
				description = json.optString("description");
				digg_count = json.getInt("digg_count");
				platform = json.getString("platform");
				user_name = json.getString("user_name");
				user_profile_image_url = json.getString("user_profile_image_url");
				
				
			}
		}

	public long getUid() {
		return uid;
	}

	public String getText() {
		return text;
	}

	public int getBury_count() {
		return bury_count;
	}

	public int getUser_digg() {
		return user_digg;
	}

	public long getId() {
		return id;
	}

	public long getUser_id() {
		return user_id;
	}

	public long getCreate_time() {
		return create_time;
	}

	public int getUser_bury() {
		return user_bury;
	}

	public boolean isUser_verified() {
		return user_verified;
	}

	public String getUser_profile_url() {
		return user_profile_url;
	}

	public String getDescription() {
		return description;
	}

	public int getDigg_count() {
		return digg_count;
	}

	public String getPlatform() {
		return platform;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_profile_image_url() {
		return user_profile_image_url;
	}	
}
