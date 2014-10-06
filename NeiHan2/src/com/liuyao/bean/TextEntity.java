package com.liuyao.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 文本段子实体类
 * @author aaa
 *
 *
 */
public class TextEntity {
	
	protected int type;
	protected long createTime;
	protected long onlineTime;
	protected long display_time;
	protected int favoriteCount;
	protected int userFavorite;
	protected int userBury;;
	protected int buryCount;
	protected String shareUrl;//用于第三方分享，分享网址
	
	protected int label;
	
	protected String content;//文本段子内容
	
	protected int comment_count;
	protected int status;//状态  其中的可选值为3 需要分析是什么类型
	protected String statusDec;//状态的描述
	
	protected int hasComments;//当前用户是否已评论
	
	protected int goDetailCount;
	
	protected  int userDigg;
	
	protected long groupId;//段子的id，访问详情和评论时，用这个作为接口参数
	
	protected int level;//需要分析是什么含义，有两次出现1获取列表接口level=6；文本段子实体level=4
	
	protected int repingCount;//分析含义
	
	protected int hasHotComment;//是否含有热评论
	
	protected int user_repin;
	protected int catagoryId; //内容分类类型1，文本2，图片
	
	protected int digg_count;
	//todo  需要分析comments这个json数组的内容是什么
	
	protected UserEntity user; 
	
	
	public TextEntity() {
		// TODO Auto-generated constructor stub
	}
/**
 *    "data": {
        "has_more": true,
        "min_time": 1411887357,
        "tip": "50条新内容",
        "data": [
            {
                "online_time": 1411878957,
                "display_time": 1411878957,
                "group": {
                    "create_time": 1411718218.0,
                    "favorite_count": 1209,
                    "user_bury": 0,
                    "user_favorite": 0,
                    "bury_count": 1516,
                    "share_url": "http://toutiao.com/group/3560859160/?iid=2337593504&app=joke_essay",
                    "label": 1,
                    "content": "甲:昨天碰到抢劫的，被打了两顿。乙:为啥啊？甲:他问我有钱吗我说没有，他从我身上搜出一包软中华然后就被打了一顿。等他走了，不一会儿又回来打了我一顿，因为他发现里面塞的是白红梅，劫匪走时还留下一句‘没钱还装B’",
                    "comment_count": 177,
                    "status": 3,
                    "has_comments": 0,
                    "go_detail_count": 4370,
                    "status_desc": "已发表到热门列表",
                    "user": {
                        "avatar_url": "http://p1.pstatp.com/thumb/1367/2213311454",
                        "user_id": 3080520868,
                        "name": "请叫我梓安哥",
                        "user_verified": false
                    },
                    "user_digg": 0,
                    "group_id": 3560859160,
                    "level": 4,
                    "repin_count": 1209,
                    "digg_count": 18424,
                    "has_hot_comments": 1,
                    "user_repin": 0,
                    "category_id": 1
                },
                "comments": [],
                "type": 1
            },
 */
	
	public void parsejson(JSONObject json) throws JSONException{
		
		if (json!=null) {
			onlineTime=json.getLong("online_time");
			display_time=json.getLong("display_time");
			type=json.getInt("type");
			JSONObject object=json.getJSONObject("group");
			
			createTime=object.getLong("create_time");
			favoriteCount=object.getInt("favorite_count");
			userBury=object.getInt("user_bury");
			userFavorite=object.getInt("user_favorite");
			buryCount=object.getInt("bury_count");
			shareUrl=object.getString("share_url");
			label=object.optInt("label",0);
			content=object.getString("content");
			comment_count=object.getInt("comment_count");
			status=object.getInt("status");
			statusDec=object.getString("status_desc");
			
			hasComments=object.getInt("has_comments");
			goDetailCount=object.getInt("go_detail_count");
			
			
			JSONObject userObject=	object.getJSONObject("user");
			user=new UserEntity();
			user.parsejson(userObject);
			
			userDigg=object.getInt("user_digg");
			groupId=object.getLong("group_id");
			level=object.getInt("level");
			repingCount=object.getInt("repin_count");
			
			digg_count=object.getInt("digg_count");
			
			hasHotComment=object.optInt("has_hot_comments",0);
			user_repin=object.getInt("user_repin");
			catagoryId=object.getInt("category_id");
		}
		
	}
public int getType() {
	return type;
}
public long getCreateTime() {
	return createTime;
}
public long getOnlineTime() {
	return onlineTime;
}
public long getDisplay_time() {
	return display_time;
}
public int getFavoriteCount() {
	return favoriteCount;
}
public int getUserFavorite() {
	return userFavorite;
}
public int getUserBury() {
	return userBury;
}
public int getBuryCount() {
	return buryCount;
}
public String getShareUrl() {
	return shareUrl;
}
public int getLabel() {
	return label;
}
public String getContent() {
	return content;
}
public int getComment_count() {
	return comment_count;
}
public int getStatus() {
	return status;
}
public String getStatusDec() {
	return statusDec;
}
public int getHasComments() {
	return hasComments;
}
public int getGoDetailCount() {
	return goDetailCount;
}
public int getUserDigg() {
	return userDigg;
}
public long getGroupId() {
	return groupId;
}
public int getLevel() {
	return level;
}
public int getRepingCount() {
	return repingCount;
}
public int getHasHotComment() {
	return hasHotComment;
}
public int getUser_repin() {
	return user_repin;
}
public int getCatagoryId() {
	return catagoryId;
}
public int getDigg_count() {
	return digg_count;
}
public UserEntity getUser() {
	return user;
}
	
}
