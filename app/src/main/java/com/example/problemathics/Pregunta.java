package com.example.problemathics;

import java.util.List;

public class Pregunta {
    private int id;
    private String pregunta;
    private List<Resposta> respostes;
    private String imatge;
    private String categoria;
    private String dificultat;
    private String UF;

    // Constructor, getters y setters

    public int getId() {
        return id;
    }

    public String getDificultat() {
        return dificultat;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setDificultat(String dificultat) {
        this.dificultat = dificultat;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getImatge() {
        return imatge;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public List<Resposta> getRespostes() {
        return respostes;
    }

    public void setRespostes(List<Resposta> respostes) {
        this.respostes = respostes;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Puedes agregar métodos adicionales según tus necesidades
}
