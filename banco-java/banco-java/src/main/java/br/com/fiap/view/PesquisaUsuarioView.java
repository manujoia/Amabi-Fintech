package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.model.Usuario;
import java.sql.SQLException;

public class PesquisaUsuarioView { // ou o nome que você deu à sua classe

    public static void main(String[] args) {
        try {
            // Instancia o DAO (onde o Java exige o try-catch por causa do throws SQLException)
            UsuarioDao dao = new UsuarioDao();

            int codigoProcurado = 1; // ID que deseja buscar
            Usuario usuario = dao.pesquisar(codigoProcurado);

            // Imprime todas as informações detalhadas do utilizador
            System.out.println("\n--- Informações do Utilizador ---");
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("E-mail: " + usuario.getEmail());
            // Se quiser adicionar os outros campos no futuro:
            // System.out.println("Status: " + usuario.getStatus());

            dao.fecharConexao();

        } catch (SQLException e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Aviso: " + e.getMessage());
        }
    }
}