package com.example.pokemon.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pokemon.R;
import com.example.pokemon.controllers.PokemonAdapter;
import com.example.pokemon.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class GenerationsActivity extends AppCompatActivity {

    List<Pokemon> pokemons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generations);

        // Get the Recycle View
        RecyclerView rvGenerations = findViewById(R.id.RvGenerations);

        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));
        pokemons.add(new Pokemon(1, "Test", "url_avatar"));

        // Create adapter for the recycle view
        PokemonAdapter adapter = new PokemonAdapter(pokemons);
        // Set Adapter
        rvGenerations.setAdapter(adapter);
        // Set GridLayout as a manager
        rvGenerations.setLayoutManager(new GridLayoutManager(this, 3));
    }
}