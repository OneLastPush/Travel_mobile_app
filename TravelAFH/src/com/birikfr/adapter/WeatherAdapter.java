package com.birikfr.adapter;

import com.birikfr.util.WeatherInfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherAdapter extends BaseAdapter{
	private Context context;
	private String item[];
	
	public WeatherAdapter(Context context, String item[]) {
		this.context = context;
		this.item = item;
	}
	
	@Override
	public int getCount() {
		return item.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		TextView text;
		if(arg1 == null){
			text = new TextView(context);
			text.setLayoutParams(new GridView.LayoutParams(460,460));
			text.setPadding(4, 4, 4, 4);
			float f = 30;
			text.setTextSize(f);
		}else{
			text = (TextView) arg1;
		}
		text.setText(item[arg0]);
		return text;
		
		
		
	}

}
