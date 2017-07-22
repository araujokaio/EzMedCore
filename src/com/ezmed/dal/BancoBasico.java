package com.ezmed.dal;

import java.sql.DriverManager;
import java.sql.Connection;
import com.ezmed.util.*;

public class BancoBasico
{
    public BancoBasico()
    {
    }

    protected Connection getMyConn()
    {
        Connection myConn;

        try {
            Class.forName(Ferramentas.lerPropriedade("bancodedados_driver"));
        } catch (ClassNotFoundException e) {
            System.out.println("Houve um problema para registar o Postgresql JDBC Driver!");
            e.printStackTrace();
            return null;
            //TODO Metodo de log em arquivo
        }

        try {
            myConn = DriverManager.getConnection(Ferramentas.lerPropriedade("bancodedados_url"),
                    Ferramentas.lerPropriedade("bancodedados_usuario"),
                    Ferramentas.lerPropriedade("bancodedados_senha"));
        } catch (Exception e) {
            System.out.println("Houve um problema para conectar-se ao banco de dados!");
            e.printStackTrace();
            return null;
            //TODO Metodo de log em arquivo
        }

        return myConn;
    }
}
