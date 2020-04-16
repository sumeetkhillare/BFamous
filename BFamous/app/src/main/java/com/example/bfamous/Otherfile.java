package com.example.bfamous;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Otherfile extends AppCompatActivity {

    private Uri pdfUri;
    private ProgressDialog progressDialog;
    private Button uploadb,fetchb;
    private Button chooseb;
    private TextView filenm;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseStorage firebaseStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseStorage=FirebaseStorage.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_otherfile);
        uploadb=(Button)findViewById(R.id.uploadfile);
        chooseb=(Button)findViewById(R.id.selectfile);
        fetchb=(Button)findViewById(R.id.fetchb);
        filenm=(TextView) findViewById(R.id.filename);
        fetchb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    gotorecycler();
            }
        });
        uploadb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pdfUri!=null)
                {
                    uploadFile();
                }
                else
                    Toast.makeText(Otherfile.this,"Select file",Toast.LENGTH_SHORT).show();
            }
        });
        chooseb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Otherfile.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
                {
                    selectPdf();
                }
                else
                    ActivityCompat.requestPermissions(Otherfile.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);

            }
        });

    }

    private void gotorecycler() {
    Intent intent=new Intent(Otherfile.this,AllAct.class);
    startActivity(intent);
    }

    private void uploadFile() {
        final String filenm1=System.currentTimeMillis()+"";
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading file...");
        progressDialog.setProgress(0);
        progressDialog.show();
        final String filenm=System.currentTimeMillis()+".pdf";
        StorageReference storageReference=firebaseStorage.getReference();
        storageReference.child("PDF Uploads").child(filenm).putFile(pdfUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                String url=taskSnapshot.getDownloadUrl().toString();
                DatabaseReference databaseReference=firebaseDatabase.getReference();
                databaseReference.child(filenm1).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Otherfile.this,"Successfully uploaded...",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Otherfile.this,"NOT Successfully uploaded...",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Otherfile.this,"NOT Successfully uploaded...",Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==9&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectPdf();
        }
        else
            Toast.makeText(Otherfile.this,"Please provide permission",Toast.LENGTH_SHORT).show();

    }

    private void selectPdf() {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==86&&resultCode==RESULT_OK&&data!=null)
        {
            pdfUri=data.getData();
            filenm.setText("A File is selected:"+data.getData().getLastPathSegment());
        }
        else
        {
            Toast.makeText(Otherfile.this,"Please select a file...",Toast.LENGTH_SHORT).show();
        }

    }
}
