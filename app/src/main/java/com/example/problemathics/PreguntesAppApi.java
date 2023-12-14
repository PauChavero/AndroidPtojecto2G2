package com.example.problemathics;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PreguntesAppApi {
    @GET("/getPreguntes")
    Call<Preguntes> getPreguntes();
}

