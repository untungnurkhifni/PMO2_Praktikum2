package com.example.asus.praktikum2;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainkan1, mainkan2, streaming, video, hentikan;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainkan1 = (Button) findViewById(R.id.btnmainkan1);
        mainkan2 = (Button) findViewById(R.id.btnmainkan2);
        streaming = (Button) findViewById(R.id.btnmainkanstreaming);
        video = (Button) findViewById(R.id.btnmainkanvideo);
        hentikan = (Button) findViewById(R.id.btnhentikan);

        mainkan1.setOnClickListener(this);
        mainkan2.setOnClickListener(this);
        streaming.setOnClickListener(this);
        video.setOnClickListener(this);
        hentikan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Autuo-Generated method stub
        if (v.getId() == R.id.btnmainkan1) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {

            }

            mediaPlayer = MediaPlayer.create(getApplicationContext(),
                    R.raw.the_music);

            mediaPlayer.start();

        } else if (v.getId() == R.id.btnmainkan2) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;

            } catch (Exception e) {
            }

            mediaPlayer = MediaPlayer.create(getApplicationContext(),
                    R.raw.the_music);
            mediaPlayer.start();

        } else if (v.getId() == R.id.btnmainkanstreaming) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                //TODO: handle exception
            }
            String url = "http://www.virginmegastore.me/Library/Music/CD_001214/Tracks/Track1.mp3";
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();
            } catch (IllegalArgumentException e) {
                //TODO Auto-generated catch block
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (SecurityException e) {
                //TODO Auto-generated catch block
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (IllegalStateException e) {
                //TODO Auto-generated catch block
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                //TODO Auto-generated catch block
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            mediaPlayer.start();
        } else if (v.getId() == R.id.btnmainkanvideo) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;

            } catch (Exception e) {
                //TODO: handle exception
            }

            VideoView videoView = (VideoView) findViewById(R.id.videoView1);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ceramah);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();

            videoView.start();

        } else if (v.getId() == R.id.btnhentikan) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;

            } catch (Exception e) {
                //TODO: handle exception
            }
        }

    }
}