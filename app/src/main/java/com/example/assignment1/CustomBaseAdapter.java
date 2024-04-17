package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String subjects[];
    int subjectImage[];
    LayoutInflater inflater;
    public CustomBaseAdapter(Context ctx, String[] subjects, int[] subjectImage){
        this.context = ctx;
        this.subjects = subjects;
        this.subjectImage = subjectImage;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return subjects.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_subjects_listview, null);
        TextView text = (TextView) convertView.findViewById(R.id.sorting);
        ImageView image = (ImageView) convertView.findViewById(R.id.sort);
        text.setText(subjects[position]);
        image.setImageResource(subjectImage[position]);
        return convertView;
    }
}
