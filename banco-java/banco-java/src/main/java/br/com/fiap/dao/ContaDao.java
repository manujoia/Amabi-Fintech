package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Conta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {

    private Connection conexao;

    public ContaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void fecharConexao() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }

    // Método privado parseConta
    private Conta parseConta(ResultSet result) throws SQLException {
        int id = result.getInt("cd_conta");
        int idUsuario = result.getInt("cd_usuario");
        String agencia = result.getString("nr_agencia");
        String numeroConta = result.getString("nr_conta");
        String tipoConta = result.getString("tp_conta");
        double saldo = result.getDouble("vl_saldo");

        // Tratamento da data do banco para LocalDate
        Date sqlDate = result.getDate("dt_abertura");
        LocalDate dataAbertura = (sqlDate != null) ? sqlDate.toLocalDate() : null;

        String status = result.getString("st_conta");

        return new Conta(id, idUsuario, agencia, numeroConta, tipoConta, saldo, dataAbertura, status);
    }

    // 1. INSERT (Cadastrar Conta)
    public void insert(Conta conta) throws SQLException {
        String sql = "INSERT INTO T_AM_CONTA (cd_conta, cd_usuario, nr_agencia, nr_conta, tp_conta, vl_saldo, dt_abertura, st_conta) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, conta.getId());
            stmt.setInt(2, conta.getIdUsuario());
            stmt.setString(3, conta.getAgencia());
            stmt.setString(4, conta.getNumeroConta());
            stmt.setString(5, conta.getTipoConta());
            stmt.setDouble(6, conta.getSaldo());
            stmt.setDate(7, Date.valueOf(conta.getDataAbertura()));
            stmt.setString(8, conta.getStatus());

            stmt.executeUpdate();
            System.out.println("Conta " + conta.getNumeroConta() + " cadastrada com sucesso!");
        }
    }

    // 2. GETALL (Listar Contas)
    public List<Conta> getAll() throws SQLException {
        String sql = "SELECT * FROM T_AM_CONTA";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();

        List<Conta> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseConta(result));
        }
        return lista;
    }

    // 3. PESQUISAR POR ID
    public Conta pesquisar(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "SELECT * FROM T_AM_CONTA WHERE cd_conta = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setInt(1, codigo);
            ResultSet result = stm.executeQuery();

            if (!result.next()) {
                throw new EntidadeNaoEcontradaException("Conta com código " + codigo + " não encontrada!");
            }

            return parseConta(result);
        }
    }

    // 4. ATUALIZAR
    public void atualizar(Conta conta) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "UPDATE T_AM_CONTA SET nr_agencia = ?, nr_conta = ?, tp_conta = ?, vl_saldo = ?, st_conta = ? WHERE cd_conta = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, conta.getAgencia());
            stm.setString(2, conta.getNumeroConta());
            stm.setString(3, conta.getTipoConta());
            stm.setDouble(4, conta.getSaldo());
            stm.setString(5, conta.getStatus());
            stm.setInt(6, conta.getId());

            int linhasAfetadas = stm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new EntidadeNaoEcontradaException("Não foi possível atualizar. Conta não encontrada.");
            }
            System.out.println("Conta atualizada com sucesso!");
        }
    }

    // 5. REMOVER
    public void remover(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "DELETE FROM T_AM_CONTA WHERE cd_conta = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setInt(1, codigo);
            int linhasAfetadas = stm.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new EntidadeNaoEcontradaException("Não foi possível excluir. Conta não encontrada.");
            }
            System.out.println("Conta excluída com sucesso!");
        }
    }
}