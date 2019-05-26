package com.example.diandiantv;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class LiveActivity extends AppCompatActivity {
    private PlayerView bofang;
    private Button quanping,fanhui;
    private RelativeLayout jiemian;
    private TextView biaoti;
    SimpleExoPlayer player;
    static Boolean  aBoolean = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.activity_live);

        jiemian = findViewById(R.id.jiemian);

        fanhui = findViewById(R.id.fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        quanping = findViewById(R.id.quanping);
        quanping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aBoolean == false) {
                    player.stop();
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    aBoolean=true;
                }
                Log.d("LifeCycle",aBoolean.toString());
            }
        });
        if (aBoolean == true){
            quanping.setVisibility(View.GONE);
            jiemian.setVisibility(View.GONE);
        }
        Intent intent = getIntent();
        Uri uri = Uri.parse(intent.getStringExtra("uri"));
        String channelname = intent.getStringExtra("name");
        biaoti = findViewById(R.id.movieName);
        biaoti.setText(channelname);



        bofang = (PlayerView) findViewById(R.id.palyerview);

        player = ExoPlayerFactory.newSimpleInstance(this);

        player.setPlayWhenReady(true);
        bofang.setPlayer(player);

        DataSource.Factory factory = new DefaultDataSourceFactory(this, "asd");


        HlsMediaSource source = new HlsMediaSource.Factory(factory).createMediaSource(uri);
        player.prepare(source);
    }

    protected void onDestroy() {
        super.onDestroy();


        Log.d("LifeCycle", "--onDestroy--");
        if (player != null) {
            player.stop();
        }
    }

    protected void onPause() {
        super.onPause();

        Log.d("LifeCycle", "--onPause--");

        if (player != null) {
            player.setPlayWhenReady(false);
            player.stop();
        }
    }

    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "--onStart--");

        if (player == null) {
            player.setPlayWhenReady(true);
        }

    }

    @Override
    public void onBackPressed() {
        if (aBoolean == false) super.onBackPressed();
        else {
            aBoolean = false;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            Log.d("LifeCycle", aBoolean.toString());
        }
        Log.d("LifeCycle", "--onBackPressed--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        player.setPlayWhenReady(true);
        Log.d("LifeCycle", "--onRestart--");
    }
}
