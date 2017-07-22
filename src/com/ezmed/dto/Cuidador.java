package com.ezmed.dto;

public class Cuidador {

    private int id;
    private String nome;
    private int numeroCelular;
    private String email;
    private String observacao;

    public Cuidador(int id, String nome, int numeroCelular, String email, String observacao) {
        this.id = id;
        this.nome = nome;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.observacao = observacao;
    }

    public Cuidador(String nome, int numeroCelular, String email, String observacao) {
        this.nome = nome;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.observacao = observacao;
    }

    public Cuidador() {
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

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
