package com.example.sunny_appen.ui.Player;

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
import com.example.sunny_appen.databinding.FragmentPlayerBinding;
import com.example.sunny_appen.recycler.RecAdapter;

public class PlayerFragment extends Fragment {

    private FragmentPlayerBinding binding;
    private Repo repo;
    private TextView header;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PlayerViewModel ViewModel =
                new ViewModelProvider(this).get(PlayerViewModel.class);

        binding = FragmentPlayerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        repo = Repo.getInstance();


        setText();

        return root;
    }

    private void setText(){
        header = binding.textHeaderName;

        repo.getSelectedPlayer().observe(getViewLifecycleOwner(), p ->{
            header.setText(p.getNavn());



        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}