package com.ezmed.bll;

import java.util.List;

/**
 * Created by dearaujk on 7/17/2017.
 */
public class Usuario
{
    public boolean criarNovoUsuario(com.ezmed.dto.Usuario usuario)
    {
        com.ezmed.dal.Usuario dalUsuario = new com.ezmed.dal.Usuario();

        return dalUsuario.criarUsuario(usuario);
    }

    public boolean ativarUsuario(com.ezmed.dto.Usuario usuario)
    {
        com.ezmed.dal.Usuario dalUsuario = new com.ezmed.dal.Usuario();

        return dalUsuario.atualizarUsuario(usuario);
    }

    public boolean desativarUsuario(com.ezmed.dto.Usuario usuario)
    {
        com.ezmed.dal.Usuario dalUsuario = new com.ezmed.dal.Usuario();

        return dalUsuario.atualizarUsuario(usuario);
    }

    public boolean logarUsuario(com.ezmed.dto.Usuario usuario)
    {
        com.ezmed.dal.Usuario dalUsuario = new com.ezmed.dal.Usuario();

        return dalUsuario.localizarUsuario(usuario);
    }

    public com.ezmed.dto.Usuario buscarUsuario(int id)
    {
        com.ezmed.dal.Usuario dalUsuario = new com.ezmed.dal.Usuario();

        return dalUsuario.localizarUsuario(id);
    }

    public com.ezmed.dto.Usuario buscarUsuario(String paramBusca, boolean isUsuario, boolean isEmail, boolean isCelular)
    {
        com.ezmed.dal.Usuario dalUsuario = new com.ezmed.dal.Usuario();

        return dalUsuario.localizarUsuario(paramBusca, isUsuario, isEmail, isCelular);
    }

    public List<com.ezmed.dto.Usuario> todosUsuarios(boolean apenasAtivos)
    {
        com.ezmed.dal.Usuario dalUsuario = new com.ezmed.dal.Usuario();

        return dalUsuario.localizarTodosUsuarios(apenasAtivos);
    }

    public String esqueceuSenha(String paramBusca)
    {
        com.ezmed.dal.Usuario dalUsuario = new com.ezmed.dal.Usuario();

        if (paramBusca.contains("@") && paramBusca.contains("."))
            return dalUsuario.recuperarSenha(paramBusca, true, false);

        return dalUsuario.recuperarSenha(paramBusca, false, true);
    }
}
