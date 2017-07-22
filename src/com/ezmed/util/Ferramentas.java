package com.ezmed.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSource;
import java.sql.Timestamp;
import java.util.Properties;

public class Ferramentas
{
    public Ferramentas()
    {
    }

    public static String lerPropriedade(String nomeArquivo, String nomePropriedade)
    {
        Properties prop = new Properties();
        InputStream input = null;
        String saida = "";

        try
        {
            CodeSource src = Ferramentas.class.getProtectionDomain().getCodeSource();
            URL url = new URL(src.getLocation(), nomeArquivo);

            input = new FileInputStream(url.getFile());

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
            CodeSource src = Ferramentas.class.getProtectionDomain().getCodeSource();
            URL url = new URL(src.getLocation(), "config.properties");

            input = new FileInputStream(url.getFile());

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

    public static String booleanParaString(boolean propriedade)
    {
        return propriedade ? "S" : "N";
    }

    public static boolean stringParaBoolean(String propriedade)
    {
        return propriedade.equals("S");
    }
}
