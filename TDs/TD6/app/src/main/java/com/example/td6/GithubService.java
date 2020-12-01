package com.example.td6;

import retrofit2.Call;

import java.util.List;

import retrofit2.http.*;


public interface GithubService {
    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Call <List<Repo>> listRepos(@Path("user") String user);

    @GET("/search/repositories")
    List<Repo> searchRepos(@Query("q") String query);
}
