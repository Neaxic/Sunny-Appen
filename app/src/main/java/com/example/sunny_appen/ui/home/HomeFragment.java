package com.example.sunny_appen.ui.home;

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
import com.example.sunny_appen.databinding.FragmentHomeBinding;
import com.example.sunny_appen.recycler.OnClickListener;
import com.example.sunny_appen.recycler.RecAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Repo repo;
    private RecyclerView playerList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        repo = Repo.getInstance();


        setText();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void setText(){
        playerList = binding.getRoot().findViewById(R.id.rv);
        playerList.hasFixedSize();
        playerList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        repo.getPlayers().observe(getViewLifecycleOwner(), player -> {
            RecAdapter b = new RecAdapter(player);
            playerList.setAdapter(b);

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