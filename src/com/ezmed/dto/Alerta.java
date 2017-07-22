package com.ezmed.dto;

import java.util.Date;

public class Alerta {

    private int id;
    private Date horario;
    private Cuidador assistante;
    private Tratamento tratamento;
    private Paciente paciente;
    private String observacao;

    public Alerta(int id, Date horario, Cuidador assistante, Tratamento tratamento, Paciente paciente, String observacao) {
        this.id = id;
        this.horario = horario;
        this.assistante = assistante;
        this.tratamento = tratamento;
        this.paciente = paciente;
        this.observacao = observacao;
    }

    public Alerta(Date horario, Cuidador assistante, Tratamento tratamento, Paciente paciente, String observacao) {
        this.horario = horario;
        this.assistante = assistante;
        this.tratamento = tratamento;
        this.paciente = paciente;
        this.observacao = observacao;
    }

    public Alerta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Cuidador getAssistante() {
        return assistante;
    }

    public void setAssistante(Cuidador assistante) {
        this.assistante = assistante;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
