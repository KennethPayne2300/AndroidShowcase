package com.example.showcaseapp.ui.GAN;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.showcaseapp.R;
import com.example.showcaseapp.databinding.FragmentGanBinding;

public class GANFragment extends Fragment {

    public int attempts=10;
    public int points=0;
    public int level=1;

    public int secretNumber = (int) (Math.random()*100)+1;

    private FragmentGanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GanViewModel GanViewModel =
                new ViewModelProvider(this).get(GanViewModel.class);

        binding = FragmentGanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.pointsTXT.setText("Points: 0");
        binding.levelTXT.setText("Level: 1");
        binding.attemptsTXT.setText("10");

        binding.GuessBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView guess = binding.GuessTXT;

                try{
                    int numberGuess = Integer.parseInt(guess.getText().toString());

                    if(numberGuess<=100 && numberGuess>0){
                        if(numberGuess==secretNumber){
                            points+=(50+(5*attempts));
                            level++;
                            binding.levelTXT.setText(String.format("Level: %d",level));
                            binding.pointsTXT.setText(String.format("Points: %d", points));
                            binding.FeedbackTXT.setText(String.format("You Got It!!! the number was: %d",secretNumber));
                            secretNumber = (int) (Math.random()*100)+1;
                            attempts=10;
                        }else if(numberGuess>secretNumber){
                            attempts--;
                            binding.FeedbackTXT.setText("Too High");
                        }else{
                            attempts--;
                            binding.FeedbackTXT.setText("Too Low");
                        }
                        binding.attemptsTXT.setText(String.format("%d", attempts));
                        binding.GuessTXT.setText("");
                        if(attempts<=0||level>5){
                            binding.GameOverLayout.setVisibility(View.VISIBLE);
                            binding.GameLayout.setVisibility(View.GONE);
                            if(level>5){
                                binding.GameOverTXT.setText("Game Over you Won!!!");
                                binding.gameOverImg.setImageResource(R.drawable.gan_win);
                            } else {
                                binding.GameOverTXT.setText("Game Over you Lost");
                                binding.gameOverImg.setImageResource(R.drawable.gan_lose);
                            }
                        }
                    }else{
                        Toast.makeText(getContext(),"needs to be between 1 and 100",Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e){
                    Toast.makeText(getContext(), "Need a round number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.NewGameBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempts=10;
                points=0;
                level=1;
                secretNumber = (int) (Math.random()*100)+1;
                binding.FeedbackTXT.setText("");
                binding.GuessTXT.setText("");
                binding.attemptsTXT.setText("10");
                binding.pointsTXT.setText("Points: 0");
                binding.levelTXT.setText("Level: 1");
                binding.GameOverLayout.setVisibility(View.GONE);
                binding.GameLayout.setVisibility(View.VISIBLE);
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