package com.example.administrator.jianzhimao.adapter;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.jianzhimao.R;

import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2016/11/6.
 */

public class Joblistadapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;
    private List<Job> list;




    public Joblistadapter(Context context,List<Job> list){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class  ViewHolder{
        public TextView type;
        public TextView title;
        public TextView local;
        public TextView data;
        public TextView pushtime;
        public TextView money;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_jobinfo,null);
            holder.type = (TextView) convertView.findViewById(R.id.job_type);
            holder.title = (TextView) convertView.findViewById(R.id.job_title);
            holder.local = (TextView) convertView.findViewById(R.id.job_local);
            holder.data = (TextView) convertView.findViewById(R.id.job_data);
            holder.pushtime = (TextView) convertView.findViewById(R.id.job_pushtime);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(list.get(position).getTitle());
        return convertView;
    }
}
