package br.com.fiap.view;

import br.com.fiap.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroUsuarioView {

    public static void main(String[] args) {
        // SQL com os ? para preenchimento seguro
        String sql = "INSERT INTO T_AM_USUARIO (cd_usuario, nm_usuario, nr_cpf, ds_email, ds_senha, dt_cadastro, st_usuario) " +
                "VALUES (?, ?, ?, ?, ?, SYSDATE, 'A')";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, 15); //
            stmt.setString(2, "Amabili Silva");
            stmt.setString(3, "99988877766"); // Mude o CPF para um número diferente
            stmt.setString(4, "amabili.novo@email.com"); // Mude o e-mail para um diferente
            stmt.setString(5, "123456");

            stmt.executeUpdate();
            System.out.println("Utilizador cadastrado com sucesso na Amabi!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar utilizador: " + e.getMessage());
        }
    }
}