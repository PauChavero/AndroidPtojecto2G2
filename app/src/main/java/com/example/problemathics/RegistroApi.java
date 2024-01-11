package com.example.problemathics;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegistroApi {
    @POST("/addUsuariAndroid")
    Call<RespuestaAutenticacion> autenticarRegistrto(@Body  RegistroEnviar registroEnviar);

}
