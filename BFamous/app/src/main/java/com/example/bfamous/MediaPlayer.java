package com.example.bfamous;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MediaPlayer extends AppCompatActivity {
    Button buttonplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_media_player);
        buttonplayer = (Button) findViewById(R.id.buttonplayer);


        public void playsong ()
        {
            /*String url = "http://........"; // your URL here
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();
            */
            // MediaPlayer mPlayer = MediaPlayer.create(activity, R.raw.your_wave_audio_file);
            //mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        }

    }
