package br.com.fiap.view;

import br.com.fiap.dao.CartaoDao;
import br.com.fiap.model.Cartao;

import java.sql.SQLException;
import java.time.LocalDate;

public class CadastraCartaoView {

    public static void main(String[] args) {
        try {
            // 1. Instancia o DAO (abre a conexão automaticamente)
            CartaoDao dao = new CartaoDao();

            // 2. Cria um novo objeto Cartao com os dados que deseja inserir
            // (Certifique-se de que o idConta informado já existe na tabela T_AM_CONTA)
            Cartao cartao = new Cartao(
                    2,                              // ID do cartão
                    2,                             // ID da conta associada
                    "4321",                           // 4 dígitos finais
                    "A",                              //nome impresso no cartão
                    "Crédito",                        // Tipo do cartão
                    4000.00,                          // Limite total
                    2500.00,                          // Limite disponível
                    LocalDate.now().plusYears(3),     // Data de validade
                    "A"                               // Status (Ativo)
            );

            // 3. Executa o método de inserção
            dao.insert(cartao);

            // 4. Fecha a conexão com o banco
            dao.fecharConexao();

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cartão: " + e.getMessage());
        }
    }
}