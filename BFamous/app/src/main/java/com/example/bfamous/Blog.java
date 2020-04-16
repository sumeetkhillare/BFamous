package com.example.bfamous;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.koddev.instagramtest.Adapter.PostAdapter;
import com.koddev.instagramtest.Model.Post;

import java.util.ArrayList;
import java.util.List;

public class Blog extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private WebView webView;
    private PostAdapter postAdapter;
    private List<Post> postList;
    private List<String> followingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        webView = (WebView) findViewById(R.id.web_view);
        WebSettings webSettings = webView.getSettings();
        webView.loadUrl("https://gambhirwrites.blogspot.com/2019/03/struggle.html");
        webView.setWebChromeClient(new WebChromeClient());

        //recyclerView = view.findViewById(R.id.recycler_view);
        //recyclerView.setHasFixedSize(true);
        //LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        //mLayoutManager.setReverseLayout(true);
        //mLayoutManager.setStackFromEnd(true);
        //recyclerView.setLayoutManager(mLayoutManager);
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(Blog.this, postList);
  //      webView.setAdapter(postAdapter);

        //recyclerView_story = view.findViewById(R.id.recycler_view_story);
        //recyclerView_story.setHasFixedSize(true);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
        //      LinearLayoutManager.HORIZONTAL, false);
        //recyclerView_story.setLayoutManager(linearLayoutManager);
        //  storyList = new ArrayList<>();
        //storyAdapter = new StoryAdapter(getContext(), storyList);
        //recyclerView_story.setAdapter(storyAdapter);

       // progress_circular = view.findViewById(R.id.progress_circular);

        checkFollowing();

        //return view;
    }

    private void checkFollowing(){
        followingList = new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Follow")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("following");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                followingList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    followingList.add(snapshot.getKey());
                }

                readPosts();
                //readStory();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void readPosts(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Post post = snapshot.getValue(Post.class);
                    for (String id : followingList){
                        if (post.getPublisher().equals(id)){
                            postList.add(post);
                        }
                    }
                }

                postAdapter.notifyDataSetChanged();
              //  progress_circular.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /*@Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {super.onBackPressed();}
    }
*/

    public void onBackPressed() {

       startActivity(new Intent(Blog.this,AllAct.class));

    }
}
