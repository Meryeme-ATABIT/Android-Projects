package com.example.tp.Service;

import com.example.tp.Model.PokemonEvolutions;
import com.example.tp.Model.PokemonSpecies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EvolusionService {
    public static final String ENDPOINT = "https://pokeapi.glitch.me/";

    @GET("/v1/pokemon/{id}")
    Call<List<PokemonEvolutions>> getEvolutions(
            @Path("id") String id
    );
}
