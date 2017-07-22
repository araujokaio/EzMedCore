package com.ezmed.dto;

import java.util.Date;

public class Tratamento {

    private int id;
    private Medicamento medicamento;
    private  double dose;
    private Date inicio;
    private Date fim;
    private String observacao;

    public Tratamento(int id, Medicamento medicamento, double dose, Date inicio, Date fim, String observacao) {
        this.id = id;
        this.medicamento = medicamento;
        this.dose = dose;
        this.inicio = inicio;
        this.fim = fim;
        this.observacao = observacao;
    }

    public Tratamento(Medicamento medicamento, double dose, Date inicio, Date fim, String observacao) {
        this.medicamento = medicamento;
        this.dose = dose;
        this.inicio = inicio;
        this.fim = fim;
        this.observacao = observacao;
    }

    public Tratamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
