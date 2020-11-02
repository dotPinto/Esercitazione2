package com.example.esercitazione2;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nome, cognome, dataDiNascita, indirizzo;

    public Persona(){
        this.nome="";
        this.cognome="";
        this.dataDiNascita="";
        this.indirizzo="";
    }

    public Persona(String nome, String cognome, String dataDiNascita, String indirizzo){
        this.nome=nome;
        this.cognome=cognome;
        this.dataDiNascita=dataDiNascita;
        this.indirizzo=indirizzo;
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

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
