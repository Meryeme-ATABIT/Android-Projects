package com.example.tp.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tp.Model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PokemonDau {

    // Select all pokemon
    @Query("SELECT * FROM POKEMON ORDER BY Id")
    List<Pokemon> getAllPokemons();

    // Select pokemon by id
    @Query("SELECT * FROM POKEMON WHERE Id=:id")
    Pokemon getPokemon(int id);

    // Select pokemon by name
    @Query("SELECT Id, ImageUrl FROM POKEMON WHERE Name=:name")
    Pokemon getPokemonByName(String name);

    // Select pokemons by generation
    @Query("SELECT Id, ImageUrl FROM POKEMON WHERE generation=:generation ORDER BY Id")
    List<Pokemon> getPokemonsImage(String generation);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPokemon(Pokemon... pokemon);

    @Delete
    void delete(Pokemon pokemon);

    @Update()
    void updatePokemon(Pokemon... pokemon);

    @Query("DELETE FROM POKEMON")
    void deleteAll();

}

