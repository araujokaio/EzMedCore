package com.ezmed.bll;

import java.util.List;

public class Paciente {

    public boolean criarNovoPaciente(com.ezmed.dto.Paciente paciente, int idUsuario)
    {
        com.ezmed.dal.Paciente dalPaciente = new com.ezmed.dal.Paciente();

        return dalPaciente.criarPaciente(paciente, idUsuario);
    }

    public com.ezmed.dto.Paciente retornarPaciente(int idUsuario)
    {
        com.ezmed.dal.Paciente dalPaciente = new com.ezmed.dal.Paciente();

        return dalPaciente.localizarPacientePorUsuario(idUsuario);
    }

    public int retornarIdPaciente(int idUsuario)
    {
        com.ezmed.dal.Paciente dalPaciente = new com.ezmed.dal.Paciente();

        com.ezmed.dto.Paciente objPaciente = dalPaciente.localizarPacientePorUsuario(idUsuario);

        return objPaciente.getId();
    }

    public boolean atualizarPaciente(com.ezmed.dto.Paciente paciente)
    {
        com.ezmed.dal.Paciente dalPaciente = new com.ezmed.dal.Paciente();

        return dalPaciente.atualizarPaciente(paciente);
    }
}
