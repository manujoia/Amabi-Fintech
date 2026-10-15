package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class ListaUsuarioView {

    public static void main(String[] args) {
        try {
            // 1. Instancia o DAO (abre a conexão automaticamente)
            UsuarioDao dao = new UsuarioDao();

            // 2. Chama o método getAll para buscar todos os utilizadores do banco
            List<Usuario> listaUsuarios = dao.getAll();

            // 3. Verifica se a lista está vazia
            if (listaUsuarios.isEmpty()) {
                System.out.println("Nenhum utilizador encontrado na base de dados.");
            } else {
                System.out.println("========================================");
                System.out.println("          LISTA DE UTILIZADORES         ");
                System.out.println("========================================");

                // 4. Percorre a lista exibindo cada utilizador
                for (Usuario u : listaUsuarios) {
                    System.out.println("ID: " + u.getId());
                    System.out.println("Nome: " + u.getNome());
                    System.out.println("CPF: " + u.getCpf());
                    System.out.println("E-mail: " + u.getEmail());
                    System.out.println("----------------------------------------");
                }
            }

            // 5. Fecha a conexão com o banco
            dao.fecharConexao();

        } catch (SQLException e) {
            System.err.println("Erro ao listar utilizadores: " + e.getMessage());
        }
    }
}