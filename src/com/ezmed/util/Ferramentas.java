package com.ezmed.util;

import com.ezmed.dto.Alerta;
import com.ezmed.dto.Cuidador;
import com.ezmed.dto.Paciente;
import com.ezmed.dto.Tratamento;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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

    public static Alerta gerarAlertaRandomico()
    {
        Alerta alerta = new Alerta();

        alerta.setId(gerarIntAleatorio(1, 1000));
        alerta.setHorario(new Date());
        alerta.setObservacao("Observação do alarme " + alerta.getId());

        alerta.setAssistante(gerarCuidadorRandomico());
        alerta.setPaciente(gerarPacienteRandomico());
        alerta.setTratamento(null);

        return alerta;
    }

    public static Cuidador gerarCuidadorRandomico()
    {
        Cuidador cuidador = new Cuidador();

        cuidador.setId(gerarIntAleatorio(1,1000));
        cuidador.setEmail("cuidador_"+cuidador.getId()+"@ezmed.com");
        cuidador.setNome("Cuidador " + cuidador.getId());
        cuidador.setNumeroCelular(String.valueOf(cuidador.getId()));
        cuidador.setObservacao("Observação do cuidador " + cuidador.getId());

        return cuidador;
    }

    public static Paciente gerarPacienteRandomico()
    {
        Paciente paciente = new Paciente();

        paciente.setId(gerarIntAleatorio(1,1000));
        paciente.setAltura(1.90);
        paciente.setPeso(100);
        paciente.setDataNascimento(new Date());
        paciente.setNome("Paciente " + paciente.getId());
        paciente.setEstoque(null);

        return paciente;
    }

    private static int gerarIntAleatorio(int min, int max)
    {
        Random aleatorio = new Random();

        return aleatorio.nextInt(max) + min;
    }

}
