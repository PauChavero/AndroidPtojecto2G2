package com.example.problemathics;

public class Usuari {

    private String email;
    private String nomUsuari;
    private int puntuacioSingle;
    private int eloMulti;
    private int partidesGuanyades;
    private int partidesPerdudes;

    // Constructor
    public Usuari(String usuari, String email, int puntuacioSingle, int eloMulti, int partidesGuanyades, int partidesPerdudes) {
        this.nomUsuari = usuari;
        this.email = email;
        this.puntuacioSingle = puntuacioSingle;
        this.eloMulti = eloMulti;
        this.partidesGuanyades = partidesGuanyades;
        this.partidesPerdudes = partidesPerdudes;
    }

    // Setters y getters para cada atributo
    public String getUsuari() {
        return nomUsuari;
    }

    public void setUsuari(String usuari) {
        this.nomUsuari = usuari;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRanquing() {
        String resultat = this.nomUsuari+"  "+this.eloMulti+"  Guanyades: "+this.partidesGuanyades+"  Perdudes: "+this.partidesPerdudes;
        return resultat;
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
}


