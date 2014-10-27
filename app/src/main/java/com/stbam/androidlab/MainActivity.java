package com.stbam.androidlab;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.io.File;


public class MainActivity extends Activity {

    public final static String NAME = "NAME";
    public final static String COUNTRY = "COUNTRY";
    public final static String DESC = "DESC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, "Y0mOecKDjUv0lixClVVmiyf4Z0cBLtcEjJgNvEfu", "bqmKEcudc7JIJd90hkTwtjqhO4lXk58RZU5oV5ta");
        //ParseFacebookUtils.initialize("1518773961702440");
        FoodAdapter foodAdapter	= new FoodAdapter(this);
        final ListView listView = (ListView)	findViewById(R.id.list);
        listView.setAdapter(foodAdapter);
        foodAdapter.loadObjects();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // actions to be performed when a list item clicked
                int pos = arg2;

                // llamar a la funcion que marca el articulo como leido

                ParseObject object = (ParseObject) listView.getItemAtPosition(pos);

                String name = object.getString("name");
                String type = object.getString("type");
                String desc = object.getString("desc");


                ParseFile imageFile = object.getParseFile("image");

                ParseFile countryFlag = object.getParseFile("countryFlag");

                byte[] image = {};
                byte[] image2 = {};

                try {
                    image = imageFile.getData();
                    image2 = countryFlag.getData();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                Bundle bundle = new Bundle();

                intent.putExtra(NAME, name);
                intent.putExtra(COUNTRY, type);
                intent.putExtra(DESC, desc);

                bundle.putByteArray("imagen1", image);
                bundle.putByteArray("imagen2", image2);

                intent.putExtras(bundle);


                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_option).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.add_option:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                return true;

            case R.id.social_option:
                Intent intent2 = new Intent(this, SocialActivity.class);
                startActivity(intent2);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
