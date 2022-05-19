package com.example.sunny_appen.ui.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunny_appen.R;
import com.example.sunny_appen.Repo;
import com.example.sunny_appen.databinding.FragmentLeaderboardBinding;
import com.example.sunny_appen.Member;

import java.util.ArrayList;

public class Leaderboard extends Fragment {

    private FragmentLeaderboardBinding binding;
    private RecyclerView adapter;
    private Repo repo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LeaderBoardViewModel homeViewModel = new ViewModelProvider(this).get(LeaderBoardViewModel.class);

        binding = FragmentLeaderboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        repo = Repo.getInstance();


        setText();

        final TextView textView = binding.leaderBoardTitle;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void setText(){
        adapter = binding.getRoot().findViewById(R.id.recyclerViewSunny);
        adapter.hasFixedSize();
        adapter.setLayoutManager(new LinearLayoutManager(this.getContext()));

        repo.getPlayers().observe(getViewLifecycleOwner(), player -> {

            ArrayList<Member> members = new ArrayList<>();
            members.add(new Member("Kasper",88));
            members.add(new Member("Nees",69));
            members.add(new Member("Kriller",55));
            members.add(new Member("Bo",32));
            members.add(new Member("Chen",29));
            members.add(new Member("Andreas",15));
            members.add(new Member("Marcus",11));


            LeaderboardMemberListAdapter b = new LeaderboardMemberListAdapter(members);
            adapter.setAdapter(b);

            b.setOnClickListner(p -> {
                System.out.println(p.getNavn());
            });
        });

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
