package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Cartao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartaoDao {

    private Connection conexao;

    public CartaoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void fecharConexao() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }

    // Método privado parseCartao com o nome correto da coluna
    private Cartao parseCartao(ResultSet result) throws SQLException {
        int id = result.getInt("cd_cartao");
        int idConta = result.getInt("cd_conta");
        String finalCartao = result.getString("nr_final_cartao");
        String nomeImpresso = result.getString("nr_impresso");
        String tipoCartao = result.getString("tp_cartao");
        double limiteTotal = result.getDouble("vl_limite_total");
        double limiteDisponivel = result.getDouble("vl_limite_disponivel"); // Corrigido aqui

        Date sqlDate = result.getDate("dt_validade");
        LocalDate dataValidade = (sqlDate != null) ? sqlDate.toLocalDate() : null;

        String status = result.getString("st_cartao");

        return new Cartao(id, idConta, finalCartao, nomeImpresso, tipoCartao, limiteTotal, limiteDisponivel, dataValidade, status);
    }

    // 1. INSERT (Cadastrar Cartão)
    public void insert(Cartao cartao) throws SQLException {
        String sql = "INSERT INTO T_AM_CARTAO (cd_cartao, cd_conta, nr_final_cartao, nr_impresso, tp_cartao, vl_limite_total, vl_limite_disponivel, dt_validade, st_cartao) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Corrigido aqui

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cartao.getId());
            stmt.setInt(2, cartao.getIdConta());
            stmt.setString(3, cartao.getFinalCartao());
            stmt.setString(4, cartao.getNomeImpresso());
            stmt.setString(5, cartao.getTipoCartao());
            stmt.setDouble(6, cartao.getLimiteTotal());
            stmt.setDouble(7, cartao.getLimiteDisponivel());
            stmt.setDate(8, Date.valueOf(cartao.getDataValidade()));
            stmt.setString(9, cartao.getStatus());

            stmt.executeUpdate();
            System.out.println("Cartão final " + cartao.getFinalCartao() + " cadastrado com sucesso!");
        }
    }

    // 2. GETALL (Listar Cartões)
    public List<Cartao> getAll() throws SQLException {
        String sql = "SELECT * FROM T_AM_CARTAO";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();

        List<Cartao> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseCartao(result));
        }
        return lista;
    }

    // 3. PESQUISAR POR ID
    public Cartao pesquisar(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "SELECT * FROM T_AM_CARTAO WHERE cd_cartao = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setInt(1, codigo);
            ResultSet result = stm.executeQuery();

            if (!result.next()) {
                throw new EntidadeNaoEcontradaException("Cartão com código " + codigo + " não encontrado!");
            }

            return parseCartao(result);
        }
    }

    // 4. ATUALIZAR
    public void atualizar(Cartao cartao) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "UPDATE T_AM_CARTAO SET nr_final_cartao = ?, nr_impresso = ?, tp_cartao = ?, vl_limite_total = ?, vl_limite_disponivel = ?, st_cartao = ? WHERE cd_cartao = ?"; // Corrigido aqui

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, cartao.getFinalCartao());
            stm.setString(2, cartao.getNomeImpresso());
            stm.setString(3, cartao.getTipoCartao());
            stm.setDouble(4, cartao.getLimiteTotal());
            stm.setDouble(5, cartao.getLimiteDisponivel());
            stm.setString(6, cartao.getStatus());
            stm.setInt(7, cartao.getId());

            int linhasAfetadas = stm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new EntidadeNaoEcontradaException("Não foi possível atualizar. Cartão não encontrado.");
            }
            System.out.println("Cartão atualizado com sucesso!");
        }
    }

    // 5. REMOVER
    public void remover(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "DELETE FROM T_AM_CARTAO WHERE cd_cartao = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setInt(1, codigo);
            int linhasAfetadas = stm.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new EntidadeNaoEcontradaException("Não foi possível excluir. Cartão não encontrado.");
            }
            System.out.println("Cartão excluído com sucesso!");
        }
    }
}