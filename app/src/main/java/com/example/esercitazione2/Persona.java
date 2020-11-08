package com.example.esercitazione2;

import java.io.Serializable;
import java.util.Calendar;

public class Persona implements Serializable {

    private String nome, cognome, cap;

    private Calendar dataDiNascita;

    private int eta;

    public Persona(){
        this.nome="";
        this.cognome="";
        this.cap="";
        this.eta=0;
    }

    public Persona(String nome, String cognome, String dataDiNascita, String cap, int eta){
        this.nome=nome;
        this.cognome=cognome;
        this.cap = cap;
        this.eta=eta;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(Calendar dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Calendar getDataDiNascita() {
        return dataDiNascita;
    }

}
