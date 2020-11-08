package com.example.esercitazione2;

import java.io.Serializable;
import java.util.Calendar;

public class Persona implements Serializable {

    private String nome, cognome, indirizzo;

    private Calendar dataDiNascita;

    private int eta;

    public Persona(){
        this.nome="";
        this.cognome="";
        this.indirizzo="";
        this.eta=0;
    }

    public Persona(String nome, String cognome, String dataDiNascita, String indirizzo,int eta){
        this.nome=nome;
        this.cognome=cognome;
        this.indirizzo=indirizzo;
        this.eta=eta;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
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
