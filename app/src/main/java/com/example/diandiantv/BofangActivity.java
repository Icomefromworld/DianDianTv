package com.example.diandiantv;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class BofangActivity extends AppCompatActivity {
    PlayerView bofang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bofang);

        bofang = findViewById(R.id.bofang);

        ExoPlayer player = ExoPlayerFactory.newSimpleInstance(this);
        player.setPlayWhenReady(true);
        bofang.setPlayer(player);

        DataSource.Factory factory = new DefaultDataSourceFactory(this, "DDPlayer");
        Uri uri = Uri.parse("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8");
        HlsMediaSource source = new HlsMediaSource.Factory(factory).createMediaSource(uri);
        player.prepare(source);
    }
}
