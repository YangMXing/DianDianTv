package com.example.diandiantv;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView channelList;
    private ChannelListAdapter channelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        channelList = (RecyclerView) findViewById(R.id.channellist);

       channelList.setLayoutManager(new LinearLayoutManager(this));
       channelList.setAdapter(new ChannelListAdapter(MainActivity.this, new ChannelListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                String channelName = ChannelLab.get().getChannel(pos);
                String channelUrl = ChannelLab.get().getUrl(pos);
                Intent intent = new Intent(MainActivity.this,LiveActivity.class);
                intent.putExtra("uri",channelUrl);
                intent.putExtra("name",channelName);
                startActivity(intent);
            }
        }));
    }
}

