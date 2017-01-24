package com.example.e7450.bussinesapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * Created by E7450 on 1/20/2017.
 */

public class FullImageActivity extends Activity {

    ViewPager viewPager;
    final Context mContext = this;
    public void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.full_image);
        Intent i = getIntent();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
         final ImageAdapter imageAdapter = new ImageAdapter(this);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageAdapter.mThumbIds.length;
            }

            @Override
            public void startUpdate(ViewGroup container) {
                super.startUpdate(container);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(imageAdapter.mThumbIds[position]);
                container.addView(imageView,position);
                return  imageView;

            }

            @Override
            public Object instantiateItem(View container, int position) {
                return super.instantiateItem(container, position);
            }

            @Override
          public   void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager)container).removeView((View) object);
                //super.destroyItem(container, position, object);
                //container.removeView((View)object);

            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return true;
            }
        });

        int position = i.getExtras().getInt("id");

        //ImageView imageView =(ImageView) findViewById(R.id.full_image_view);
       // imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }
}
