package com.liuyao.neihan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.liuyao.fragment.CheckFragment;
import com.liuyao.fragment.HuoDongFragment;
import com.liuyao.fragment.ImageListFragment;
import com.liuyao.fragment.MineFragment;
import com.liuyao.fragment.TextListFragment;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener {
	List<Fragment> fragments;
	private RadioGroup group;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fragments=new ArrayList<Fragment>();
		
		fragments.add(new TextListFragment());
		fragments.add(new ImageListFragment());
		fragments.add(new  CheckFragment());
		fragments.add(new  HuoDongFragment());
		fragments.add(new MineFragment());
		
		Fragment fragment=fragments.get(0);
		FragmentManager manager=getSupportFragmentManager();
		FragmentTransaction transaction=manager.beginTransaction();
		transaction.add(R.id.main_fragment_contain, fragment);
		transaction.commit();
		
		group=(RadioGroup)this.findViewById(R.id.radioGroup1);
		
		group.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		
		int childCount=group.getChildCount();
		int checkedIndex=0;
		RadioButton btn=null;
		for(int i=0;i<childCount;i++){
			btn=(RadioButton) group.getChildAt(i);
			if (btn.isChecked()) {
				checkedIndex=i;
				break;
			}		
		}
		Fragment fragment=fragments.get(checkedIndex);
		
		FragmentManager manager=getSupportFragmentManager();
		FragmentTransaction transaction=manager.beginTransaction();
		transaction.replace(R.id.main_fragment_contain, fragment, "fragment");
		transaction.commit();
	}

}
