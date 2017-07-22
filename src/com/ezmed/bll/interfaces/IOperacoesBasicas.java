package com.ezmed.bll.interfaces;

import java.util.List;

/**
 * Created by dearaujk on 7/17/2017.
 */
public interface IOperacoesBasicas {

    public boolean cadastrar();
    public boolean remover();
    public boolean atualizar();
    public <T> List<T> consultar();

}
