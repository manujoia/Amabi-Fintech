package br.com.fiap.view;

import br.com.fiap.dao.ContaDao;
import br.com.fiap.model.Conta;

import java.sql.SQLException;
import java.util.List;

public class ListaContaView {

    public static void main(String[] args) {
        try {
            // 1. Instancia o DAO de Contas (abre a conexão automaticamente)
            ContaDao dao = new ContaDao();

            // 2. Chama o método getAll para buscar todas as contas do banco
            List<Conta> listaConta = dao.getAll();

            // 3. Verifica se a lista está vazia
            if (listaConta.isEmpty()) {
                System.out.println("Nenhuma conta encontrada na base de dados.");
            } else {
                System.out.println("========================================");
                System.out.println("          LISTA DE CONTAS               ");
                System.out.println("========================================");

                // 4. Percorre a lista exibindo cada conta
                for (Conta c : listaConta) {
                    System.out.println("ID Conta: " + c.getId());
                    System.out.println("ID Usuário: " + c.getIdUsuario());
                    System.out.println("Agência: " + c.getAgencia());
                    System.out.println("Número da Conta: " + c.getNumeroConta());
                    System.out.println("Tipo: " + c.getTipoConta());
                    System.out.println("Saldo: R$ " + c.getSaldo());
                    System.out.println("Data de Abertura: " + c.getDataAbertura());
                    System.out.println("Status: " + c.getStatus());
                    System.out.println("----------------------------------------");
                }
            }

            // 5. Fecha a conexão com o banco
            dao.fecharConexao();

        } catch (SQLException e) {
            System.err.println("Erro ao listar contas: " + e.getMessage());
        }
    }
}