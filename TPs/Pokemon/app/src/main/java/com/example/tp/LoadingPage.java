package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.tp.Model.Pokemon;
import com.example.tp.Model.PokemonEvolutions;
import com.example.tp.Model.PokemonList;
import com.example.tp.Model.PokemonProperty;
import com.example.tp.Model.PokemonSpecies;
import com.example.tp.Service.EvolusionService;
import com.example.tp.Service.PokemonService;
import com.example.tp.db.AppDatabase;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoadingPage extends AppCompatActivity {

    private List<Pokemon> pokemonsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);


        if (loadPokemons() < 880) {

            //Declare rotrofit components
            setContentView(R.layout.activity_loading_page);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder =
                    new Retrofit.Builder()
                            .baseUrl(PokemonService.ENDPOINT)
                            .addConverterFactory(
                                    GsonConverterFactory.create()
                            );

            Retrofit retrofit =
                    builder
                            .client(
                                    httpClient.build()
                            )
                            .build();

            PokemonService pokemonService = retrofit.create(PokemonService.class);

            //Get Pokemons list
            Call<PokemonList> callPokemon =
                    pokemonService.getPokemons();

            // Execute the call asynchronously. Get a positive or negative callback.
            callPokemon.enqueue(new Callback<PokemonList>() {
                @Override
                public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                    // The network call was a success and we got a response
                    // TODO: use the repository list and display it
                    if (response.body() != null) {

                        //do long running blocking bg stuff here
                        new Thread() {
                            @Override
                            public void run() {
                                pokemonsList = response.body().getPokemonList();
                                getSpecie();
                                getProperties();
                                StartApp();
                            }
                        }.start();

                    } else
                        ERROR("NULL" + response.message());
                }

                @Override
                public void onFailure(Call<PokemonList> call, Throwable t) {
                    // the network call was a failure
                    // TODO: handle error
                    ERROR(t.getMessage());
                }
            });
            //End get
        } else
            (new Handler()).postDelayed(this::StartApp, 5000);

        //StartApp();

    }

    void getSpecie() {
        //Declare rotrofit components
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(PokemonService.ENDPOINT)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        PokemonService pokemonService = retrofit.create(PokemonService.class);

        //Get Pokemon generation
        for (Pokemon pokemon : pokemonsList) {
            int l = pokemon.url.split("/").length;
            pokemon.Id = Integer.valueOf(pokemon.url.split("/")[l - 1]);
            Call<PokemonSpecies> callSpecie =
                    pokemonService.getSpecies(String.valueOf(pokemon.Id));


            // Execute the call asynchronously. Get a positive or negative callback.
            callSpecie.enqueue(new Callback<PokemonSpecies>() {
                @Override
                public void onResponse(Call<PokemonSpecies> call, Response<PokemonSpecies> response) {
                    // The network call was a success and we got a response
                    // TODO: use the repository list and display it
                    if (response.body() != null) {
                        pokemon.Generation = response.body().getGeneration();
                        pokemon.frName= response.body().getName();
                        pokemon.Description= response.body().getDescription();
                    } else
                        ERROR("NULL" + response.message());
                }

                @Override
                public void onFailure(Call<PokemonSpecies> call, Throwable t) {
                    // the network call was a failure
                    // TODO: handle error
                    ERROR(t.getMessage());
                }
            });
        }
    }

    void getProperties() {
        //Declare rotrofit components
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(PokemonService.ENDPOINT)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        PokemonService pokemonService = retrofit.create(PokemonService.class);

        //Get Pokemon generation
        for (Pokemon pokemon : pokemonsList) {
            int l = pokemon.url.split("/").length;
            pokemon.Id = Integer.valueOf(pokemon.url.split("/")[l - 1]);
            Call<PokemonProperty> callSpecie =
                    pokemonService.getProperties(String.valueOf(pokemon.Id));

            try {
                Response<PokemonProperty> response= callSpecie.execute();
                pokemon.Height = response.body().getHeight();
                pokemon.Weight= response.body().getWeight();
                pokemon.Type= response.body().getTypes();
                InsertData(pokemon);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void InsertData(Pokemon p) {
        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());

        p.ImageURL = "https://pokeres.bastionbot.org/images/pokemon/" + String.valueOf(p.Id) + ".png";
        db.pokemonDau().insertPokemon(p);
    }

    public int loadPokemons() {
        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        List<Pokemon> pokemons = db.pokemonDau().getAllPokemons();
        Log.d("success", String.valueOf(pokemons.size()));
        return pokemons.size();
    }

    public void ERROR(String msg) {
        Toast.makeText(this, "Message : " + msg, Toast.LENGTH_SHORT).show();
        Log.e("ERROR", msg);
    }

    void StartApp() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}