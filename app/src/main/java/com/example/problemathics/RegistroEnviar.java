package com.example.problemathics;

public class RegistroEnviar {

    private String nomUsuari;
    private String email;
    private String contrasenya;
    private int puntuacioSingle;
    private int eloMulti;
    private int partidesGuanyades;
    private int partidesPerdudes;
    private Boolean admin;

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getPuntuacioSingle() {
        return puntuacioSingle;
    }

    public void setPuntuacioSingle(int puntuacioSingle) {
        this.puntuacioSingle = puntuacioSingle;
    }

    public int getEloMulti() {
        return eloMulti;
    }

    public void setEloMulti(int eloMulti) {
        this.eloMulti = eloMulti;
    }

    public int getPartidesGuanyades() {
        return partidesGuanyades;
    }

    public void setPartidesGuanyades(int partidesGuanyades) {
        this.partidesGuanyades = partidesGuanyades;
    }

    public int getPartidesPerdudes() {
        return partidesPerdudes;
    }

    public void setPartidesPerdudes(int partidesPerdudes) {
        this.partidesPerdudes = partidesPerdudes;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public RegistroEnviar(String nomUsuari, String email, String contrasenya, int puntuacioSingle, int eloMulti, int partidesGuanyades, int partidesPerdudes, Boolean admin) {
        this.nomUsuari = nomUsuari;
        this.email = email;
        this.contrasenya = contrasenya;
        this.puntuacioSingle = puntuacioSingle;
        this.eloMulti = eloMulti;
        this.partidesGuanyades = partidesGuanyades;
        this.partidesPerdudes = partidesPerdudes;
        this.admin = admin;
    }






}
