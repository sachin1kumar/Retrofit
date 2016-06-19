package com.recycler.sachin.retrofit_proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import com.recycler.sachin.retrofit_proj.model.Question;
import com.recycler.sachin.retrofit_proj.model.StackOverflowQuestions;
import com.recycler.sachin.retrofit_proj.view.StackOverflowAPI;
import retrofit2.Call;
import retrofit2.Callback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*URL followed :
* http://www.vogella.com/tutorials/Retrofit/article.html
* https://www.learn2crack.com/2016/02/recyclerview-json-parsing.html
* https://instructure.github.io/blog/2013/12/09/volley-vs-retrofit/
* */

public class MainActivity extends AppCompatActivity  {

    RecyclerView recyclerView;
    private  ArrayList<Question> data;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData();

    }

    public void  fetchData(){

        //Creating a rest adapter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        StackOverflowAPI stackOverflowAPI = retrofit.create(StackOverflowAPI.class);

        Call<StackOverflowQuestions> call = stackOverflowAPI.loadQuestions("android");
        //asynchronous call
        call.enqueue(new Callback<StackOverflowQuestions>() {
            @Override
            public void onResponse(Call<StackOverflowQuestions> call, Response<StackOverflowQuestions> response) {

                setProgressBarIndeterminateVisibility(true);
                data = new ArrayList<>(response.body().items);
                adapter = new Adapter(data);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<StackOverflowQuestions> call, Throwable t) {

            }
        });

    }



}
