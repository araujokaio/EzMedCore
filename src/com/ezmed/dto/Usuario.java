package com.ezmed.dto;

public class Usuario {

    private int id;
    private String usuario;
    private String email;
    private String senha;
    private String numeroCelular;
    private boolean isAtivo;

    public Usuario() {
    }

    public Usuario(String usuario, String email, String senha, String numeroCelular, boolean isAtivo) {
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.numeroCelular = numeroCelular;
        this.isAtivo = isAtivo;
    }

    public Usuario(int id, String usuario, String email, String senha, String numeroCelular, boolean isAtivo) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.numeroCelular = numeroCelular;
        this.isAtivo = isAtivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
    }
}
