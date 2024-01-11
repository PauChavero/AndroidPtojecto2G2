package com.example.problemathics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Usuari> usuaris;

    public MyAdapter(Context context, List<Usuari> usuaris) {
        this.context = context;
        this.usuaris = usuaris;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.usuari_ranquing_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.usuariView.setText(usuaris.get(position).getRanquing());
    }

    @Override
    public int getItemCount() {
        return usuaris.size();
    }
}
