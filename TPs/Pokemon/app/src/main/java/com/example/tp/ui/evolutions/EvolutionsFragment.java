package com.example.tp.ui.evolutions;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp.Adapter.PokemonAdapter;
import com.example.tp.DetailsActivity;
import com.example.tp.Model.Pokemon;
import com.example.tp.R;
import com.example.tp.db.AppDatabase;
import com.example.tp.db.pokemonId;
import com.example.tp.ui.main.PlaceholderFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.tp.ui.main.PlaceholderFragment.Extra_ID;

public class EvolutionsFragment extends Fragment {

    private EvolutionsViewModel dashboardViewModel;
    private Pokemon pokemon;

    pokemonId mCallback;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(EvolutionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_evolutions, container, false);
        final ImageView image = root.findViewById(R.id.image_view);
        final ImageView image1 = root.findViewById(R.id.image1);
        final ImageView image2 = root.findViewById(R.id.image2);
        final TextView txtName = root.findViewById(R.id.name);


        mCallback = (pokemonId) getContext();
        int id = mCallback.getCurrentPokemonId();
        int color;

        pokemon = loadPokemon(id);

        if (pokemon.Type.contains("fire"))
            color = Color.rgb(215, 70, 17);
        else if (pokemon.Type.contains("water"))
            color = Color.rgb(19, 125, 215);
        else if (pokemon.Type.contains("grass"))
            color = Color.rgb(93, 215, 24);
        else
            color = Color.rgb(222, 188, 0);


        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Picasso.with(getContext()).load(pokemon.ImageURL).fit().centerInside().into(image);
                image.setBackgroundColor(color);
                txtName.setText(pokemon.frName);


                try {
                    List<String> evList = Arrays.asList(pokemon.Evolutions.toLowerCase().split("/"));
                    evList.removeIf(n ->(n==pokemon.name));

                    Pokemon p1=loadPokemonByName(evList.get(0));
                    Pokemon p2=loadPokemonByName(evList.get(1));
                    Picasso.with(getContext()).load(p1.ImageURL).fit().centerInside().into(image1);
                    Picasso.with(getContext()).load(p2.ImageURL).fit().centerInside().into(image2);


                } catch (Exception e) {
                    Log.e("ERROR", e.getMessage());
                }

                //getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(color));
                getActivity().findViewById(R.id.nav_view).setBackgroundColor(color);
            }
        });
        return root;
    }

    public Pokemon loadPokemon(int id) {
        AppDatabase db = AppDatabase.getInstance(getContext());
        Pokemon pokemon = db.pokemonDau().getPokemon(id);
        Log.d("success get pokemon ", String.valueOf(id));
        return pokemon;
    }

    public Pokemon loadPokemonByName(String name) {
        AppDatabase db = AppDatabase.getInstance(getContext());
        Pokemon pokemon = db.pokemonDau().getPokemonByName(name);
        Log.d("success get pokemon ", name);
        return pokemon;
    }

}