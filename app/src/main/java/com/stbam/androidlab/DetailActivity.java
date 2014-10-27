package com.stbam.androidlab;

import android.app.ActionBar;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.view.WindowManager;

import com.parse.Parse;
import com.parse.ParseFile;


public class DetailActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        String name = intent.getStringExtra(MainActivity.NAME);
        String country = intent.getStringExtra(MainActivity.COUNTRY);
        String desc = intent.getStringExtra(MainActivity.DESC);

        Bundle bundle = new Bundle();
        String myMessage = name;
        String myMessage2 = country;
        String myMessage3 = desc;
        bundle.putString("message", myMessage );
        bundle.putString("message2", myMessage2 );
        bundle.putString("message3", myMessage3 );

        byte [] arr = getIntent().getByteArrayExtra("imagen1");
        byte [] arr2 = getIntent().getByteArrayExtra("imagen2");

        bundle.putByteArray("imagen1", arr);
        bundle.putByteArray("imagen2", arr2);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();

        DetailFragment ls_fragment = new DetailFragment();

        ls_fragment.setArguments(bundle);
        fragmentTransaction.replace(android.R.id.content, ls_fragment);

        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }
}
