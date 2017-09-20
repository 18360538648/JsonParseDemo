package com.lsw.jsonparse;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luosiwei on 2017/7/3.
 */

public class ActivityDisplayAdapter extends BaseAdapter {
    private Context mContext;
    private List<ActivitiesDisplayItemBean> mActivitiesDisplayItemBeanList;

    public ActivityDisplayAdapter(Context context, List<ActivitiesDisplayItemBean> activitiesDisplayItemBeanList) {
        this.mContext = context;
        this.mActivitiesDisplayItemBeanList = activitiesDisplayItemBeanList;
    }


    @Override
    public int getCount() {
        return mActivitiesDisplayItemBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mActivitiesDisplayItemBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.ll_activities_display_item, null);
            viewHolder.tvActivityAddress = (TextView) convertView.findViewById(R.id.tv_activity_address);
            viewHolder.tvActivityContent = (TextView) convertView.findViewById(R.id.tv_activity_content);
            viewHolder.tvActivityMood = (TextView) convertView.findViewById(R.id.tv_activity_mood);
            viewHolder.picDisplayGv = (NoScrollGridView) convertView.findViewById(R.id.gv_activity_display);
            viewHolder.tvSuject = (TextView) convertView.findViewById(R.id.tv_subject);
            viewHolder.tvActivityTime = (TextView) convertView.findViewById(R.id.tv_activity_time);
            viewHolder.ll_delete_activity = (RelativeLayout) convertView.findViewById(R.id.ll_delete_activity);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ActivitiesDisplayItemBean activitiesDisplayItemBean = mActivitiesDisplayItemBeanList.get(position);
        viewHolder.tvActivityTime.setText(StampToDateUtils.stampToDateLong(activitiesDisplayItemBean.getWhen()));
        String subjectType;
        if (activitiesDisplayItemBean.getSubject().equals("mu")) {
            subjectType = "音乐";
        } else if (activitiesDisplayItemBean.getSubject().equals("ar")) {
            subjectType = "美术";
        } else {
            subjectType = "未知";
        }
        viewHolder.tvSuject.setText(subjectType);
        viewHolder.tvActivityAddress.setText(activitiesDisplayItemBean.getWhere());
        viewHolder.tvActivityContent.setText(activitiesDisplayItemBean.getContent());
        if (!activitiesDisplayItemBean.getSummary().equals("")) {
            viewHolder.tvActivityMood.setVisibility(View.VISIBLE);
            viewHolder.tvActivityMood.setText("感想:" + activitiesDisplayItemBean.getSummary());
        } else {
            viewHolder.tvActivityMood.setVisibility(View.GONE);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < activitiesDisplayItemBean.getAssets().size(); i++) {
            list.add(activitiesDisplayItemBean.getAssets().get(i).getUrl());
        }
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(mContext, list);
        viewHolder.picDisplayGv.setAdapter(imageGridAdapter);
        return convertView;
    }

    public class ViewHolder {
        TextView tvActivityAddress;
        TextView tvActivityContent;
        TextView tvActivityMood;
        NoScrollGridView picDisplayGv;
        TextView tvSuject;
        TextView tvActivityTime;
        RelativeLayout ll_delete_activity;
    }
}
