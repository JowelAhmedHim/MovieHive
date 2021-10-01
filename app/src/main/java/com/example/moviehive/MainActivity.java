package com.example.moviehive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.moviehive.Service.Model.Result;
import com.example.moviehive.View.Adapter.TopRatedMovieAdapter;
import com.example.moviehive.ViewModel.MovieLIstViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieLIstViewModel mViewModel;
    private TopRatedMovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(linearLayoutManager);

        mViewModel = new ViewModelProvider(this).get(MovieLIstViewModel.class);
        mViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                adapter = new TopRatedMovieAdapter(MainActivity.this,results);
                recyclerView.setAdapter(adapter);


            }
        });

    }
}