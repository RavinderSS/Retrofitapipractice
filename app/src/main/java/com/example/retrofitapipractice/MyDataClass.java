package com.example.retrofitapipractice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MyDataClass {

    String baseUrl="https://jsonplaceholder.typicode.com/";
    ViewInterface viewInt;
    MyDataClass(ViewInterface viewInterface){
        viewInt=viewInterface;
    }
    public void readDataFromServer(){
        //start retrofit
        Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build();
        Call<ArrayList<Posts>> request=retrofit.create(RetrofitInterface.class).getDataOfComments();
        request.enqueue(new Callback<ArrayList<Posts>>() {
            @Override
            public void onResponse(Call<ArrayList<Posts>> call, Response<ArrayList<Posts>> response) {
                //data
                viewInt.loadData(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Posts>> call, Throwable t) {

            }
        });
    }
interface RetrofitInterface{
        @GET("posts")
        Call<ArrayList<Posts>> getDataOfComments();
}
}
