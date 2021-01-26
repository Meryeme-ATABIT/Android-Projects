package com.example.tp.Service;

import com.example.tp.Model.Pokemon;
import com.example.tp.Model.PokemonList;
import com.example.tp.Model.PokemonProperty;
import com.example.tp.Model.PokemonSpecies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonService {
    public static final String ENDPOINT = "https://pokeapi.co/";

    @GET("/api/v2/pokemon/?offset=0&limit=880")
    Call<PokemonList> getPokemons();

    @GET("/api/v2/pokemon-species/{id}")
    Call<PokemonSpecies> getSpecies(
            @Path("id") String id
    );

    @GET("/api/v2/pokemon/{id}")
    Call<PokemonProperty> getProperties(
            @Path("id") String id
    );

}
