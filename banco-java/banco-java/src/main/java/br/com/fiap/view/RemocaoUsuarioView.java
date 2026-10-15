package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;

import java.sql.SQLException;

public class RemocaoUsuarioView {

    public static void main(String[] args) {
        try {
            // 1. Instancia o DAO (abre a conexão automaticamente no construtor)
            UsuarioDao dao = new UsuarioDao();

            // 2. Defina o ID do utilizador que deseja apagar da base de dados
            // (Certifique-se de usar um ID que exista, ou teste com um inexistente para ver a exceção)
            int codigoParaRemover = 2;

            System.out.println("A tentar remover o utilizador com o código: " + codigoParaRemover + "...");

            // 3. Executa o método de remoção
            dao.remover(codigoParaRemover);

            // 4. Fecha a conexão com o banco
            dao.fecharConexao();

        } catch (EntidadeNaoEcontradaException e) {
            // Captura o erro caso o ID não seja encontrado na base de dados
            System.err.println("Aviso: " + e.getMessage());
        } catch (SQLException e) {
            // Captura erros gerais de SQL ou de conexão
            System.err.println("Erro de base de dados: " + e.getMessage());
        }
    }
}