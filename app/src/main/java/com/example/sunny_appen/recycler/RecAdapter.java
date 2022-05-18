package com.example.sunny_appen.recycler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunny_appen.Player;
import com.example.sunny_appen.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    private ArrayList<Player> players;
    private OnClickListener listener;

    public RecAdapter(ArrayList<Player> player){
        this.players = player;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_items, parent, false);;
        ViewHolder viewH = new ViewHolder(view);
        return viewH;
    }

    public void setOnClickListner(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(players.get(position).getNavn());
        holder.pricing.setText("idk");
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name;
        private final ImageView icon;
        private final TextView pricing;

        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            pricing = itemView.findViewById(R.id.tv_pricing);
            icon = itemView.findViewById(R.id.iv_icon);
            itemView.setOnClickListener(v ->{
//                listener.onClick(players.get(getBindingAdapterPosition()));
                System.out.println("idk");
            });
        }
    }

}
