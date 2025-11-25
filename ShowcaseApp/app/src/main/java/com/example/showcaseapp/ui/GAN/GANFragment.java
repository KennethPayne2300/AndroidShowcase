package com.example.showcaseapp.ui.GAN;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        int attempts=10;
        int secretNumber = (int) (Math.random()*100)+1;

        binding.GuessBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView guess = binding.GuessTXT;

                try{
                    int numberGuess = Integer.parseInt(guess.getText().toString());

                    if(numberGuess<=100 || numberGuess>0){
                        if(numberGuess==secretNumber){
                            attempts=10;
                            binding.FeedbackTXT.setText("You Got It!!!");
                        }else if(numberGuess>secretNumber){
                            attempts--;
                            binding.FeedbackTXT.setText("Too High");
                        }else{
                            attempts--;
                            binding.FeedbackTXT.setText("Too Low");
                        }
                        binding.attemptsTXT.setText(attempts);
                    }else{
                        Toast.makeText(getContext(),"needs to be between 1 and 100",Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e){
                    Toast.makeText(getContext(), "Need a number, and can't be a decimal either", Toast.LENGTH_SHORT).show();
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

    public void addNamesToLeaderBoard(String name, int score){

    }
}