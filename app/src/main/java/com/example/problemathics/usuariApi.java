package com.example.problemathics;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface usuariApi {
    @GET("/usuariActual")
    Call<Usuari> usuariActual(@Query("usuari") String usuari);
}
