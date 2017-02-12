package com.example.e7450.bussinesapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;


public class List extends Activity {
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        context = this;

        ArrayList<SearchResults> searchResults = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.ListView01);
        lv1.setAdapter(new MyCustomBaseAdapter(this, searchResults));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                SearchResults fullObject = (SearchResults)o;
                Toast.makeText(context, "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<SearchResults> GetSearchResults(){
        ArrayList<SearchResults> results = new ArrayList<SearchResults>();

        SearchResults sr1 = new SearchResults();
        sr1.setName("Tuchila Ion");
        sr1.setCityState("Moldova,Chisinau");
        sr1.setPhone("068945943");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Dorin Dobos");
        sr1.setCityState("Falesti,Ilenuta");
        sr1.setPhone("060212172");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Steve Young");
        sr1.setCityState("Miami, FL");
        sr1.setPhone("305-555-7895");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Boris Fedco");
        sr1.setCityState("Soroca,Soroca");
        sr1.setPhone("078542323");
        results.add(sr1);

        return results;
    }
}