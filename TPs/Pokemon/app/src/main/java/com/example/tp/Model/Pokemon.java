package com.example.tp.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pokemon {

    @PrimaryKey
    @NonNull
    public int Id;

    @ColumnInfo(name = "ImageUrl")
    @Nullable
    public String ImageURL;

    @ColumnInfo(name = "Name")
    @Nullable
    public String name;

    @ColumnInfo(name = "frName")
    @Nullable
    public String frName;

    @ColumnInfo(name = "propertyURL")
    @Nullable
    public String url;

    @ColumnInfo(name = "generation")
    @Nullable
    public String Generation;

    @ColumnInfo(name = "descrition")
    @Nullable
    public String Description;

    @ColumnInfo(name = "height")
    @Nullable
    public String Height;

    @ColumnInfo(name = "weight")
    @Nullable
    public String Weight;

    @ColumnInfo(name = "type")
    @Nullable
    public String Type;

    @ColumnInfo(name = "evolutions")
    @Nullable
    public String Evolutions;

    public Pokemon(){
    }

/*
    public Pokemon(String id, String name, String url, String imageURL) {
        this.Id=id;
        this.name = name;
        this.url=url;
        this.ImageURL = imageURL;
    }
*/

}
