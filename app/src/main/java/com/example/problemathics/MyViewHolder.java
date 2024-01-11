package com.example.problemathics;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{

    TextView usuariView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        usuariView = itemView.findViewById(R.id.usuariRanquing);
    }
}
