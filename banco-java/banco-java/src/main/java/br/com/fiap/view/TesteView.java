package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class TesteView {

    public static void main(String[] args) throws SQLException {
        UsuarioDao dao = new UsuarioDao();

        System.out.println("=== CADASTRANDO 5 UTILIZADORES ==----");

        // Cadastrando  utilizadores diferentes

        dao.insert(new Usuario(3, "Carla Dias", "33333333333", "carla@email.com", "senha789"));
        dao.insert(new Usuario(4, "Daniel Alves", "44444444444", "daniel@email.com", "senhaabc"));
        dao.insert(new Usuario(5, "Elaine Cristina", "55555555555", "elaine@email.com", "senhaxyz"));

        System.out.println("\n=== CONSULTANDO TODOS OS UTILIZADORES (getAll) ===");

        List<Usuario> usuarios = dao.getAll();
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() +
                    " | Nome: " + u.getNome() +
                    " | CPF: " + u.getCpf() +
                    " | E-mail: " + u.getEmail());
        }
    }
}