package com.example.problemathics;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsuarisApi {

    @GET("/getUsuaris")
    Call<Usuaris> usuaris();
}
