package com.example.showcaseapp.ui.SciFiNameGen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.showcaseapp.databinding.FragmentScifinamegenBinding;

public class SciFiNameGenFragment extends Fragment {

    private FragmentScifinamegenBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SciFiNameGenViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SciFiNameGenViewModel.class);

        binding = FragmentScifinamegenBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.generateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!binding.FirstTXT.getText().toString().isEmpty() && !binding.LastTXT.getText().toString().isEmpty() && !binding.CityTXT.getText().toString().isEmpty() && !binding.SchoolTXT.getText().toString().isEmpty() && !binding.FoodTXT.getText().toString().isEmpty() && !binding.CharTXT.getText().toString().isEmpty()){
                    if(binding.FirstTXT.getText().toString().length()>1 && binding.LastTXT.getText().toString().length()>2 && binding.CityTXT.getText().toString().length()>1 && binding.SchoolTXT.getText().toString().length()>2){
                        String sciFiFirst = binding.FirstTXT.getText().toString().substring(0,2)+binding.LastTXT.getText().toString().substring(0,3);
                        String sciFiLast = binding.CityTXT.getText().toString().substring(0,2)+binding.SchoolTXT.getText().toString().substring(0,3);
                        String sciFiPlanet = binding.FoodTXT.getText().toString()+" "+binding.CharTXT.getText().toString();

                        binding.generatedTXT.setText(String.format("%s %s from the planet %s",sciFiFirst,sciFiLast,sciFiPlanet));

                        binding.FirstTXT.setText("");
                        binding.LastTXT.setText("");
                        binding.CityTXT.setText("");
                        binding.SchoolTXT.setText("");
                        binding.FoodTXT.setText("");
                        binding.CharTXT.setText("");
                    }
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}