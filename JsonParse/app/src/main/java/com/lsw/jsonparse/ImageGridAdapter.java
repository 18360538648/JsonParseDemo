package com.lsw.jsonparse;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Hankkin on 15/11/22.
 */
public class ImageGridAdapter extends BaseAdapter {

    private Context context;
    private List<String> imgUrls;
    private LayoutInflater inflater;

    public ImageGridAdapter(Context context, List<String> imgUrls) {
        this.context = context;
        this.imgUrls = imgUrls;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imgUrls.size();
    }

    @Override
    public Object getItem(int i) {
        return imgUrls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.image_gridview_item, null);
        ImageView iv_content = (ImageView) view.findViewById(R.id.iv_content);
        String mediaUrl = imgUrls.get(i);
        Log.i("lsw", "mediaUrl" + mediaUrl);
        Glide.with(context).load(mediaUrl).error(R.mipmap.ic_launcher).into(iv_content);
        return view;
    }
}
