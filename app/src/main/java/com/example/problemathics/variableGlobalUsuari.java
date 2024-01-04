package com.example.problemathics;

import android.app.Application;

public class variableGlobalUsuari extends Application {
    private Usuari usuari;

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
}
