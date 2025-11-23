package com.example.showcaseapp;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.showcaseapp.HobbyList.Hobby;
import com.example.showcaseapp.HobbyList.Hobbyadapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.showcaseapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView hobbyRecyclerView;
    private Hobbyadapter myAdapter;
    private ArrayList<Hobby> dataList;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_madlib, R.id.nav_scifinamegen,R.id.nav_gan)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        hobbyRecyclerView = findViewById(R.id.HobbiesList);
        dataList = new ArrayList<>();
        dataList.add(new Hobby("Playing Video Games","Video games I like to play include but not limited to: Scrap mechanic, roblox, and lego games"));
        dataList.add(new Hobby("3d modeling", "I have been using Fusion 360 to model somethings, mainly 1 thing at the moment but it's a hobby I'm interested in so I'm hoping to make stuff in the future"));
        dataList.add(new Hobby("3d Printing","similar to 3d modeling, but I've printed a couple of things that include a poorly modeled grogu (for my brother) a small skull (test print) and pieced for a 3d printed sword, I also 3d printed the 1 model I made for my sister and granny to sell"));
        dataList.add(new Hobby("watching shows","Some shows I like to watch are Ninjago, Murder drones, Hazbin hotel, sofia the first, and docter who."));
        dataList.add(new Hobby("playing outside", "I play outside like a little kid would but with plenty of swords over the years even a toy spear at one point, what can I say I'm a kid at heart"));

        myAdapter = new Hobbyadapter(dataList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}