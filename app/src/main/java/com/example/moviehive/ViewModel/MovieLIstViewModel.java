package com.example.moviehive.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.moviehive.Service.Model.Result;
import com.example.moviehive.Service.Repository.MovieRepository;

import java.util.List;

public class MovieLIstViewModel  extends AndroidViewModel {


    private MovieRepository mRepo;


    public MovieLIstViewModel(@NonNull Application application) {
        super(application);

        mRepo = MovieRepository.getInstance(application);
    }

    public LiveData<List<Result>> getTopRatedMovieList()
    {
        return mRepo.getTopRatedMovieLIst();
    }


}
