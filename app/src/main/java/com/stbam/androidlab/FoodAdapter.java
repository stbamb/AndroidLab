package com.stbam.androidlab;

/**
 * Created by Esteban on 11-Oct-14.
 */

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

public class FoodAdapter extends ParseQueryAdapter<ParseObject> {

    public FoodAdapter(Context context) {
        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("Food");
                return query;
            }
        });
    }

    public FoodAdapter(Context context, final String queryName) {
        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("Food");
                Log.d("query: ", queryName);
                query.whereEqualTo("name", queryName);
                return query;
            }
        });
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if (v == null) {
            v = View.inflate(getContext(), R.layout.fooditem, null);
        }
        super.getItemView(object, v, parent);
        ParseImageView foodImage = (ParseImageView) v.findViewById(R.id.icon);
        ParseFile imageFile = object.getParseFile("image");
        if (imageFile != null) {
            foodImage.setParseFile(imageFile);
            foodImage.loadInBackground();
        }
        ParseImageView countryFlag = (ParseImageView) v.findViewById(R.id.flag);
        imageFile = object.getParseFile("countryFlag");
        if (imageFile != null) {
            countryFlag.setParseFile(imageFile);
            countryFlag.loadInBackground();
        }
        TextView nameTextView = (TextView) v.findViewById(R.id.name);
        nameTextView.setText(object.getString("name"));
        TextView typeView = (TextView) v.findViewById(R.id.type);
        typeView.setText(object.getString("type"));
        TextView descView = (TextView) v.findViewById(R.id.desc);
        descView.setText(object.getString("desc"));
        return v;
    }
}
