package com.example.sunny_appen.ui.leaderboard;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunny_appen.Member;
import com.example.sunny_appen.R;
import com.example.sunny_appen.recycler.OnClickListener;


import java.util.ArrayList;

public class LeaderboardMemberListAdapter extends RecyclerView.Adapter<LeaderboardMemberListAdapter.ViewHolder> {
    private ArrayList<Member> members;
    private OnClickListener listener;

    public LeaderboardMemberListAdapter(ArrayList<Member> members){
        this.members = members;
    }

    public LeaderboardMemberListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item, parent, false);;
        LeaderboardMemberListAdapter.ViewHolder viewH = new LeaderboardMemberListAdapter.ViewHolder(view);
        return viewH;
    }

    public void setOnClickListner(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardMemberListAdapter.ViewHolder holder, int position) {
        holder.name.setText(members.get(position).getName());
        holder.points.setText(members.get(position).getPointsAsString());
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name;
        private final TextView points;

        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.MemberName);
            points = itemView.findViewById(R.id.MemberPoints);

            itemView.setOnClickListener(v ->{
//                listener.onClick(players.get(getBindingAdapterPosition()));
                System.out.println("idk");
            });
        }
    }
}