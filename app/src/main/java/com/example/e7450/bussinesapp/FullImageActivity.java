package com.example.e7450.bussinesapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;


/**
 * Created by E7450 on 1/20/2017.
 */

public class FullImageActivity extends Activity {

    ViewPager viewPager;
    final Context mContext = this;
    public static String LOG_STRING = "LOG";
    public void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.full_image);
        Intent i = getIntent();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
         final ImageAdapter imageAdapter = new ImageAdapter(this);
        //viewPager.setAdapter(new Adap(this));
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount()
            {
                return imageAdapter.mThumbIds.length;
            }


            @Override
            public View instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(imageAdapter.mThumbIds[position]);
                //Picasso.with(mContext).load("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQimF5gsnL4G5ryB61f1yklONy9TZznLzB4WiNUlCQJErin0xEj").into(imageView);

                container.addView(imageView);
                Log.d(LOG_STRING,"succes instantiateItem" + position);
                return  imageView;

            }

            @Override
          public   void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager)container).removeView((View) object);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });

        int position = i.getExtras().getInt("id");
        viewPager.setCurrentItem(position);
    }


}
