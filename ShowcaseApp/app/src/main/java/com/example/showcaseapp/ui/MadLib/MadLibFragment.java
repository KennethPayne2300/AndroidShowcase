package com.example.showcaseapp.ui.MadLib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.showcaseapp.databinding.FragmentMadlibBinding;

import java.util.Random;

public class MadLibFragment extends Fragment {

    private FragmentMadlibBinding binding;

    private int story;
    private final Random randy = new Random();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MadLibViewModel madLibViewModel =
                new ViewModelProvider(this).get(MadLibViewModel.class);

        binding = FragmentMadlibBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.storyLayout.setVisibility(View.GONE);
                binding.chooseStoryLayout.setVisibility(View.VISIBLE);
            }
        });

        binding.story1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when story1 button is clicked switch to the input page and make the story variable 1 to switch to that story
                binding.chooseStoryLayout.setVisibility(View.GONE);
                binding.InputPage.setVisibility(View.VISIBLE);
                story = 1;
            }
        });
        binding.story2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when story1 button is clicked switch to the input page and make the story variable 2 to switch to that story
                binding.chooseStoryLayout.setVisibility(View.GONE);
                binding.InputPage.setVisibility(View.VISIBLE);
                story = 2;
            }
        });
        binding.story3BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when story3 button is clicked switch to the input page and make the story variable 3 to switch to that story
                binding.chooseStoryLayout.setVisibility(View.GONE);
                binding.InputPage.setVisibility(View.VISIBLE);
                story = 3;
            }
        });
        binding.randomizeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when randomize button is clicked switch to the input page and make the story variable a random number between 1 and 3 (4 because bound is exclusive) to randomize the story
                binding.chooseStoryLayout.setVisibility(View.GONE);
                binding.InputPage.setVisibility(View.VISIBLE);
                story = randy.nextInt(1,4);
            }
        });



        binding.GenerateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personsName, place, pluralAnimal, pastVerb, adjective, noun, number, sillyWord;

                //editText.getText().toString();
                //.getText - gets the text
                //.toString - makes the text a string
                personsName = binding.personsNameTXT.getText().toString();
                place = binding.placeTXT.getText().toString();
                pluralAnimal = binding.pluralAnimalTXT.getText().toString();
                pastVerb = binding.pastVerbTXT.getText().toString();
                adjective = binding.adjectiveTXT.getText().toString();
                noun = binding.nounTXT.getText().toString();
                number = binding.numberTXT.getText().toString();
                sillyWord = binding.sillyWordTXT.getText().toString();

                //remove the inputs from the EditTexts
                binding.personsNameTXT.setText("");
                binding.placeTXT.setText("");
                binding.pluralAnimalTXT.setText("");
                binding.pastVerbTXT.setText("");
                binding.adjectiveTXT.setText("");
                binding.nounTXT.setText("");
                binding.numberTXT.setText("");
                binding.sillyWordTXT.setText("");

                //Makes the linear layout of the input page gone and makes the story layout visible to give the illusion of a different activity
                binding.InputPage.setVisibility(View.GONE);
                binding.storyLayout.setVisibility(View.VISIBLE);

                //Got the story from chatgpt
                //it's all in the same layout, but the text is changed based on the story.
                if (story == 1) {
                    binding.Story.setText(String.format("One day, %s was visiting the royal zoo in %s when suddenly a group of %s %s out of their enclosure!\n\nIt was a(n) %s disaster. They knocked over a %s, scared %s tourists, and someone even yelled, \"%s!\" before fainting.", personsName, place, pluralAnimal, pastVerb, adjective, noun, number, sillyWord));
                } else if(story==2){
                    binding.Story.setText(String.format("Captain %s landed their spaceship near %s, expecting peace. Instead, they were greeted by alien %s who %s toward the ship.\n\nThese creatures looked %s and smelled like %s. After meeting %s of them, the captain sent out a distress signal: \"%s!\"",personsName, place, pluralAnimal, pastVerb, adjective, noun, number, sillyWord));
                } else if(story==3){
                    binding.Story.setText(String.format("%s shocked everyone, at %s high during the talent show, by performing a duet with trained %s.\n\nThe animals %s in sync to the beat while wearing %s costumes made of %s. The audience gave %s standing ovations and chanted, \"%s!\" all night long.", personsName, place, pluralAnimal, pastVerb, adjective, noun, number, sillyWord));
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