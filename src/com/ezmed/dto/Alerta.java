package com.ezmed.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Alerta {

    private int id;
    private Date horario;
    private ArrayList<Cuidador> assistantes;
    private Tratamento tratamento;
    private Paciente paciente;
    private String observacao;

    public Alerta(int id, Date horario, ArrayList<Cuidador> assistantes, Tratamento tratamento, Paciente paciente, String observacao) {
        this.id = id;
        this.horario = horario;
        this.assistantes = assistantes;
        this.tratamento = tratamento;
        this.paciente = paciente;
        this.observacao = observacao;
    }

    public Alerta(Date horario, ArrayList<Cuidador> assistantes, Tratamento tratamento, Paciente paciente, String observacao) {
        this.horario = horario;
        this.assistantes = assistantes;
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

    public String getHorarioString() {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try{
            dateString = sdfr.format( horario );
        }catch (Exception ex ){
            System.out.println(ex);
        }
        return dateString;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public ArrayList<Cuidador> getAssistantes()
    {
        return assistantes;
    }

    public void setAssistantes(ArrayList<Cuidador> assistantes)
    {
        this.assistantes = assistantes;
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
