package com.tiennn.apphotrotimhieuluatgiaothong.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tiennn.apphotrotimhieuluatgiaothong.R;
import com.tiennn.apphotrotimhieuluatgiaothong.models.VideoYouTube;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VideoYouTubeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<VideoYouTube> videoYouTubeList;
    private ArrayList<VideoYouTube> arrayList;

    public VideoYouTubeAdapter(Context context, int layout, List<VideoYouTube> videoYouTubeList) {
        this.context = context;
        this.layout = layout;
        this.videoYouTubeList = videoYouTubeList;

        this.arrayList = new ArrayList<VideoYouTube>();
        this.arrayList.addAll(videoYouTubeList);
    }

    @Override
    public int getCount() {
        return videoYouTubeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgThumbnail;
        TextView tvTitle;


    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.tvTitle =(TextView) view.findViewById(R.id.tvTitle);
            holder.imgThumbnail =(ImageView) view.findViewById(R.id.imgThumbnail);
            view.setTag(holder);
        }else {
            holder =(ViewHolder) view.getTag();
        }
        VideoYouTube video = videoYouTubeList.get(i);

        holder.tvTitle.setText(video.getTitle());
        Picasso.with(context).load(video.getThumbnail()).into(holder.imgThumbnail);

        return view;
    }

    //Filer class
    public void filer(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        videoYouTubeList.clear();

        for (VideoYouTube video: arrayList
             ) {
            if (video.getTitle().toLowerCase(Locale.getDefault()).contains(charText)){
                videoYouTubeList.add(video);
            }
        }
        notifyDataSetChanged();
    }
}
