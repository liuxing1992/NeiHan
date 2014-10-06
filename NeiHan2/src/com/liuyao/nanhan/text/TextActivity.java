package com.liuyao.nanhan.text;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.liuyao.bean.Comment;
import com.liuyao.bean.CommentList;
import com.liuyao.bean.EntityList;
import com.liuyao.client.ClientApi;
import com.liuyao.neihan.R;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

public class TextActivity extends Activity  implements Response.Listener<String> {
	
	public static final int CATEGORY_TEXT=1;  //文本
	public static final int CATEGORY_PHOTO=2;//图片
	
	private Button button; 
	private  long min_time;
	int itemCount=30;
	private RequestQueue queue;
	int offset=0;
	long group_id=3550036269l;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text);
		
		button=(Button)this.findViewById(R.id.button1);
		queue = Volley.newRequestQueue(this);
//		button.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				ClientApi.getList(queue, itemCount, CATEGORY_PHOTO, min_time, TextActivity.this);			
//			}
//		});
			
		//ClientApi.getList(queue,itemCount, CATEGORY_PHOTO,0,this);	 
		
		//代表文本段子的id
			
		ClientApi.getCommentList(queue,group_id, offset,this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text, menu);
		return true;
	}

	/**
	 * 列表网络获取回调
	 * @param arg0
	 */
	public void ListResponse(String arg0) {
		// TODO Auto-generated method stub
		try {
			JSONObject jsonObject=new JSONObject(arg0);
			
			JSONObject obj=jsonObject.getJSONObject("data");
			
			EntityList entityList=new EntityList();
			//解析jsond方法，包括图片，文本，广告的解析
			entityList.parsejson(obj);
		
			//如果返回true 代表还可以更新一次数据
			if (entityList.isHas_more()) {
				min_time=entityList.getMin_time();//获取更新时间标示
				Log.i("TextActivity", "--min_time-->"+min_time);
			} 	else {  //没有更多数据，休息一会
				String tips=entityList.getTip();
				Log.i("TextActivity", "--tips-->"+tips);
			}
			//TODO把entities 这个段子的数据集合体，传递给listview 之类的adapter 即可展示
			
			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onResponse(String arg0) {
		// TODO Auto-generated method stub
		try {
			JSONObject json=new JSONObject(arg0);
			//解析获取评论列表
			CommentList commentList=new CommentList();
			//评论列表包括两组数据，topcomments  recentcomments
			//两者都可能为空
			commentList.parsejson(json);
			
			List<Comment> topcComments=commentList.getTopComments();
			
			List<Comment> recentComments=commentList.getRecentComments();
			
			//TODO  直接把commentlist提交给listview的adapter  这样可以进行是否有内容的判断
			//利用adapter更新数据
			//分页的标志，要求服务器每次返回20条评论，通过ishasmore 来判断是否还有评论更新
			offset+=20;
			
			Log.i("TextActivity", "--id-->"+commentList.getGroup_id());
			Log.i("TextActivity", "---hasmore-->"+commentList.isHas_more());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
