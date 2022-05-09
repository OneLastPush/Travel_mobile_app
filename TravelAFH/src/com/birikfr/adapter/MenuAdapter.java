package com.birikfr.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MenuAdapter extends BaseAdapter {
	private Context context;
	private Integer item[];
	
	public MenuAdapter(Context context, Integer item[]) {
		this.context = context;
		this.item = item;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView img;
		if(convertView == null){
			img = new ImageView(context);
			img.setLayoutParams(new GridView.LayoutParams(460,460));
			img.setScaleType(ImageView.ScaleType.CENTER_CROP);
			img.setPadding(8, 8, 8, 8);
		}else{
			img = (ImageView) convertView;
		}
		img.setImageResource(item[position]);
		return img;
		
		
	}

}
