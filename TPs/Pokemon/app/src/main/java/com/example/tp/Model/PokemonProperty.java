package com.example.tp.Model;

import java.util.ArrayList;
import java.util.List;

public class PokemonProperty {
    private String height;
    ArrayList<ParentType> types = new ArrayList<ParentType>();
    private String weight;


    // Getter Methods

    //return height of pokemon
    public String getHeight() {
        return height;
    }

    //return weight of pokemon
    public String getWeight() {
        return weight;
    }

    //return types of pokemon
    public String getTypes() {
        String t = "";
        for (ParentType type : types) {
            t += " - " + type.getType().getName();
        }
        return t;
    }
}

class ParentType {
    private Type type;

    public Type getType() {
        return type;
    }
}

class Type {
    private String name;

    public String getName() {
        return name;
    }
}