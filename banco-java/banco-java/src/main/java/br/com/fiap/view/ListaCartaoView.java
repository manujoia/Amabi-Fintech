package br.com.fiap.view;

import br.com.fiap.dao.CartaoDao;
import br.com.fiap.model.Cartao;

import java.sql.SQLException;
import java.util.List;

public class ListaCartaoView {

    public static void main(String[] args) {
        try {
            CartaoDao dao = new CartaoDao();

            List<Cartao> listaCartoes = dao.getAll();

            if (listaCartoes.isEmpty()) {
                System.out.println("Nenhum cartão encontrado na base de dados.");
            } else {
                System.out.println("========================================");
                System.out.println("          LISTA DE CARTÕES              ");
                System.out.println("========================================");

                for (Cartao c : listaCartoes) {
                    System.out.println("ID Cartão: " + c.getId());
                    System.out.println("ID Conta: " + c.getIdConta());
                    System.out.println("Final: " + c.getFinalCartao());
                    System.out.println("Impresso: " + c.getNomeImpresso());
                    System.out.println("Tipo: " + c.getTipoCartao());
                    System.out.println("Limite Total: R$ " + c.getLimiteTotal());
                    System.out.println("Validade: " + c.getDataValidade());
                    System.out.println("Status: " + c.getStatus());
                    System.out.println("----------------------------------------");
                }
            }

            dao.fecharConexao();

        } catch (SQLException e) {
            System.err.println("Erro ao listar cartões: " + e.getMessage());
        }
    }
}