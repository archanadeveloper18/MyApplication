package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.items;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    public List<items> itemsList;
    public Context context;

    public CustomAdapter(List<items> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_data,null);

        //find View
        TextView name = view.findViewById(R.id.textView1);
        TextView value = view.findViewById(R.id.textView2);
        ImageView image = view.findViewById(R.id.imageView);

        //set data
        name.setText(itemsList.get(position).getName());
        double currentValueDouble = getCurrentValue();
        value.setText(String.valueOf(itemsList.get(position).getCurrentValue()));

        //set image
        Glide.with(context)
                .load(itemsList.get(position).getUrl())
                .into(image);


        return view;
    }
}
