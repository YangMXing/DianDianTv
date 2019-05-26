package com.example.diandiantv;

import java.util.ArrayList;
import java.util.List;

public class ChannelLab {
    private static ChannelLab instance = null;
    private List<String> channel;
    private List<String> url;
    private List<String> list;

    private ChannelLab() {
        init();
    }

    public static ChannelLab get() {
        if (null == instance) {
            instance = new ChannelLab();
        }
        return instance;

    }

    public int getSize() {
        return channel.size();

    }

    public String getChannel(int n) {
        return channel.get(n);
    }

    public String getUrl(int n) {
        return url.get(n);
    }

    private void chaifen() {
        int n = 0;

        for (String i : list) {
            String[] tmp = i.split(",");
            channel.add(tmp[0]);
            url.add(tmp[1]);

        }

    }


    private void init() {
        channel = new ArrayList<>();
        url = new ArrayList<>();
        list = new ArrayList<>();
        list.add("北京怀柔1套,http://live.huairtv.com:1935/dvrLive/hrtvmb/playlist.m3u8");
        list.add("峨眉电影,http://scgctvshow.sctv.com/hdlive/emei/3.m3u8");
        list.add("四川文化,http://scgctvshow.sctv.com/hdlive/sctv2/3.m3u8");
        list.add("四川影视,http://scgctvshow.sctv.com/hdlive/sctv5/3.m3u8");
        list.add("四川公共,http://scgctvshow.sctv.com/sdlive/sctv9/3.m3u8");
        list.add("CCTV1,http://223.110.245.159/ott.js.chinamobile.com/PLTV/3/224/3221225852/index.m3u8");
        list.add("CCTV2,http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221227207/index.m3u8");
        list.add("CCTV3,http://223.110.245.147/ott.js.chinamobile.com/PLTV/3/224/3221226992/index.m3u8");
        list.add("CCTV4,http://223.110.245.165/ott.js.chinamobile.com/PLTV/3/224/3221225534/index.m3u8");
        list.add("CCTV8,http://223.110.245.141/ott.js.chinamobile.com/PLTV/3/224/3221225866/index.m3u8");
        list.add("CCTV9,http://223.110.245.161/ott.js.chinamobile.com/PLTV/3/224/3221225868/index.m3u8");
        chaifen();
    }
}