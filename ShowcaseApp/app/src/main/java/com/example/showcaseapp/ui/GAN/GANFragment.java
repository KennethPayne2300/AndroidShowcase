package com.example.showcaseapp.ui.GAN;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.showcaseapp.databinding.FragmentGanBinding;

public class GANFragment extends Fragment {

    private FragmentGanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GanViewModel GanViewModel =
                new ViewModelProvider(this).get(GanViewModel.class);

        binding = FragmentGanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGan;
        GanViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}