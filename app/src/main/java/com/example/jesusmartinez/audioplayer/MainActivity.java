package com.example.jesusmartinez.audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    //reproductor

    private MediaPlayer mediaPlayer;
    boolean wasPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this,R.raw.broken);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();


        //si se está reproduciendo audio

        if (mediaPlayer.isPlaying()) {

            //pauso reproducción
            mediaPlayer.pause();
            //indico que se estaba reproduciendo
            wasPlaying=true;
        }

        else {
            wasPlaying=false;
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        //si se estaba reproduciendo
        if (wasPlaying) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //libero el reproductor
        mediaPlayer.release();
        mediaPlayer=null;
    }

    public void onClickPlay (View button) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            button.setBackground(getResources().getDrawable(android.R.drawable.ic_media_play));
        } else {
            mediaPlayer.start();
            button.setBackground(getResources().getDrawable(android.R.drawable.ic_media_pause));

        }

    }
}
