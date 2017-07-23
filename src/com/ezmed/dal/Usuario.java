package com.ezmed.dal;

import com.ezmed.util.Ferramentas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends BancoBasico
{
    private PreparedStatement comandoInsertUsuario;
    private PreparedStatement comandoUpdateUsuario;
    private PreparedStatement comandoSelectUsuario;

    public Usuario()
    {
    }

    public boolean criarUsuario(com.ezmed.dto.Usuario usuario)
    {
        String insertUsuario = "INSERT INTO EZ_USUARIO (USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO) VALUES (?,?,?,?,?)";
        boolean sucesso = false;

        try
        {
            comandoInsertUsuario = getMyConn().prepareStatement(insertUsuario);

            comandoInsertUsuario.setString(1, usuario.getUsuario());
            comandoInsertUsuario.setString(2, usuario.getEmail());
            comandoInsertUsuario.setString(3, usuario.getSenha());
            comandoInsertUsuario.setString(4, usuario.getNumeroCelular());
            comandoInsertUsuario.setString(5, Ferramentas.booleanParaString(usuario.isAtivo()));

            sucesso = comandoInsertUsuario.execute();

            return sucesso;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para criar o usuário!");
            ex.printStackTrace();
            return sucesso;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoInsertUsuario != null)
                {
                    comandoInsertUsuario.close();
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

    public boolean atualizarUsuario(com.ezmed.dto.Usuario usuario)
    {
        String updateUsuario = "UPDATE EZ_USUARIO SET USUARIO = ?, EMAIL = ?, SENHA = ?, NUMERO_CELULAR = ?, IS_ATIVO = ? WHERE ID = ?";
        boolean sucesso = false;

        try
        {
            comandoUpdateUsuario = getMyConn().prepareStatement(updateUsuario);

            comandoUpdateUsuario.setString(1, usuario.getUsuario());
            comandoUpdateUsuario.setString(2, usuario.getEmail());
            comandoUpdateUsuario.setString(3, usuario.getSenha());
            comandoUpdateUsuario.setString(4, usuario.getNumeroCelular());
            comandoUpdateUsuario.setString(5, Ferramentas.booleanParaString(usuario.isAtivo()));
            comandoUpdateUsuario.setInt(6, usuario.getId());

            sucesso = comandoUpdateUsuario.execute();

            return sucesso;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para ataulizar o usuário!");
            ex.printStackTrace();
            return sucesso;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoUpdateUsuario != null)
                {
                    comandoUpdateUsuario.close();
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

    public int localizarUsuario(com.ezmed.dto.Usuario usuario)
    {
        ResultSet resultado;
        com.ezmed.dto.Usuario objUsuario = new com.ezmed.dto.Usuario();
        String selectUsuario = "SELECT * FROM EZ_USUARIO WHERE USUARIO = ? AND SENHA = ?";

        try
        {
            comandoSelectUsuario = getMyConn().prepareStatement(selectUsuario);

            comandoSelectUsuario.setString(1, usuario.getUsuario());
            comandoSelectUsuario.setString(2, usuario.getSenha());

            resultado = comandoSelectUsuario.executeQuery();

            if (resultado.next()) return resultado.getInt("ID");

            return 0;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para localizar o usuário!");
            ex.printStackTrace();
            return 0;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoSelectUsuario != null)
                {
                    comandoSelectUsuario.close();
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

    public com.ezmed.dto.Usuario localizarUsuario(int id)
    {
        ResultSet resultado;
        com.ezmed.dto.Usuario objUsuario = new com.ezmed.dto.Usuario();
        String selectUsuario = "SELECT ID, USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO FROM EZ_USUARIO WHERE ID = ?";

        try
        {
            comandoSelectUsuario = getMyConn().prepareStatement(selectUsuario);

            comandoSelectUsuario.setInt(1, id);

            resultado = comandoSelectUsuario.executeQuery();

            while (resultado.next())
            {
                objUsuario.setId(resultado.getInt("ID"));
                objUsuario.setUsuario(resultado.getString("USUARIO"));
                objUsuario.setEmail(resultado.getString("EMAIL"));
                objUsuario.setSenha(resultado.getString("SENHA"));
                objUsuario.setNumeroCelular(resultado.getString("NUMERO_CELULAR"));
                objUsuario.setAtivo(Ferramentas.stringParaBoolean(resultado.getString("IS_ATIVO")));
            }

            return objUsuario;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para localizar o usuário!");
            ex.printStackTrace();
            return objUsuario;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoSelectUsuario != null)
                {
                    comandoSelectUsuario.close();
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

    public com.ezmed.dto.Usuario localizarUsuario(String paramBusca, boolean isUsuario, boolean isEmail, boolean isCelular)
    {
        ResultSet resultado;
        com.ezmed.dto.Usuario objUsuario = new com.ezmed.dto.Usuario();
        String selectUsuario = "";

        if (isUsuario)
            selectUsuario = "SELECT ID, USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO FROM EZ_USUARIO WHERE UPPER(USUARIO) = UPPER(?)";
        else if (isEmail)
            selectUsuario = "SELECT ID, USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO FROM EZ_USUARIO WHERE UPPER(EMAIL) = UPPER(?)";
        else if (isCelular)
            selectUsuario = "SELECT ID, USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO FROM EZ_USUARIO WHERE NUMERO_CELULAR = ?";

        try
        {
            comandoSelectUsuario = getMyConn().prepareStatement(selectUsuario);

            comandoSelectUsuario.setString(1, paramBusca);

            resultado = comandoSelectUsuario.executeQuery();

            while (resultado.next())
            {
                objUsuario.setId(resultado.getInt("ID"));
                objUsuario.setUsuario(resultado.getString("USUARIO"));
                objUsuario.setEmail(resultado.getString("EMAIL"));
                objUsuario.setSenha(resultado.getString("SENHA"));
                objUsuario.setNumeroCelular(resultado.getString("NUMERO_CELULAR"));
                objUsuario.setAtivo(Ferramentas.stringParaBoolean(resultado.getString("IS_ATIVO")));
            }

            return objUsuario;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para ataulizar o usuário!");
            ex.printStackTrace();
            return objUsuario;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoSelectUsuario != null)
                {
                    comandoSelectUsuario.close();
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

    public List<com.ezmed.dto.Usuario> localizarTodosUsuarios(boolean apenasAtivos)
    {
        ResultSet resultado;
        ArrayList<com.ezmed.dto.Usuario> listaUsuarios = new ArrayList<>();

        String selectUsuario = "SELECT ID, USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO FROM EZ_USUARIO";

        if(apenasAtivos)
            selectUsuario = selectUsuario + " WHERE IS_ATIVO = ?";

        try
        {
            comandoSelectUsuario = getMyConn().prepareStatement(selectUsuario);

            if(apenasAtivos)
                comandoSelectUsuario.setString(1, Ferramentas.booleanParaString(apenasAtivos));

            resultado = comandoSelectUsuario.executeQuery();

            while (resultado.next())
            {
                com.ezmed.dto.Usuario objUsuario = new com.ezmed.dto.Usuario();

                objUsuario.setId(resultado.getInt("ID"));
                objUsuario.setUsuario(resultado.getString("USUARIO"));
                objUsuario.setEmail(resultado.getString("EMAIL"));
                objUsuario.setSenha(resultado.getString("SENHA"));
                objUsuario.setNumeroCelular(resultado.getString("NUMERO_CELULAR"));
                objUsuario.setAtivo(resultado.getString("IS_ATIVO").equals("Y"));

                listaUsuarios.add(objUsuario);
            }

            return listaUsuarios;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para localizar os usuários!");
            ex.printStackTrace();
            return listaUsuarios;
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoSelectUsuario != null)
                {
                    comandoSelectUsuario.close();
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

    public String recuperarSenha(String paramBusca, boolean isEmail, boolean isCelular)
    {
        ResultSet resultado;
        String senha = "";
        String selectUsuario = "";

        if (isEmail)
            selectUsuario = "SELECT ID, USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO FROM EZ_USUARIO WHERE UPPER(EMAIL) = UPPER(?)";
        else if (isCelular)
            selectUsuario = "SELECT ID, USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO FROM EZ_USUARIO WHERE NUMERO_CELULAR = ?";

        try
        {
            comandoSelectUsuario = getMyConn().prepareStatement(selectUsuario);

            comandoSelectUsuario.setString(1, paramBusca);

            resultado = comandoSelectUsuario.executeQuery();

            if (resultado.next())
            {
                senha = resultado.getString("SENHA");
            }

            return senha;
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para recuperar a senha!");
            ex.printStackTrace();
            return "";
            //TODO Metodo de log em arquivo
        }
        finally
        {
            try
            {
                if (comandoSelectUsuario != null)
                {
                    comandoSelectUsuario.close();
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
