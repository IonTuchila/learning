package com.example.e7450.bussinesapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


/**
 * Created by E7450 on 1/20/2017.
 */

public class FullImageActivity extends Activity {

    ViewPager viewPager;
     Context mContext ;
    public static String LOG_STRING = "LOG";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
        setContentView(R.layout.full_image);
        Intent i = getIntent();
        mContext = this;
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        final ImageAdapter imageAdapter = new ImageAdapter(this);
        //viewPager.setAdapter(new Adap(this));
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageAdapter.mThumbIds.length;
            }


            @Override
            public View instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //imageView.setImageResource(imageAdapter.mThumbIds[position]);
                Picasso.with(mContext).load("http://a3.mzstatic.com/us/r30/Purple41/v4/b6/b1/74/b6b174cd-7f7d-4f39-920a-26186d9a21ee/icon175x175.jpeg").into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("OKSUCCES PICASSO","OKSUCCES PICASSO");
                    }

                    @Override
                    public void onError() {
                        Log.d("ERROR PICASSO","ERROR PICASSO");
                    }
                });

                container.addView(imageView);
                Log.d(LOG_STRING, "succes instantiateItem" + position);
                return imageView;

            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });

        int position = i.getExtras().getInt("id");
        viewPager.setCurrentItem(position);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("FullImage Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
