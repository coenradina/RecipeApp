package com.example.RecipeApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.RecipeApp.R;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class RecipeDetailActivity extends AppCompatActivity {
    SimpleExoPlayer recipeVideoPlayer = ExoPlayerFactory.newSimpleInstance(this);
    PlayerView playerView;
    private Uri recipeVideo;
    String url = "http://google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        playerView = findViewById(R.id.video_view);
        playerView.setPlayer(recipeVideoPlayer);
        recipeVideo = Uri.parse(url);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, String.valueOf(R.string.app_name)));

        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(recipeVideo);

        recipeVideoPlayer.prepare(videoSource);
    }
}
