package com.example.e7450.bussinesapp;

/**
 * Created by E7450 on 1/18/2017.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by E7450 on 1/18/2017.
 */

public  class ImageAdapter extends BaseAdapter {
     Context mContext;
    private LayoutInflater inflater;
    private String[] imageUrls;
    public Integer[] mThumbIds = {
            R.drawable.download1, R.drawable.download2,
            R.drawable.download3, R.drawable.download4,
            R.drawable.download5, R.drawable.download6,
            R.drawable.download7, R.drawable.download8,
            R.drawable.download9, R.drawable.download10,


    };

    @Override
    public int getCount() {
        return mThumbIds.length;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mThumbIds[position]);
       //((ViewPager)parent).addView(imageView,0);
        return  imageView;
    }



}
