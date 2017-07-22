package com.ezmed.dto;

public class Medicamento {

    private int id;
    private String nome;
    private String tipo;

    public Medicamento(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Medicamento(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Medicamento() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
