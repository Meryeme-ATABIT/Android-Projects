package com.example.tp.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp.Adapter.PokemonAdapter;
import com.example.tp.DetailsActivity;
import com.example.tp.MainActivity;
import com.example.tp.Model.Pokemon;
import com.example.tp.R;
import com.example.tp.db.AppDatabase;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements PokemonAdapter.OnItemClickListener {
    public static final String Extra_ID = "id";

    private RecyclerView mRecyclerView;
    private PokemonAdapter mPokemonAdapter;
    private List<Pokemon> mPokemonList;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {
                mRecyclerView = root.findViewById(R.id.recycler_view);
                mRecyclerView.setHasFixedSize(true);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
                mRecyclerView.setLayoutManager(gridLayoutManager);

                try {
                    mPokemonList = loadPokemons(s);

                    mPokemonAdapter = new PokemonAdapter(getActivity(), mPokemonList);
                    mRecyclerView.setAdapter(mPokemonAdapter);
                    mPokemonAdapter.setOnItemClickListener(PlaceholderFragment.this);
                } catch (Exception e) {
                    Log.e("ERROR", e.getMessage());
                }

                TextView titre = getActivity().findViewById(R.id.titre);
                titre.setText("Pokémon");
/*
                if (s == "1")
                    titre.setText("1ére Génération de Pokémon");
                else
                    titre.setText(s + "éme Génération de Pokémon");
 */
            }
        });
        return root;
    }

    public List<Pokemon> loadPokemons(String generation) {
        AppDatabase db = AppDatabase.getInstance(getContext());
        List<Pokemon> pokemons = db.pokemonDau().getPokemonsImage(generation);
        Log.d("images success page(" + generation + ")", String.valueOf(pokemons.size()));
        return pokemons;
    }

    @Override
    public void onItemClick(int position) {
        Log.d("Click", "Details");
        Intent detailIntent = new Intent(getActivity(), DetailsActivity.class);
        Pokemon clickedPokemon = mPokemonList.get(position);

        detailIntent.putExtra(Extra_ID, clickedPokemon.Id);

        startActivity(detailIntent);
    }
}