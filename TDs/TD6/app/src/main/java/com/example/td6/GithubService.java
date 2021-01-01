package com.example.td6;

import retrofit2.Call;

import java.util.List;

import retrofit2.http.*;


public interface GithubService {
    public static final String ENDPOINT = "https://api.github.com";

    // listRepos pour afficher la list d'un user passé en paramètre
    @GET("/users/{user}/repos") // cet url il s'ajoute à notre ENDPOINT
    Call <List<Repo>> listRepos(@Path("user") String user);

    // searchRepos pour rechercher des dépôts en fonction de mots clés passé en paramètre
    @GET("/search/repositories")
    List<Repo> searchRepos(@Query("q") String query);

    //@GET (Récupèration de l’info)
    //@POST (Création de l’info)
    //@PUT (Modification de l’info)
    //@DELETE (Suppression de l’info)


}
