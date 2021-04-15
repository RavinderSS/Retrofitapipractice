package com.example.retrofitapipractice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofitinterface {

    @GET("3/movie/upcoming?api_key=da46474f8dd8ea1caebd07b84cb98b86&language=en-US&page=1")
    Call<AllMovies> fetchPopularMovies();
}