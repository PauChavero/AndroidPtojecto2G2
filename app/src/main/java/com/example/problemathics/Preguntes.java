package com.example.problemathics;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Preguntes implements Serializable {


    @SerializedName("titol")
    private String titol;

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }


    @SerializedName("OpCioA")
    private String OpcioA;

    public String getOpcioA() {
        return OpcioA;
    }

    public void setOpcioA(String opcioA) {
        OpcioA = opcioA;
    }


    @SerializedName("OpCioB")
    private String OpcioB;

    public String getOpcioB() {
        return OpcioB;
    }

    public void setOpcioB(String opcioB) {
        OpcioB = opcioB;
    }


    @SerializedName("OpCioC")
    private String OpcioC;

    public String getOpcioC() {
        return OpcioC;
    }

    public void setOpcioC(String opcioC) {
        OpcioC = opcioC;
    }


    @SerializedName("OpCioD")
    private String OpcioD;

    public String getOpcioD() {
        return OpcioD;
    }

    public void setOpcioD(String opcioD) {
        OpcioD = opcioD;
    }
}
