package com.liuyao.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 评论接口返回的 data ：{} 数据部分的实体定义
 * 包含了top_comments   recent_comments
 * json格式<br/>
 * <pre>
 * data": {
    "recent_comments": [], 
    "top_comments": []
  }
  </pre>
 * @author aaa
 *
 */
public class CommentList {

	private List<Comment> topComments;
	
	private List<Comment> recentComments;
	
	private long group_id;
	private int total_number;
	private boolean has_more;
	
	
	public CommentList() {
		// TODO Auto-generated constructor stub
	}
	public void parsejson(JSONObject json) throws JSONException{
		if (json!=null) {
			JSONObject data=json.getJSONObject("data");
				
			group_id=json.getLong("group_id");
			total_number=json.getInt("total_number");
			has_more=json.getBoolean("has_more");
			
			JSONArray rArray=	data.optJSONArray("recent_comments");
			if (rArray!=null) {
				recentComments=new LinkedList<Comment>();
				int len=rArray.length();
				if (len>0) {
					for(int i=0;i<len;i++){
						JSONObject object=	rArray.getJSONObject(i);
						Comment comment=new Comment();
						comment.parsejson(object);
						recentComments.add(comment);
					}
				}
			}
			
		JSONArray tArray=	data.optJSONArray("top_comments");
		
		if (tArray!=null) {
			
			topComments=new LinkedList<Comment>();
			
			int len=tArray.length();
			if (len>0) {
				for(int i=0;i<len;i++){
					JSONObject object=	tArray.getJSONObject(i);
					Comment comment=new Comment();
					comment.parsejson(object);
					topComments.add(comment);
				}
			}
		}
			
		}
		
	}
	public List<Comment> getTopComments() {
		return topComments;
	}
	public List<Comment> getRecentComments() {
		return recentComments;
	}
	public long getGroup_id() {
		return group_id;
	}
	public int getTotal_number() {
		return total_number;
	}
	public boolean isHas_more() {
		return has_more;
	}

	
}
