package com.example.bfamous.Model;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koddev.instagramtest.R;

public class WebView extends Fragment {
   private WebView web;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_web_view,container,false);
        //web=view.findViewById(R.id.fragment_web_view);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
