package com.ezmed.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Properties;

public class Ferramentas
{
    public Ferramentas()
    {
    }

    public static String lerPropriedade(String caminhoArquivo, String nomePropriedade)
    {
        Properties prop = new Properties();
        InputStream input = null;
        String saida = "";

        try
        {
            input = new FileInputStream(caminhoArquivo);

            prop.load(input);
            saida = prop.getProperty(nomePropriedade);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            //TODO Metodo de log em arquivo
        }
        finally
        {
            if(input != null)
            {
                try
                {
                    input.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }

            return saida;
        }
    }

    public static String lerPropriedade(String nomePropriedade)
    {
        Properties prop = new Properties();
        InputStream input = null;
        String saida = "";

        try
        {
            input = new FileInputStream("config.properties");

            prop.load(input);
            saida = prop.getProperty(nomePropriedade);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            //TODO Metodo de log em arquivo
        }
        finally
        {
            if(input != null)
            {
                try
                {
                    input.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }

            return saida;
        }
    }

    public static Timestamp getTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new Timestamp(today.getTime());
    }
}
