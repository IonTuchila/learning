package com.example.e7450.bussinesapp;

/**
 * Created by E7450 on 1/18/2017.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by E7450 on 1/18/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public Integer[] mThumbIds = {
            R.drawable.download1, R.drawable.download2,
            R.drawable.download3, R.drawable.download4,
            R.drawable.download5, R.drawable.download6,
            R.drawable.download7, R.drawable.download8,
            R.drawable.download9, R.drawable.download10


    };
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;

    }
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(mThumbIds[position]);
        return  imageView;
        }
    }


