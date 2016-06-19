package com.recycler.sachin.retrofit_proj;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.recycler.sachin.retrofit_proj.model.Question;
import java.util.Collections;
import java.util.List;

/**
 * Created by SACHIN on 18-Jun-16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private LayoutInflater inflater;
    private List<Question> data= Collections.emptyList();

    public Adapter(List<Question> data){

        this.data = data;

    }


    @Override
    public  Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list,parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Question myData = data.get(position);
        holder.textView1.setText(myData.title);

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView1,textView2,textView3,textView4;

        public MyViewHolder(View itemView) {

            super(itemView);

            textView1 = (TextView) itemView.findViewById(R.id.login);

        }
    }
}
