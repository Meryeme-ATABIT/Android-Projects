package com.example.tp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;

import com.example.tp.db.pokemonId;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static com.example.tp.ui.main.PlaceholderFragment.Extra_ID;

public class DetailsActivity extends AppCompatActivity implements pokemonId {
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent=getIntent();
        id=intent.getIntExtra(Extra_ID, 0);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        //        R.id.navigation_description, R.id.navigation_evolutions)
        //        .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        navController.setGraph(R.navigation.mobile_navigation);
        //navController.navigate(R.id.action_mainActivity_to_navigation_description, bundle);

        setTitle(Html.fromHtml("Pokédex <div style='float: right;'> #"+id+"</div>"));

        NavigationUI.setupActionBarWithNavController(this, navController);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public int getCurrentPokemonId() {
        return id;
    }

}