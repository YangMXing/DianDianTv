package com.example.diandiantv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ChannelViewHoler> {



    private Context mContext;
    private OnItemClickListener mListener;

    public ChannelListAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }


    @Override
    public ChannelViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel_view,parent,false);
        return new ChannelViewHoler(itemView);
    }

    @Override
    public void onBindViewHolder(ChannelViewHoler holder, final int position) {

        String name = ChannelLab.get().getChannel(position);
        holder.bind(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ChannelLab.get().getSize();
    }

    public class ChannelViewHoler extends RecyclerView.ViewHolder{

        private TextView channelName;

        public ChannelViewHoler(View itemView) {
            super(itemView);
            channelName = (TextView) itemView.findViewById(R.id.channelName);
        }

        public  void  bind(String channelName){
            this.channelName.setText((CharSequence) channelName);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

}