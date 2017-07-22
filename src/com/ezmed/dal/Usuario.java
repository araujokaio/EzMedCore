package com.ezmed.dal;

import java.sql.PreparedStatement;

public class Usuario extends BancoBasico
{
    PreparedStatement comandoInsertUsuario;

    public Usuario()
    {
    }

    public boolean criarUsuario(com.ezmed.dto.Usuario usuario)
    {
        String insertUsuario = "INSERT INTO EZ_USUARIO (USUARIO, EMAIL, SENHA, NUMERO_CELULAR, IS_ATIVO) VALUES (?,?,?,?,?)";
        boolean sucesso;

        try
        {
            PreparedStatement comandoInsertUsuario = getMyConn().prepareStatement(insertUsuario);

            comandoInsertUsuario.setString(1, usuario.getUsuario());
            comandoInsertUsuario.setString(2, usuario.getEmail());
            comandoInsertUsuario.setString(3, usuario.getSenha());
            comandoInsertUsuario.setString(4, usuario.getNumeroCelular());
            comandoInsertUsuario.setString(5, usuario.isAtivo() ? "S" : "N");

            sucesso = comandoInsertUsuario.execute();
        }
        catch (Exception ex)
        {
            System.out.println("Houve um problema para criar o usuário!");
            ex.printStackTrace();
            return false;
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

                return true;
            }
            catch (Exception ex)
            {
                System.out.println("Houve um problema para encerrar a conexão do banco de dados!");
                ex.printStackTrace();
                return true;
                //TODO Metodo de log em arquivo
            }
        }
    }
}
