package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection conexao;

    public UsuarioDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void fecharConexao() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }

    // Método privado parseUsuario (idêntico ao padrão do professor)
    private Usuario parseUsuario(ResultSet result) throws SQLException {
        int id = result.getInt("cd_usuario");
        String nome = result.getString("nm_usuario");
        String cpf = result.getString("nr_cpf");
        String email = result.getString("ds_email");
        String senha = result.getString("ds_senha");

        return new Usuario(id, nome, cpf, email, senha);
    }

    // 1. INSERT (Cadastrar)
    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO T_AM_USUARIO (cd_usuario, nm_usuario, nr_cpf, ds_email, ds_senha, dt_cadastro, st_usuario) " +
                "VALUES (?, ?, ?, ?, ?, SYSDATE, 'A')";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());

            stmt.executeUpdate();
            System.out.println("Utilizador " + usuario.getNome() + " cadastrado com sucesso!");
        }
    }

    // 2. GETALL / LISTAR (Igualzinho ao print da aula do professor)
    public List<Usuario> getAll() throws SQLException {
        String sql = "SELECT * FROM T_AM_USUARIO";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();

        List<Usuario> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseUsuario(result)); // Usando o parseUsuario igual ao parseProduto do professor
        }
        return lista;
    }

    // 3. PESQUISAR POR ID
    public Usuario pesquisar(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "SELECT * FROM T_AM_USUARIO WHERE cd_usuario = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setInt(1, codigo);
            ResultSet result = stm.executeQuery();

            if (!result.next()) {
                throw new EntidadeNaoEcontradaException("Utilizador com código " + codigo + " não encontrado!");
            }

            return parseUsuario(result);
        }
    }

    // 4. UPDATE (Atualizar)
    public void atualizar(Usuario usuario) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "UPDATE T_AM_USUARIO SET nm_usuario = ?, nr_cpf = ?, ds_email = ?, ds_senha = ? WHERE cd_usuario = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getCpf());
            stm.setString(3, usuario.getEmail());
            stm.setString(4, usuario.getSenha());
            stm.setInt(5, usuario.getId());

            int linhasAfetadas = stm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new EntidadeNaoEcontradaException("Não foi possível atualizar. Utilizador não encontrado.");
            }
            System.out.println("Utilizador atualizado com sucesso!");
        }
    }

    // 5. DELETE (Remover)
    public void remover(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "DELETE FROM T_AM_USUARIO WHERE cd_usuario = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setInt(1, codigo);
            int linhasAfetadas = stm.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new EntidadeNaoEcontradaException("Não foi possível excluir. Utilizador não encontrado.");
            }
            System.out.println("Utilizador excluído com sucesso!");
        }
    }
}