package com.example.bfamous;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class AllAct extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private RecyclerView postList;
    private Toolbar mtoolbar;
    private ImageView viewposts;
    private ImageView addpost;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        mtoolbar = (Toolbar)findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("home");
        drawerLayout=(DrawerLayout) findViewById(R.id.drawable_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(AllAct.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        //View navView = navigationView.inflateHeaderView(R.layout.navigation_header);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserMenuSelector(item);
                return false;
            }


        });

        /*mtoolbar = (Toolbar)findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("home123");
        drawerLayout=(DrawerLayout)findViewById(R.id.drawable_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(AllAct.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserMenuSelector(item);
                return false;
            }


        });
 */   }


   /* @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser=mauth.getCurrentUser();
        if(currentuser==null)
        {
            SendUserToLogin();
        }
        else
        {
            currentuserid=mauth.getCurrentUser().getUid();
            View navView = navigationView.inflateHeaderView(R.layout.navigation_header);
            NavUsername=(TextView)navView.findViewById(R.id.NavUsername);
            usersref.child(currentuserid).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        String fullname=dataSnapshot.child("username").getValue().toString();
                        NavUsername.setText(fullname);
                        //NavProfileImage.setImageURI();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

    }
*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void UserMenuSelector(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_home:
                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
                SendUserToHome();
                break;
            case R.id.nav_friends:
                Toast.makeText(this,"Friends",Toast.LENGTH_SHORT).show();
                SendusertoSearch();
                break;
            case R.id.nav_settings:
                SendusertoEdit();
                break;
            case R.id.nav_logout:
               Toast.makeText(AllAct.this,"Logout",Toast.LENGTH_SHORT).show();
                Logout();
                break;
            case R.id.nav_addpost:
                SendusertoAddpost();
                break;
            case R.id.nav_notif:
                Sendusertonotif();
                break;
            case R.id.nav_profile:
                Sendusertoprof();
                break;
            case R.id.nav_blogs:
                SendusertoBlogs();
                break;
            case R.id.nav_ytlinks:
                Sendusertoyt();
                break;
        }
    }

    private void Sendusertoyt() {
    startActivity(new Intent(AllAct.this,Ytlink.class));
    }

    private void SendusertoBlogs() {
    startActivity(new Intent(AllAct.this,Blog.class));
    }

    private void Logout() {
    }

    private void Sendusertoprof() {
        startActivity(new Intent(AllAct.this,ProfileFrag.class));
    }

    private void Sendusertonotif() {
        startActivity(new Intent(AllAct.this,NotificAct.class));
    }

    private void SendUserToHome() {
        Intent settingsintent = new Intent(AllAct.this,HomeAct.class);
        settingsintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settingsintent);
        finish();

    }


    private void SendusertoSearch() {
        Intent settingsintent = new Intent(AllAct.this,SearchAct.class);
        settingsintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settingsintent);
        finish();
    }
    private void SendusertoEdit() {
        Intent settingsintent = new Intent(AllAct.this,EditProfileActivity.class);
        settingsintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settingsintent);
        finish();
    }
    private void SendUserToNotif() {
        Intent settingsintent = new Intent(AllAct.this,NotificAct.class);
        settingsintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settingsintent);
        finish();
    }
    private void SendusertoAddpost() {
        Intent settingsintent = new Intent(AllAct.this,PDF.class);
        settingsintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settingsintent);
        finish();
    }


}
