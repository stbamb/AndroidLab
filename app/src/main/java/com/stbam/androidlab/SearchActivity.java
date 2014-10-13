package com.stbam.androidlab;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;


public class SearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String search = getIntent().getStringExtra(SearchManager.QUERY);
        searchItems(search);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void searchItems(String queryName)
    {
        Parse.initialize(this, "Y0mOecKDjUv0lixClVVmiyf4Z0cBLtcEjJgNvEfu", "bqmKEcudc7JIJd90hkTwtjqhO4lXk58RZU5oV5ta");
        FoodAdapter foodAdapter	=	new	FoodAdapter(this, queryName);
        ListView listView	=	(ListView)	findViewById(R.id.foundItems);
        listView.setAdapter(foodAdapter);
        foodAdapter.loadObjects();
    }
}
