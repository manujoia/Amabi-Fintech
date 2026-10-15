package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class App
{
    public static void main( String[] args )
    {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada com sucesso!");
            conexao.close(); // Fecha a conexão após o uso
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }
}