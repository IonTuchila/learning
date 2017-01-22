package com.example.e7450.bussinesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by E7450 on 1/20/2017.
 */

public class FullImageActivity extends Activity {
    public void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.full_image);
        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        ImageView imageView =(ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }
}
