package com.liuyao.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class EntityList {
	
	
	private boolean has_more;
	private long min_time;
	private String tip;
	private long max_time;
	
	private List<TextEntity> entities;
	
	public EntityList() {
		// TODO Auto-generated constructor stub
	}
	public void parsejson(JSONObject json) throws JSONException{
		
		if (json!=null) {
			tip = json.getString("tip");
			
			has_more = json.getBoolean("has_more");
			if (has_more==true) {
				min_time = json.getLong("min_time");
			}					
			max_time = json.optLong("max_time");
			//获取根节点下的data数组
			JSONArray array=json.getJSONArray("data");
			
			int len=array.length();
			if (len>0) {
				
				entities=new LinkedList<TextEntity>();
				
				//遍历数组的每一条
				for(int i=0;i<len;i++){
					JSONObject item=array.getJSONObject(i);	
					
					int type=item.getInt("type");
					if (type==5) {
						//处理关广告
						
						AdEntity entity=new AdEntity();
						entity.parsejson(item);
						String 	downLoadUrl=entity.getDownload_url();
						
						//Log.i("TextActivity", "--downLoadUrl-->"+downLoadUrl);
					}else if (type==1) {
						//处理段子类型
						JSONObject group=item.getJSONObject("group");
						TextEntity entity=null;
						int cid=group.getInt("category_id");
							if (cid==1) {
								//文本
								entity=new TextEntity();
								
							}else if (cid==2) {
								//图片
								entity=new ImageEntity();
							} 
							entity.parsejson(item);
							entities.add(entity);
													
							long groupId=	entity.getGroupId();
							Log.i("TextActivity", "--groupId-->"+groupId);
							
					}			
				
//					ImageEntity imageEntity=new ImageEntity();
//					imageEntity.parsejson(item);
				}
			}
		}
		
	}
	public boolean isHas_more() {
		return has_more;
	}
	public long getMin_time() {
		return min_time;
	}
	public String getTip() {
		return tip;
	}
	public long getMax_time() {
		return max_time;
	}
	public List<TextEntity> getEntities() {
		return entities;
	}
	
}
