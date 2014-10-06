package com.liuyao.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class AdEntity {

	private int type;
	private long disply_time;
	private long online_time;
	private int display_image_height;
	private int ad_id;
	private int display_image_width;
	private String source;
	private String package1;
	private String title;
	private String open_url;
	private String download_url;
	private int is_ad;
	private String display_info;
	private String web_url;
	private int display_type;
	private String button_text;
	private int appleid;
	private String track_url;
	private String label;
	private String Apptype;
	private long id;
	private String ipa_url;
	private String display_image;
	

	public AdEntity() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * {
                "type": 5,
                "display_time": 1411878658,
                "online_time": 1411878658,
                "ad": {
                    "display_image_height": 400,
                    "ad_id": 3561092485,
                    "display_image_width": 600,
                    "source": "",
                    "package": "",
                    "title": "霜霜和阿伟都爱玩的游戏，还有iphone6等你拿哦！",
                    "open_url": "",
                    "download_url": "http://yihua.b0.upaiyun.com/neihan.apk",
                    "is_ad": 1,
                    "display_info": "霜霜和阿伟都爱玩的游戏，还有iphone6等你拿哦！",
                    "web_url": "http://yihua.b0.upaiyun.com/neihan.apk",
                    "display_type": 3,
                    "button_text": "立即下载",
                    "appleid": "",
                    "track_url": "",
                    "label": "推广",
                    "type": "app",
                    "id": 3561092485,
                    "ipa_url": "",
                    "display_image": "http://p2.pstatp.com/large/1362/1075506622"
                }
	 */
	
	public void parsejson(JSONObject json) throws JSONException{
		if (json!=null) {
			
			type = json.getInt("type");
			
			disply_time = json.getLong("display_time");
			online_time = json.getLong("online_time");
			
			JSONObject AdObject=json.getJSONObject("ad");
			
			display_image_height = AdObject.getInt("display_image_height");
			 
			ad_id = AdObject.getInt("ad_id");
			 display_image_width = AdObject.getInt("display_image_width");
			
			 source = AdObject.getString("source");
			 package1 = AdObject.getString("package");
			title = AdObject.getString("title");
			open_url = AdObject.getString("open_url");
			download_url = AdObject.getString("download_url");
			is_ad = AdObject.getInt("is_ad");
			display_info = AdObject.getString("display_info");
			web_url = AdObject.getString("web_url");
			display_type = AdObject.getInt("display_type");
			button_text = AdObject.getString("button_text");
			appleid = AdObject.getInt("appleid");
			track_url = AdObject.getString("track_url");
			label = AdObject.getString("label");
			Apptype = AdObject.getString("type");
			id = AdObject.getLong("id");
			ipa_url = AdObject.getString("ipa_url");
			display_image = AdObject.getString("display_image");
		}	
	}

	public int getType() {
		return type;
	}

	public long getDisply_time() {
		return disply_time;
	}

	public long getOnline_time() {
		return online_time;
	}

	public int getDisplay_image_height() {
		return display_image_height;
	}

	public int getAd_id() {
		return ad_id;
	}

	public int getDisplay_image_width() {
		return display_image_width;
	}

	public String getSource() {
		return source;
	}

	public String getPackage1() {
		return package1;
	}

	public String getTitle() {
		return title;
	}

	public String getOpen_url() {
		return open_url;
	}

	public String getDownload_url() {
		return download_url;
	}

	public int getIs_ad() {
		return is_ad;
	}

	public String getDisplay_info() {
		return display_info;
	}

	public String getWeb_url() {
		return web_url;
	}

	public int getDisplay_type() {
		return display_type;
	}

	public String getButton_text() {
		return button_text;
	}

	public int getAppleid() {
		return appleid;
	}

	public String getTrack_url() {
		return track_url;
	}

	public String getLabel() {
		return label;
	}

	public String getApptype() {
		return Apptype;
	}

	public long getId() {
		return id;
	}

	public String getIpa_url() {
		return ipa_url;
	}

	public String getDisplay_image() {
		return display_image;
	}
}
