package com.example.moviehive.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.moviehive.Service.Model.MovieModel;
import com.example.moviehive.Service.Model.Result;
import com.example.moviehive.Service.Network.ApiServices;
import com.example.moviehive.Service.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private Context context;
    private MovieModel movieModel;
    private List<Result> mResult;
    private MutableLiveData mLiveData;
    public static  MovieRepository instance;


    public static MovieRepository getInstance(Context context)
    {
       if (instance == null){
           context = context;
           instance = new MovieRepository();
       }
       return instance;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieLIst(){

        if (mLiveData==null){
            mLiveData = new MutableLiveData();
        }

        ApiServices apiServices = RetrofitInstance.getRetroInstance().create(ApiServices.class);
        Call<MovieModel> call =  apiServices.getTopRatedMovieList();

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel = response.body();
                mResult = movieModel.getResults();

                mLiveData.postValue(mResult);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
        return mLiveData;
    }


}
