package br.edu.ifsp.agendasqlite.model;

import java.io.Serializable;

public class Contato implements Serializable {

    private int id;
    private String nome;
    private String fone_1;
    private String fone_2;
    private String email;
    private int favorito = 0;

    public Contato() {
    }

    public Contato(String nome, String fone_1, String fone_2, String email) {
        this.nome = nome;
        this.fone_1 = fone_1;
        this.fone_2 = fone_2;
        this.email = email;
    }


    public boolean equals(Object obj) {
        Contato c2 = (Contato) obj;
        if (this.id == c2.getId())
            return true;
        else
            return false;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone_1() {
        return fone_1;
    }

    public void setFone_1(String fone_1) {
        this.fone_1 = fone_1;
    }

    public String getFone_2() {
        return fone_2;
    }

    public void setFone_2(String fone_2) {
        this.fone_2 = fone_2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }
}
