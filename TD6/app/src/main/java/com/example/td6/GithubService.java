package com.example.td6;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("/search/repositories")
    Call<Repos> searchRepos(@Query("q") String query);
}
