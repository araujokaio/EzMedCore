package com.ezmed.dal;

import com.ezmed.dto.Usuario;
import com.ezmed.util.Ferramentas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends BancoBasico
{
    private PreparedStatement comandoInsertPaciente;
    private PreparedStatement comandoUpdatePaciente;
    private PreparedStatement comandoSelectPaciente;

    public Paciente()
    {
    }

    public boolean criarPaciente(com.ezmed.dto.Paciente paciente, int idUsuario)
    {
        String insertPaciente = "INSERT INTO EZ_PACIENTE (ID_USUARIO, NOME, DATA_NASCIMENTO, PESO, ALTURA) VALUES (?, ?, ?, ?, ?)";
        boolean sucesso = false;

        try
        {
            comandoInsertPaciente = getMyConn().prepareStatement(insertPaciente);

            comandoInsertPaciente.setInt(1, idUsuario);
            comandoInsertPaciente.setString(2, paciente.getNome());
            comandoInsertPaciente.setDate(3, paciente.getDataNascimento());
            comandoInsertPaciente.setDouble(4, paciente.getPeso());
            comandoInsertPaciente.setDouble(4, paciente.getAltura());

            sucesso = comandoInsertPaciente.execute();

            return sucesso;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para criar o paciente!");
            ex.printStackTrace();
            return sucesso;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoInsertPaciente != null)
                {
                    comandoInsertPaciente.close();
                }

                if (getMyConn() != null)
                {
                    getMyConn().close();
                }
            }
            catch (Exception ex)
            {
                System.out.println("Houve um problema para encerrar a conexão do banco de dados!");
                ex.printStackTrace();
                //TODO Metodo de log em arquivo
            }
        }
    }

    public boolean atualizarPaciente(com.ezmed.dto.Paciente paciente)
    {
        String updatePaciente = "UPDATE EZ_PACIENTE SET NOME = ?, DATA_NASCIMENTO = ?, PESO = ?, ALTURA = ? WHERE ID = ?";
        boolean sucesso = false;

        try
        {
            comandoUpdatePaciente = getMyConn().prepareStatement(updatePaciente);

            comandoInsertPaciente.setString(1, paciente.getNome());
            comandoInsertPaciente.setDate(2, paciente.getDataNascimento());
            comandoInsertPaciente.setDouble(3, paciente.getPeso());
            comandoInsertPaciente.setDouble(4, paciente.getAltura());
            comandoInsertPaciente.setInt(5, paciente.getId());

            sucesso = comandoUpdatePaciente.execute();

            return sucesso;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para ataulizar o paciente!");
            ex.printStackTrace();
            return sucesso;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoUpdatePaciente != null)
                {
                    comandoUpdatePaciente.close();
                }

                if (getMyConn() != null)
                {
                    getMyConn().close();
                }
            }
            catch (Exception ex)
            {
                System.out.println("Houve um problema para encerrar a conexão do banco de dados!");
                ex.printStackTrace();
                //TODO Metodo de log em arquivo
            }
        }
    }

    public com.ezmed.dto.Paciente localizarPaciente(int id)
    {
        ResultSet resultado;
        com.ezmed.dto.Paciente objPaciente = new com.ezmed.dto.Paciente();
        String selectUsuario = "SELECT ID, NOME, DATA_NASCIMENTO, PESO, ALTURA FROM EZ_PACIENTE WHERE ID = ?";

        try
        {
            comandoSelectPaciente = getMyConn().prepareStatement(selectUsuario);

            comandoSelectPaciente.setInt(1, id);

            resultado = comandoSelectPaciente.executeQuery();

            while (resultado.next())
            {
                objPaciente.setId(resultado.getInt("ID"));
                objPaciente.setNome(resultado.getString("NOME"));
                objPaciente.setDataNascimento(resultado.getDate("DATA_NASCIMENTO"));
                objPaciente.setPeso(resultado.getDouble("PESO"));
                objPaciente.setAltura(resultado.getDouble("ALTURA"));
            }

            return objPaciente;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para localizar o paciente!");
            ex.printStackTrace();
            return objPaciente;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoSelectPaciente != null)
                {
                    comandoSelectPaciente.close();
                }

                if (getMyConn() != null)
                {
                    getMyConn().close();
                }
            }
            catch (Exception ex)
            {
                System.out.println("Houve um problema para encerrar a conexão do banco de dados!");
                ex.printStackTrace();
                //TODO Metodo de log em arquivo
            }
        }
    }

    public com.ezmed.dto.Paciente localizarPacientePorUsuario(int idUsuario)
    {
        ResultSet resultado;
        com.ezmed.dto.Paciente objPaciente = new com.ezmed.dto.Paciente();
        String selectUsuario = "SELECT ID, NOME, DATA_NASCIMENTO, PESO, ALTURA FROM EZ_PACIENTE WHERE ID_USUARIO = ?";

        try
        {
            comandoSelectPaciente = getMyConn().prepareStatement(selectUsuario);

            comandoSelectPaciente.setInt(1, idUsuario);

            resultado = comandoSelectPaciente.executeQuery();

            while (resultado.next())
            {
                objPaciente.setId(resultado.getInt("ID"));
                objPaciente.setNome(resultado.getString("NOME"));
                objPaciente.setDataNascimento(resultado.getDate("DATA_NASCIMENTO"));
                objPaciente.setPeso(resultado.getDouble("PESO"));
                objPaciente.setAltura(resultado.getDouble("ALTURA"));
            }

            return objPaciente;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para localizar o paciente!");
            ex.printStackTrace();
            return objPaciente;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoSelectPaciente != null)
                {
                    comandoSelectPaciente.close();
                }

                if (getMyConn() != null)
                {
                    getMyConn().close();
                }
            }
            catch (Exception ex)
            {
                System.out.println("Houve um problema para encerrar a conexão do banco de dados!");
                ex.printStackTrace();
                //TODO Metodo de log em arquivo
            }
        }
    }

    public List<com.ezmed.dto.Paciente> localizarTodosPaciente(boolean apenasAtivos)
    {
        ResultSet resultado;
        ArrayList<com.ezmed.dto.Paciente> listaPacientes = new ArrayList<>();

        String selectUsuario = "SELECT ID, NOME, DATA_NASCIMENTO, PESO, ALTURA FROM EZ_PACIENTE";

        if(apenasAtivos)
            selectUsuario = selectUsuario + " WHERE IS_ATIVO = ?";

        try
        {
            comandoSelectPaciente = getMyConn().prepareStatement(selectUsuario);

            if(apenasAtivos)
                comandoSelectPaciente.setString(1, Ferramentas.booleanParaString(apenasAtivos));

            resultado = comandoSelectPaciente.executeQuery();

            while (resultado.next())
            {
                com.ezmed.dto.Paciente objPaciente = new com.ezmed.dto.Paciente();

                objPaciente.setId(resultado.getInt("ID"));
                objPaciente.setNome(resultado.getString("NOME"));
                objPaciente.setDataNascimento(resultado.getDate("DATA_NASCIMENTO"));
                objPaciente.setPeso(resultado.getDouble("PESO"));
                objPaciente.setAltura(resultado.getDouble("ALTURA"));

                listaPacientes.add(objPaciente);
            }

            return listaPacientes;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para localizar os pacientes!");
            ex.printStackTrace();
            return listaPacientes;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoSelectPaciente != null)
                {
                    comandoSelectPaciente.close();
                }

                if (getMyConn() != null)
                {
                    getMyConn().close();
                }
            }
            catch (Exception ex)
            {
                System.out.println("Houve um problema para encerrar a conexão do banco de dados!");
                ex.printStackTrace();
                //TODO Metodo de log em arquivo
            }
        }
    }
}
