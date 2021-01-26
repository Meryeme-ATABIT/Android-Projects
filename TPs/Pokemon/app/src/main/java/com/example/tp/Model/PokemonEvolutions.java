package com.example.tp.Model;

import java.util.ArrayList;
import java.util.List;

public class PokemonEvolutions {
    Family family;

    public ArrayList<String> getEvolutions(){
        return family.evolutionLine;
    }
}


class Family {
    private float id;
    private float evolutionStage;
    ArrayList<String> evolutionLine = new ArrayList<String>();
}