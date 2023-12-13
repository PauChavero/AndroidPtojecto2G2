package com.example.problemathics;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("login")
    Call<RespuestaAutenticacion> autenticarUsuario(@Body DatosEnviar datosEnviar);
}
