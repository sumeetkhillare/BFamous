package com.example.bfamous;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class PDF extends AppCompatActivity {

    private ImageView ytb,blogb,imgb,pdfb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        ytb=(ImageView)findViewById(R.id.ytlinkb);
        imgb=(ImageView)findViewById(R.id.imgupload);
        blogb=(ImageView)findViewById(R.id.blogb);
        pdfb=(ImageView)findViewById(R.id.pdfupload);
        ytb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PDF.this,PostActivity.class));
            }
        });
        blogb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        pdfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PDF.this,Otherfile.class));
            }
        });
        }

    private void sendtootherfile() {
        Intent intent=new Intent(PDF.this,Otherfile.class);
        startActivity(intent);

    }

    private void sendtopost() {
        Intent intent=new Intent(PDF.this,PostActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PDF.this,AllAct.class));
    }
}
