package com.ezmed.dto;

import java.util.List;
import java.sql.Date;

public class Paciente
{

    private int id;
    private String nome;
    private Date dataNascimento;
    private double peso;
    private double altura;
    private List<Estoque> estoque;

    public Paciente(int id, String nome, Date dataNascimento, double peso, double altura, List<Estoque> estoque)
    {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
        this.estoque = estoque;
    }

    public Paciente(String nome, Date dataNascimento, double peso, double altura, List<Estoque> estoque)
    {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
        this.estoque = estoque;
    }

    public Paciente()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Date getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public double getAltura()
    {
        return altura;
    }

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public List<Estoque> getEstoque()
    {
        return estoque;
    }

    public void setEstoque(List<Estoque> estoque)
    {
        this.estoque = estoque;
    }
}
