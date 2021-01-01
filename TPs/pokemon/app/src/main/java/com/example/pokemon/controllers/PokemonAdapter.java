package com.example.pokemon.controllers;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import com.example.pokemon.models.Pokemon;
import com.example.pokemon.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;



import static androidx.recyclerview.widget.RecyclerView.Adapter;

public class PokemonAdapter extends Adapter<PokemonAdapter.ViewHolder> {

    private final List<Pokemon> pokemons;

    public PokemonAdapter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View pokemonView = inflater.inflate(R.layout.pokemon_item, parent, false);
        return new ViewHolder(pokemonView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        ImageButton pokemonAvatar = holder.pokemonAvatar;
    }
    @Override
    public int getItemCount() {
        return this.pokemons.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageButton pokemonAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonAvatar = itemView.findViewById(R.id.item_pokemon_avatar);
        }
    }
}