package com.example.moviehive.Service.Network;

import com.example.moviehive.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices{

    @GET("3/movie/top_rated?api_key=9a637ddda10566dde671f1bc67d1936c")
    Call<MovieModel> getTopRatedMovieList();
}
