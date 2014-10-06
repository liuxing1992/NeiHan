package com.liuyao.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class UserEntity {

	private String avatarUrl;//头像网址
	
	private long userId;//用户id
	
	private String name;//用户昵称
	
	private boolean  userVerified;//用户是否加V
	
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *  "user": {
                        "avatar_url": "http://p1.pstatp.com/thumb/1367/2213311454",
                        "user_id": 3080520868,
                        "name": "请叫我梓安哥",
                        "user_verified": false
                    },
	 */
	public void parsejson(JSONObject json) throws JSONException{
		
		if (json!=null) {
			avatarUrl=json.getString("avatar_url");
			userId=json.getLong("user_id");
			name=json.getString("name");
			userVerified=json.getBoolean("user_verified");
		}
		
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public boolean isUserVerified() {
		return userVerified;
	}
	
	
}
