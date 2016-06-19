package com.recycler.sachin.retrofit_proj.view;

import com.recycler.sachin.retrofit_proj.model.StackOverflowQuestions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SACHIN on 19-Jun-16.
 */
public interface StackOverflowAPI {


    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags);
}
