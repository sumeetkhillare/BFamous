package com.example.bfamous;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

public class PlayYT extends AppCompatActivity { //implements YouTubePlayer.OnInitializedListener{
    RecyclerView recyclerView;
    Vector<YouTubeVideos>youTubeVideos=new Vector<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_yt);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youTubeVideos.add(new YouTubeVideos("<iframe"));
    }


    /*public static final String API_KEY = "AIzaSyDbKZa2XguzQrN3lcEnOE4PwD6trOeAtqc";
    public static final String VIDEO_ID = "https://www.youtube.com/watch?v=SfZeAVYXGDA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_yt);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView)findViewById(R.id.yt_player);
        youTubePlayerView.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(PlayYT.this,"Error loading video",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        if (!b)
        {
            youTubePlayer.cueVideo(VIDEO_ID);

        }

    }

    private PlaybackEventListener playbackEventListener=new PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    private PlayerStateChangeListener playerStateChangeListener=new PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(ErrorReason errorReason) {

        }
    };
*/}
