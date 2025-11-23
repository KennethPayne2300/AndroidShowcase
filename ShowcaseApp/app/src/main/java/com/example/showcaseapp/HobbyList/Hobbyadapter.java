package com.example.showcaseapp.HobbyList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.showcaseapp.R;

import java.util.ArrayList;

public class Hobbyadapter extends RecyclerView.Adapter<Hobbyadapter.MyViewHolder> {
    private ArrayList<Hobby> hobbyList;

    public Hobbyadapter(ArrayList<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemText.setText(hobbyList.get(possion));
    }

    @Override
    public int getItemCount() {
        return hobbyList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemText;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.Item_Text);
        }
    }
}
