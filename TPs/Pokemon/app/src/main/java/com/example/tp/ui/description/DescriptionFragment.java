package com.example.tp.ui.description;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tp.Model.Pokemon;
import com.example.tp.Model.PokemonEvolutions;
import com.example.tp.Model.PokemonProperty;
import com.example.tp.Model.PokemonSpecies;
import com.example.tp.R;
import com.example.tp.Service.EvolusionService;
import com.example.tp.Service.PokemonService;
import com.example.tp.db.AppDatabase;
import com.example.tp.db.pokemonId;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Attr;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DescriptionFragment extends Fragment {

    private DescriptionViewModel descriptionViewModel;
    pokemonId mCallback;
    String evolutions = "";
    Pokemon pokemon;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        descriptionViewModel =
                new ViewModelProvider(this).get(DescriptionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_description, container, false);
        final TextView txtName = root.findViewById(R.id.name);
        final TextView txtDescription = root.findViewById(R.id.description);
        final TextView txtTaille = root.findViewById(R.id.taille);
        final TextView txtPoids = root.findViewById(R.id.poids);
        final TextView txtTypes = root.findViewById(R.id.types);
        final ImageView image = root.findViewById(R.id.image_view);


        mCallback = (pokemonId) getContext();
        int id = mCallback.getCurrentPokemonId();
        int color;

        pokemon = loadPokemon(id);
        if (pokemon.Evolutions == null)
            getEvolutions(id);

        if (pokemon.Type.contains("fire"))
            color = Color.rgb(215, 70, 17);
        else if (pokemon.Type.contains("water"))
            color = Color.rgb(19, 125, 215);
        else if (pokemon.Type.contains("grass"))
            color = Color.rgb(93, 215, 24);
        else
            color = Color.rgb(222, 188, 0);

        descriptionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Picasso.with(getContext()).load(pokemon.ImageURL).fit().centerInside().into(image);
                txtName.setText(pokemon.frName);
                txtDescription.setText(pokemon.Description);
                txtTaille.setText(Html.fromHtml("Taille: <b>" + pokemon.Height + " m</b>"));
                txtPoids.setText(Html.fromHtml("Poids: <b>" + pokemon.Weight + " Kg</b>"));
                txtTypes.setText(Html.fromHtml("Types: <b>" + pokemon.Type + "</b>"));
                image.setBackgroundColor(color);

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

    void getEvolutions(int id) {
        //Declare rotrofit components
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(EvolusionService.ENDPOINT)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        EvolusionService evolusionService = retrofit.create(EvolusionService.class);
        //Get Pokemon generation

        Call<List<PokemonEvolutions>> callEvolutions =
                evolusionService.getEvolutions(String.valueOf(id));

        // Execute the call asynchronously. Get a positive or negative callback.
        callEvolutions.enqueue(new Callback<List<PokemonEvolutions>>() {
            @Override
            public void onResponse(Call<List<PokemonEvolutions>> call, Response<List<PokemonEvolutions>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                if (response.body() != null) {
                    InsertData(response.body().get(0).getEvolutions());
                } else
                    ERROR("NULL" + response.message());
            }

            @Override
            public void onFailure(Call<List<PokemonEvolutions>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
                ERROR(t.getMessage());
            }
        });
    }

    public void InsertData(List<String> evList) {
        AppDatabase db = AppDatabase.getInstance(getContext());
        for (String e : evList) {
            evolutions += e + "/";
        }
        pokemon.Evolutions = evolutions;
        db.pokemonDau().updatePokemon(pokemon);
    }

    public void ERROR(String msg) {
        Log.e("ERROR", msg);
    }
}