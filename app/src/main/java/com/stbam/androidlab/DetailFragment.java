package com.stbam.androidlab;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;

import java.io.ByteArrayInputStream;


public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        String myValue = this.getArguments().getString("message"); //name
        String myValue2 = this.getArguments().getString("message2"); //country || type
        String myValue3 = this.getArguments().getString("message3"); //desc


        byte [] arr = this.getArguments().getByteArray("imagen1");

        byte [] arr2 = this.getArguments().getByteArray("imagen2");


        ParseFile pFile = new ParseFile("heya", arr);

        ParseFile pFile2 = new ParseFile("heya", arr2);

        TextView typeView = (TextView) view.findViewById(R.id.type2);
        TextView typeView2 = (TextView) view.findViewById(R.id.desc2);
        TextView typeView3 = (TextView) view.findViewById(R.id.name2);
        ParseImageView foodImage = (ParseImageView) view.findViewById(R.id.icon2);
        ParseImageView flagImage = (ParseImageView) view.findViewById(R.id.flag2);


        typeView.setText(myValue2);
        typeView2.setText(myValue3);
        typeView3.setText(myValue);


        if (pFile != null) {
            foodImage.setParseFile(pFile);
            foodImage.loadInBackground();
        }

        if (pFile2 != null) {
            flagImage.setParseFile(pFile2);
            flagImage.loadInBackground();
        }

        return view;
    }


}
