package com.example.tp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tp.Model.Pokemon;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PokemonDau pokemonDau();

    public static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DB_Pokemon")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
