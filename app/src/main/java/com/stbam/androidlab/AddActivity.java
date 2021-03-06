package com.stbam.androidlab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.Session;

public class AddActivity extends Activity {

    public final static String NAME = "NAME";
    public final static String COUNTRY = "COUNTRY";
    public final static String DESC = "DESC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add, menu);
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

    public void uploadFile(View view) {

        final EditText nameField = (EditText) findViewById(R.id.food_name);
        String name = nameField.getText().toString();
        final EditText countryField = (EditText) findViewById(R.id.country_name);
        String country = countryField.getText().toString();
        @SuppressLint("WrongViewCast") final EditText descField = (EditText) findViewById(R.id.desc);

        String desc = descField.getText().toString();
        Intent intent = new Intent(this, FileExplore.class);
        intent.putExtra(NAME, name);
        intent.putExtra(COUNTRY, country);
        intent.putExtra(DESC, desc);
        startActivity(intent);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }

}
