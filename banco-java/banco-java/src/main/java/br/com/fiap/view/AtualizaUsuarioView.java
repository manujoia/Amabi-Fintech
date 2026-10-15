package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;

public class AtualizaUsuarioView {

    public static void main(String[] args) {
        try {
            // 1. Instancia o DAO (abre a conexão automaticamente no construtor)
            UsuarioDao dao = new UsuarioDao();

            // 2. Cria um objeto Usuario com os NOVOS dados e o ID do registo que deseja alterar
            // (Certifique-se de que o ID informado existe no seu banco de dados)
            int idParaAtualizar = 15;

            Usuario usuarioAtualizado = new Usuario(
                    idParaAtualizar,
                    "Amabili Silva JOIA", // Novo nome
                    "99988877766",             // CPF (pode manter ou alterar)
                    "marcela.nova@email.com",   // Novo e-mail
                    "senha12345"               // Nova senha
            );

            // 3. Executa o método de atualização
            dao.atualizar(usuarioAtualizado);

            // 4. Fecha a conexão com o banco
            dao.fecharConexao();

        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Aviso: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro de base de dados: " + e.getMessage());
        }
    }
}