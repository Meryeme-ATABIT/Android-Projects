package com.example.tp.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class PokemonSpecies {

    ArrayList<Flavor_text_entrie> flavor_text_entries = new ArrayList<Flavor_text_entrie>();

    Generation generation;
    private String name;
    ArrayList<Name> names = new ArrayList<Name>();
    ArrayList<Object> varieties = new ArrayList<Object>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getName() {
        Name name = names.stream()
                .filter(n -> "fr".equals(n.getLanguage().getName()))
                .findAny()
                .orElse(null);
        String s = name.getName();
        return s;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getDescription() {
        Flavor_text_entrie frFlavors = flavor_text_entries.stream()
                .filter(f -> "fr".equals(f.getLanguage().getName()))
                .findAny()
                .orElse(null);

        String description = frFlavors.getFlavor_text();
        return description;
    }

    public String getGeneration() {
        int l = generation.getUrl().split("/").length;
        return generation.getUrl().split("/")[l - 1];
    }
}

class Name {
    private Language language;
    private String name;

    public String getName() {
        return name;
    }

    public Language getLanguage() {
        return language;
    }
}

class Flavor_text_entrie {
    private String flavor_text;
    Language language;
    Version version;


    // Getter Methods

    public String getFlavor_text() {
        return flavor_text;
    }

    public Language getLanguage() {
        return language;
    }

    public Version getVersion() {
        return version;
    }
}

class Version {
    private String name;


    // Getter Methods

    public String getName() {
        return name;
    }
}

class Language {
    private String name;

    // Getter Methods

    public String getName() {
        return name;
    }
}

class Generation {
    private String name;
    private String url;

    public String getUrl() {
        return url;
    }
}