package com.example.retrofitapipractice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataModal {
    String baseUrl="https://api.themoviedb.org/";
    public void getUpComingMovies(ViewInterface viewInterface)
    {
        Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build();
        Call<AllMovies> dataResponse=retrofit.create(Retrofitinterface.class).fetchPopularMovies();
        dataResponse.enqueue(new Callback<AllMovies>() {
            @Override
            public void onResponse(Call<AllMovies> call, Response<AllMovies> response) {
                viewInterface.loadData(response.body());
            }

            @Override
            public void onFailure(Call<AllMovies> call, Throwable t) {
                    System.out.println(">>>>>>>"+t.getLocalizedMessage());
            }
        });
    }
}
