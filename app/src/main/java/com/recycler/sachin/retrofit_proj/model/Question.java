package com.recycler.sachin.retrofit_proj.model;

/**
 * Created by SACHIN on 19-Jun-16.
 */
// This is used to map the JSON keys to the object by GSON
public class Question {

    public String title;
    String link;

    @Override
    public String toString() {
        return(title);
    }
}
