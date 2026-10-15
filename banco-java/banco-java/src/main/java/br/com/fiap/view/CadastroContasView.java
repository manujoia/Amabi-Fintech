package br.com.fiap.view;

import br.com.fiap.dao.ContaDao;
import br.com.fiap.model.Conta;

import java.sql.SQLException;
import java.time.LocalDate;

public class CadastroContasView {

    public static void main(String[] args) {
        try {
            ContaDao dao = new ContaDao();

            // Lembre-se de garantir que os IDs de usuário informados aqui , já existam na tabela T_AM_USUARIO
            for (int i = 1; i <= 5; i++) {
                Conta conta = new Conta(
                        i,                          // id da conta
                        1,                          // id do usuário associado (ajuste conforme os seus usuários)
                        "00" + i,                   // agência
                        "1234" + i + "-8",          // número da conta
                        i % 2 == 0 ? "Poupança" : "Corrente", // tipo de conta alternado
                        1000.00 * i,                // saldo inicial
                        LocalDate.now(),            // data de abertura
                        "A"                         // status ativo
                );

                dao.insert(conta);
            }

            dao.fecharConexao();
            System.out.println("\nTodas as 5 contas foram cadastradas com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar contas: " + e.getMessage());
        }
    }
}