package com.ezmed.dto;

public class Farmacia {

    private int id;
    private String nome;
    private String endereco;
    private boolean isFavorita;

    public Farmacia(int id, String nome, String endereco, boolean isFavorita) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.isFavorita = isFavorita;
    }

    public Farmacia(String nome, String endereco, boolean isFavorita) {
        this.nome = nome;
        this.endereco = endereco;
        this.isFavorita = isFavorita;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isFavorita() {
        return isFavorita;
    }

    public void setFavorita(boolean favorita) {
        isFavorita = favorita;
    }
}
