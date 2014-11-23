package com.beak.music.models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.beak.music.support.MediaUtils;
import com.bmusic.beak.bemusic.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 比克 on 2014/11/20.
 */
public class AudioAdapter extends BaseAdapter {

    public static final SimpleDateFormat DURATION_FORMAT = new SimpleDateFormat("mm:ss");

    private Context mContext = null;
    private List<Audio> mAudioList = null;

    public AudioAdapter (Context context) {
        mContext = context;
        mAudioList = MediaUtils.getAudioList (context);
    }

    @Override
    public int getCount() {
        return mAudioList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAudioList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mAudioList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Audio audio = mAudioList.get(position);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.layout_item, null);
            holder = new ViewHolder();
            holder.nameView = (TextView)convertView.findViewById(R.id.item_name);
            holder.artistView = (TextView)convertView.findViewById(R.id.item_artist);
            holder.durationView = (TextView)convertView.findViewById(R.id.item_duration);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.nameView.setText(audio.getTitle());
        holder.artistView.setText(audio.getArtist());
        holder.durationView.setText(DURATION_FORMAT.format(new Date(audio.getDuration())));
        return convertView;
    }

    private static class ViewHolder {
        public TextView nameView, artistView, durationView;
    }
}
